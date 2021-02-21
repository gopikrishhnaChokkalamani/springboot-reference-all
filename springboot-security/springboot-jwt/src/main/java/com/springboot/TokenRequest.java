package com.springboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenRequest {

  private int clientId;

  private String clientName;

  private String passwordTxt;
}
