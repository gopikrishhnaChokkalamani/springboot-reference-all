Feature: Student
  Scenario: Make PostCall to Student API
    Given request body contains
    When send http POST request john 12
    Then get response and verify 200