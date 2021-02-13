package com.springboot;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
  
  private String addr1;
  
  private String addr2;
  
  private String city;
  
  private String state;
  
  private String zipCode;
}
