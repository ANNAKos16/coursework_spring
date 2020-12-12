<template>
  <div class="vue-horizontal-list" ref="container">
    <div class="vhl-navigation" v-if="width.window > _options.navigation.start">
      <div @click="prev" v-if="_hasPrev"
           class="vhl-btn-left">
        <img src="../../assets/left_arrox.svg"/>
      </div>

      <div @click="next" v-if="_hasNext"
           class="vhl-btn-right">
        <img src="../../assets/right_arrox.svg"/>
      </div>
    </div>

    <div class="vhl-container" :style="_style.container">
      <div class="vhl-list" ref="list" :class="_options.list.class" :style="_style.list">
        <div v-for="item in items" :key="item.title" ref="item" class="vhl-item" :class="_options.item.class" :style="_style.item">
          <slot v-bind:item="item">{{item}}</slot>
        </div>

        <div :style="_style.tail">
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "VueHorizontalList",
    props: {
      /**
       * items to display in horizontal-list
       */
      items: {
        type: Array,
        required: true
      },
      
      options: {
        type: Object,
        required: false
      }
    },
    data() {
      return {
        position: 0,
        
        width: {
          container: 0,
          window: 576
        }
      }
    },
    mounted() {
      this.$resize = () => {
        this.width.window = window.innerWidth
        this.width.container = this.$refs.container.clientWidth
      }
      // Added a simple SSR fix, need to look into it for optimization in the future
      require('smoothscroll-polyfill').polyfill();
      this.$resize()
      window.addEventListener('resize', this.$resize)
    },
    beforeDestroy() {
      window.removeEventListener('resize', this.$resize)
    },
    computed: {
      _options() {
        const options = this.options
        return {
          navigation: {
            start: options?.navigation?.start ?? 992,
            color: options?.navigation?.color ?? '#000',
          },
          item: {
            class: options?.item?.class ?? '',
            padding: options?.item?.padding ?? 16,
          },
          list: {
            class: options?.list?.class ?? '',
            windowed: options?.list?.windowed ?? 1200,
            padding: options?.list?.padding ?? 24,
          },
          responsive: [
            ...(options?.responsive ?? []),
            // Fallback default responsive
            {end: 576, size: 1},
            {start: 576, end: 768, size: 2},
            {start: 768, end: 992, size: 3},
            {start: 992, end: 1200, size: 4},
            {start: 1200, size: 5},
          ],
        }
      },
      _style() {
        const style = {
          container: {},
          list: {},
          item: {},
          tail: {}
        }
        const workingWidth = this._workingWidth
        const size = this._size
        // Full Screen Mode
        if (this.width.window < this._options.list.windowed) {
          style.container.marginLeft = `-${this._options.list.padding}px`
          style.container.marginRight = `-${this._options.list.padding}px`
          style.item.width = `${(workingWidth - (size - 1) * this._options.item.padding) / size}px`
          style.item.paddingLeft = `${this._options.list.padding}px`
          style.item.paddingRight = `${this._options.item.padding}px`
          style.item.marginRight = `-${this._options.list.padding}px`
        }
        // Windowed Mode
        else {
          style.item.paddingLeft = `${this._options.item.padding / 2}px`
          style.item.paddingRight = `${this._options.item.padding / 2}px`
          style.container.marginLeft = `-${this._options.item.padding / 2}px`
          style.container.marginRight = `-${this._options.item.padding / 2}px`
          style.item.width = `${(workingWidth - (size - 1) * this._options.item.padding) / size}px`
        }
        return style
      },
      _itemWidth() {
        return (this._workingWidth - (this._size - 1) * this._options.item.padding) / this._size
      },
      /**
       * @return number actual width of the container
       */
      _workingWidth() {
        // Full Screen Mode
        if (this.width.window < this._options.list.windowed) {
          return this.width.window - this._options.list.padding * 2
        }
        // Windowed Mode
        else {
          return this.width.container
        }
      },
      /**
       * @return visible items in horizontal list at the current width/state
       */
      _size() {
        const width = this._workingWidth
        return this._options.responsive.find(value => {
          return (!value.start || value.start <= width) && (!value.end || value.end >= width)
        }).size
      },
      /**
       * @return boolean whether there is prev set of items for navigation
       * @private internal use
       */
      _hasNext() {
        return this.items.length > this.position + this._size
      },
      /**
       * @return boolean whether there is next set of items for navigation
       * @private internal use
       */
      _hasPrev() {
        return this.position > 0
      },
    },
    methods: {
      /**
       * @param position of item to scroll to
       */
      go(position) {
        const maxPosition = this.items.length - this._size
        this.position = position > maxPosition ? maxPosition : position
        const left = this._itemWidth * this.position + this.position * this._options.item.padding
        this.$refs.list.scrollTo({top: 0, left: left, behavior: 'smooth'})
      },
      /**
       * Go to a set of previous items
       */
      prev() {
        this.go(this.position - this._size)
      },
      /**
       * Go to a set of next items
       */
      next() {
        this.go(this.position + this._size)
      },
    }
  }
</script>
<style scoped>
  .vue-horizontal-list {
    position: relative;
  }
  .vhl-navigation {
    display: flex;
    align-items: center;
    position: absolute;
    width: 100%;
    height: 100%;
  }
  .vhl-btn-left, .vhl-btn-right {
    width: 48px;
    height: 48px;
    display: flex;
    align-items: center;
    justify-content: center;
    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
    z-index: 2;
  }
  .vhl-btn-left:hover, .vhl-btn-right:hover {
    cursor: pointer;
  }
  .vhl-btn-left {
    margin-left: -64px;
    margin-right: auto;
  }
  .vhl-btn-right {
    margin-left: auto;
    margin-right: -64px;
  }
  .vhl-container {
    overflow-y: hidden;
    height: 100%;
    margin-bottom: -24px;
  }
  .vhl-list {
    display: flex;
    padding-bottom: 24px;
    margin-bottom: -24px;
    overflow-x: scroll;
    overflow-y: hidden;
    scroll-behavior: smooth;
    -webkit-overflow-scrolling: touch;
    scroll-snap-type: x mandatory;
  }
  .vhl-item {
    box-sizing: content-box;
    padding-top: 24px;
    padding-bottom: 24px;
  }
  .vhl-list > * {
    scroll-snap-align: start;
    flex-shrink: 0;
  }
  .vhl-item {
    z-index: 1;
  }
</style>