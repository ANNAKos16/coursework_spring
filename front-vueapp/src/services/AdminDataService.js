import http from "../http-common";

class AdminDataService {
  
  findUser(password) {
    return http.get(`/user?password=${password}`);
  }
}

export default new AdminDataService();