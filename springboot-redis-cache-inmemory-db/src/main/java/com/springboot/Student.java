package com.springboot;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@Data
@RedisHash("Student")
public class Student implements Serializable {

  private static final long serialVersionUID = 1L;

  private long id;
  private String firstName;
  private String lastName;
}
