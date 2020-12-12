import http from "../http-common";

class GameDataService {
  getAll() {
    return http.get("/games");
  }
}

export default new GameDataService();