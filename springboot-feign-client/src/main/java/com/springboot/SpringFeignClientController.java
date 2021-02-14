package com.springboot;

import com.swagger.client.codegen.rest.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feign")
public class SpringFeignClientController {

  @Autowired
  @Qualifier("springboot-swagger-codegen-client")
  private EmployeeProfileFeignClient EmployeeProfileFeignClient;

  @GetMapping
  public Object getEmployeeApi(@RequestParam(name = "name") String name) {
    Employee employee = EmployeeProfileFeignClient.fetchAllEmployeesUsingGET(name);
    return employee;
  }
}
