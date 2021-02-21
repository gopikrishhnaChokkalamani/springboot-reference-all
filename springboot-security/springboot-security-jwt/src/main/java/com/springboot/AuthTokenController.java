package com.springboot;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.Date;

@RestController
@RequestMapping("/token")
public class AuthTokenController {

  @PostMapping
  public AuthToken generate(@RequestParam("client-txt") String clientTxt, @RequestParam("client-id") String clientId) {
    return new AuthToken(Jwts.builder()
            .setSubject(clientTxt).claim("role", "USER").claim("Id", clientId)
            .setExpiration(new Date(System.currentTimeMillis() + (60 * 1000)))
            .signWith(SignatureAlgorithm.HS512, "!@asdsadJAS780")
            .compact()
    );
  }
}
