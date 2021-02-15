package com.springboot;

import com.springboot.wsdl.schema.student.StudentRequest;
import com.springboot.wsdl.schema.student.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/soap/consume")
public class SpringSoapConsumerController {

  @Value("${student.service.host.uri}")
  private String studentServiceURI;

  @Autowired
  private StudentWebServiceGateway studentWebServiceGateway;

  @PostMapping
  public StudentResponse fetchStudent(@RequestBody StudentRequest request) {
    return (StudentResponse) studentWebServiceGateway.callWebService(studentServiceURI, request);
  }
}
