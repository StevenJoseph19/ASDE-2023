import React from "react";
import { useState, useEffect } from "react";
import { Link, useHistory, useParams } from "react-router-dom";
import employeeService from "../services/employee.service";
import { toast } from "react-toastify";

const AddEmployee = () => {
  const [name, setName] = useState("");
  const [location, setLocation] = useState("");
  const [department, setDepartment] = useState("");
  const [saving, setSaving] = useState(false);
  const history = useHistory();
  const { id } = useParams();

  const saveEmployee = (e) => {
    e.preventDefault();

    const employee = { name, location, department, id };

    if (id) {
      //update
      employeeService
        .update(employee)
        .then((response) => {
          console.log("Employee data updated successfully", response.data);
          history.push("/");
        })
        .catch((error) => {
          console.log("Something went wrong", error);
        });
    } else {
      // create
      setSaving(true);
      employeeService
        .create(employee)
        .then((response) => {
          console.log("Empoyee added successfully", response.data);
          toast.success("Course saved");
          history.push("/");
        })
        .catch((error) => {
          setSaving(false);
          console.log("Something went wrong", error);
        });
    }
  };

  useEffect(() => {
    if (id) {
      employeeService
        .get(id)
        .then((employee) => {
          setName(employee.data.name);
          setLocation(employee.data.location);
          setDepartment(employee.data.department);
        })
        .catch((error) => {
          console.log("Something went wrong", error);
        });
    }
  }, []);

  return (
    <div className="container">
      <h3>Add Employeee</h3>
      <hr />
      <form>
        <div className="form-group">
          <input
            type="text"
            className="form-control col-4"
            id="name"
            value={name}
            onChange={(e) => setName(e.target.value)}
            placeholder="Enter name"
          />
        </div>
        <div className="form-group">
          <input
            type="text"
            className="form-control col-4"
            id="department"
            value={department}
            onChange={(e) => setDepartment(e.target.value)}
            placeholder="Enter Department"
          />
        </div>
        <div className="form-group">
          <input
            type="text"
            className="form-control col-4"
            id="location"
            value={location}
            onChange={(e) => setLocation(e.target.value)}
            placeholder="Enter Location"
          />
        </div>
        <div>
          <button type="submit" disabled={saving}  onClick={(e) => saveEmployee(e)} className="btn btn-primary">
                {saving ? "Saving..." : "Save"}
         </button>
        </div>
      </form>
      <hr />
      <Link to="/">Back to List</Link>
    </div>
  );
};

export default AddEmployee;
