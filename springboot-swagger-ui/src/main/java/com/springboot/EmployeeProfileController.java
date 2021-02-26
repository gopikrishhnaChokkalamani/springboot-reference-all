package com.springboot;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//@ApiOperation(value = "/profile/v1/employee", tags = "Employee Profile Controller", notes = "Employee Profile API")
@RestController
@RequestMapping("/profile/v1/employee")
public class EmployeeProfileController {

  List<Employee> employees = Arrays.asList(
          new Employee(12345L, "John", "Electrical", 23023456788L),
          new Employee(22345L, "Sam", "Computer", 33023456788L),
          new Employee(32345L, "Jack", "Electronics", 43023456788L),
          new Employee(42345L, "Mark", "Mechanical", 53023456788L)
  );


  //look at this file
  //due to swagger annotation it looks very ugly
  //so wwat we can do is
  //create this contraoller as an interface and have all the swagger annotation and signature here
  //then create an implementation and implemen this controller
  //that way, ur controller will be a documentation
  //ur imple will be the actuall logic

  @ApiOperation(value = "Fetch All Employees")
  @DefaultApiResponses
  @GetMapping(value = "/fetch/all")
  public List<Employee> fetchAllEmployees() {
    return employees;
  }

  @ApiOperation(value = "Fetch Employee by Name", response = Employee.class)
  @DefaultApiResponses
  @GetMapping(value = "/fetch/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Employee fetchEmployeeByName(@ApiParam(value = "Employee Name") @PathVariable(value = "name") String name) {
    return employees.stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst().get();
  }

  @ApiOperation(value = "Get Employee By Department", response = Employee.class)
  @DefaultApiResponses
  @GetMapping(value = "/fetch/{department}")
  public List<Employee> fetchEmployeeByDepartment(@ApiParam(value = "Department Name", required = true) @PathVariable(value = "department") String department) {
    return employees.stream().filter(x -> x.getDepartment().equalsIgnoreCase(department)).collect(Collectors.toList());
  }

  @ApiOperation(value = "Insert Employee Record", response = Employee.class)
  @DefaultApiResponses
  @PostMapping
  public Employee insertEmployee(@ApiParam(value = "Employee") @RequestBody Employee employee) {
    return employee;
  }

  @ApiOperation(value = "Update Employee Details", response = Employee.class)
  @DefaultApiResponses
  @PutMapping
  public Employee updateEmployee(@ApiParam(value = "Employee") @RequestBody Employee employee) {
    return employee;
  }

  @ApiOperation(value = "Delete an Employee", response = Employee.class)
  @DefaultApiResponses
  @DeleteMapping
  public Employee deleteEmployee(@ApiParam(value = "Employee") @RequestBody Employee employee) {
    return employee;
  }

  @ApiOperation(value = "Partial Update a specific Student in the System ", response = Employee.class)
  @DefaultApiResponses
  @PatchMapping
  public Object patchEmployee(@ApiParam(value = "Employee") @RequestBody Map<String, Object> partialUpdate) {
    return partialUpdate;
  }
}