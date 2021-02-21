package com.springboot;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/token")
public class AuthController {

  @PostMapping
  public ResponseEntity<TokenResponse> fetchToken(@RequestBody TokenRequest req) {
    return new ResponseEntity<>(
            new TokenResponse(
                    Jwts.builder()
                            .setSubject(req.getClientName())
                            .claim("roles", "user")
                            .setIssuedAt(new Date())
                            .signWith(SignatureAlgorithm.HS256, "123#&*zcvAWEE999")
                            .compact()
            ), HttpStatus.OK
    );
  }
}