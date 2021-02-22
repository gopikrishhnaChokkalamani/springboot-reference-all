package com.springboot.cucumber.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.springboot.SpringCucumberApplication;
import com.springboot.Student;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.util.Collections;
import java.util.Scanner;

@Slf4j
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ContextConfiguration(classes = SpringCucumberApplication.class, loader = SpringBootContextLoader.class)
@CucumberContextConfiguration
public class StudentCucumberTest extends CucumberStudentConfig {

//  @LocalServerPort
//  private int serverPort;

  public String getURI(String path) {
    return "http://localhost:" + 8080 + path;
  }

  private static final String STUDENT_API_URL = "/student";
  private final InputStream validInput = this.getClass().getClassLoader()
          .getResourceAsStream("valid-student-request.json");
  private final String validJson = new Scanner(validInput, "UTF-8").useDelimiter("\\Z").next();

  private RestTemplate restTemplate = new RestTemplate();

  private ResponseEntity<String> responseEntity;

  private String inputString;


  @Given("^request body contains$")
  public void buildStudentObject() throws JsonProcessingException {
    //delete(getURI(STUDENT_API_URL));
   // ObjectMapper objectMapper = new ObjectMapper();
   // JsonNode jsonNode = objectMapper.readValue(validJson, JsonNode.class);
   // System.out.println(jsonNode);
   // inputString = jsonNode.get(0).toString();
    System.out.println("Inside Given");
  }

  @When("^send http POST request (\\w+) (\\d+)$")
  public void executePost(String name, int age) throws Exception {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    headers.set("customheader1", "hi1");
    headers.set("customheader2", "hi2");
    headers.set("customheader3", "hi3");
    headers.set("customheader4", "hi4");

    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode jsonNode = null;

    HttpEntity httpEntity = new HttpEntity<>("{\"name\" : \"john\", \"age\":12}", headers);
    try {
      responseEntity = post(getURI(STUDENT_API_URL), httpEntity);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Then("^get response and verify (\\d+)$")
  public void get_response(int httpCode) throws Exception {
    String aHttpCode, aResponseMessage, aResponseCode;
    //if (studentResponse.findPath("errors") instanceof MissingNode) {
      //aHttpCode = String.valueOf(responseEntity.getStatusCodeValue());
      //aResponseMessage = studentResponse.get("response").get("responseMsg").textValue();
      //aResponseCode = studentResponse.get("response").get("responseCode").textValue();
      //assertEquals(aHttpCode, httpCode);
      //assertThat(aResponseMessage, is(responseMessage));
    //assertThat(responseEntity.getStatusCodeValue(),  is(httpCode));
    assertEquals(httpCode, responseEntity.getStatusCodeValue());
    }
  }
