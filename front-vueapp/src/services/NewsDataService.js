import http from "../http-common";

class NewsDataService {
  getAll() {
    return http.get("/news");
  }

  getPhotos(id) {
    return http.get(`/photos/${id}`);
  }

  create(data) {
    return http.post("/news", data);
  }

  update(id, data) {
    return http.put(`/news/${id}`, data);
  }

  delete(id) {
    return http.delete(`/news/${id}`);
  }

}

export default new NewsDataService();