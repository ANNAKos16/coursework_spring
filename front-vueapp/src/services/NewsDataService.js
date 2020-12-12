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

}

export default new NewsDataService();