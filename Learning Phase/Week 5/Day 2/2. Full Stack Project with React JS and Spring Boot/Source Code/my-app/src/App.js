import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import EmployeeList from "./components/EmployeeList";
import "bootstrap/dist/css/bootstrap.min.css";
import AddEmployee from "./components/AddEmployee";
import NotFound from "./components/NotFound";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

function App() {
  return (
    <BrowserRouter>
      <div>
        <div>
          <Switch>
            <Route exact path="/" component={EmployeeList} />
            <Route path="/add" component={AddEmployee} />
            <Route path="/employees/edit/:id" component={AddEmployee} />
            <Route path="/*" component={NotFound} />
          </Switch>
          <ToastContainer autoClose={3000} hideProgressBar />
        </div>
      </div>
    </BrowserRouter>
  );
}

export default App;
