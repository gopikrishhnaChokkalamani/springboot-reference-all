package com.springboot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

  private static final long serialVersionUID = 1L;

  private String name;

  private int age;
}
