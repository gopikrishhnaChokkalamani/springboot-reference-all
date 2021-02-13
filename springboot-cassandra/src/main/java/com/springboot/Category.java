package com.springboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@UserDefinedType(value = "category")
public class Category implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  private String name;
  
  private String type;
  
  private int price;
}
