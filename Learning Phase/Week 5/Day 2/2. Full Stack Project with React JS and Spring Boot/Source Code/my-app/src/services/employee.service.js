import httpClient from "../http-common";

function sleeper(ms) {
  return function(x) {
    return new Promise(resolve => setTimeout(() => resolve(x), ms));
  };
}

const getAll = () => {
 
  return httpClient.get("/employees").then(sleeper(5000)) ;
};

const get = (id) => {
  return httpClient.get(`/employees/${id}`);
};

const create = (data) => {
  return httpClient.post("/employees", data);
};

const update = (data) => {
  return httpClient.put("/employees", data);
};

const remove = (id) => {
  return httpClient.delete(`/employees/${id}`);
};

export default { getAll, create, get, update, remove };
