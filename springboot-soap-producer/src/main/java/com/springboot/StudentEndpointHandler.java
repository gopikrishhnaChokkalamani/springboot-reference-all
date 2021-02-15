package com.springboot;

import com.localsoapproducer.xml.school.StudentRequest;
import com.localsoapproducer.xml.school.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class StudentEndpointHandler {

  private static final String NAMESPACE_URI = "http://www.localsoapproducer.com/xml/school";

  @Autowired
  private StudentRepository studentRepository;

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentRequest")
  @ResponsePayload
  public StudentResponse fetchStudent(@RequestPayload StudentRequest req) {
    StudentResponse res = new StudentResponse();
    res.setStudent(studentRepository.getStudent(req.getName()));
    return res;
  }

//  @PayloadRoot(namespace = "http://www.myservice/v1.0/query", localPart = "queryRequest")
//  @ResponsePayload
//  public JAXBElement<QueryResponse> queryAddrLocation(@RequestPayload JAXBElement<QueryRequest> queryRequest) {
//    System.out.println("Welcome to " + queryRequest);
//    return createJaxbElement(new QueryResponse(), QueryResponse.class);
//  }
//
//  private <T> JAXBElement<T> createJaxbElement(T object, Class<T> clazz) {
//    return new JAXBElement<>(new QName(clazz.getSimpleName()), clazz, object);
//  }
}
