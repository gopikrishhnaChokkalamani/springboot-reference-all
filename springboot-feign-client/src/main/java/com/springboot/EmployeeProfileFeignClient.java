package com.springboot;

import com.swagger.client.codegen.rest.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//if using in the cloud services - the name is the application-name that you see in the eureka server
//here its a standalone that integrates with the maven codegen
@FeignClient(name = "springboot-swagger-codegen-client", qualifier = "springboot-swagger-codegen-client",
url = "${employee.profiles.host.uri}", configuration = FeignConfig.class)
public interface EmployeeProfileFeignClient {

  //sometimes if you dont add produces, u will get canot deserialize instance of START_ARRAY token
  @GetMapping(value = "/profile/v1/employee/fetch/{name}",  produces = MediaType.APPLICATION_JSON_VALUE)
  public Employee fetchAllEmployeesUsingGET(@RequestParam(name = "name") String name);
}
