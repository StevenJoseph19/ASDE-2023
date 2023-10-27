package com.sprint1.service;

import java.util.List;

import com.sprint1.entity.Employee;

public interface EmployeeService {

		public List<Employee> retrieveEmployees();
		
		public Employee getEmployee(Long id);
		
		public void saveEmployee(Employee employee);
		
		public void deleteEmployee(Long id);
		
		public void updateEmployee(Employee employee);
}
