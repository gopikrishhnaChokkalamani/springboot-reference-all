package com.springboot.cucumber.steps;

import org.junit.runner.RunWith;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.Response;

@RunWith(SpringRunner.class)
public class CucumberStudentConfig {

  private TestRestTemplate testRestTemplate;

  public CucumberStudentConfig() {
    this.testRestTemplate = new TestRestTemplate();
  }

  public ResponseEntity<String> post(String uri, HttpEntity<String> request) {
    return testRestTemplate.postForEntity(uri, request, String.class);
  }

  public void delete(String uri) {
    testRestTemplate.delete(uri);
  }
}
