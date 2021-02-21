package com.springboot;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class TokenAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

  @Override
  protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

  }

  @Override
  protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken token) throws AuthenticationException {
    AuthToken authToken = (AuthToken) token;
    String strToken = authToken.getToken();
    Claims claims = Jwts.parser()
            .setSigningKey("!@asdsadJAS780")
            .parseClaimsJws(strToken)
            .getBody();
    String id = (String) claims.get("Id");
    return new LoginUserDetails(claims.getSubject(), strToken,  Long.parseLong(id),
            AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("role")));
  }
}
