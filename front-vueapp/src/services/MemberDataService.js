import http from "../http-common";

class MemberDataService {
  getAll() {
    return http.get("/members");
  }
}

export default new MemberDataService();