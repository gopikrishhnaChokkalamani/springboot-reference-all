package com.springboot;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
  
  private String studentId;
  
  private String firstName;
  
  private String lastName;
  
  private String age;
}
