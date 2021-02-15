package com.springboot;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class StudentWebServiceGateway extends WebServiceGatewaySupport {

  public Object callWebService(String url, Object request) {
    return getWebServiceTemplate().marshalSendAndReceive(url, request);
  }
}
