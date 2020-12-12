import http from "../http-common";

class MessageDataService {
  getAll() {
    return http.get("/messages");
  }

  create(data) {
    return http.post("/messages", data);
  }

}

export default new MessageDataService();