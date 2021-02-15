package com.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ApplConfig {

  @Value("${student.service.host.uri}")
  private String studentServiceURI;

  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    // this is the package name specified in the <generatePackage> specified in
    // pom.xml
    marshaller.setContextPath("com.springboot.wsdl.schema.student");
    return marshaller;
  }

  @Bean
  public StudentWebServiceGateway studentWebServiceGateway(Jaxb2Marshaller marshaller) {
    StudentWebServiceGateway client = new StudentWebServiceGateway();
    client.setDefaultUri(studentServiceURI);
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
    return client;
  }
}
