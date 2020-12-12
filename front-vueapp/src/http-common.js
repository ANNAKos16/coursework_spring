import axios from "axios";

export default axios.create({
  baseURL: "http://localhost:8082/api",
  headers: {
    "Accept": "*",
    "Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE, OPTIONS",
    "Access-Control-Allow-Headers": "Access-Control-Allow-Headers, Authorization, Content-Type, Content-Range, Content-Disposition, Content-Description, sessionId, Origin, Accept, X-Requested-With, Access-Control-Request-Method, Access-Control-Request-Headers",
    "Content-type": "application/json"
  }
});