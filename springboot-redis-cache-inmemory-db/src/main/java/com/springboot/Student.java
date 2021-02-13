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

  //redis hash - alternate to hashoperations where you would manually build the hash table for redis db operations

  private static final long serialVersionUID = 1L;

  private long id;
  private String firstName;
  private String lastName;
}
