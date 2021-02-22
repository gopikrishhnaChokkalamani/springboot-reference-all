Feature: Student Service
  Scenario Outline: Check the Student POST response
    Given : a valid request
    When : the request is <name> <age>
    Then : verify post call statu code for 200
    Examples:
      | name | age |
      | john | 12 |