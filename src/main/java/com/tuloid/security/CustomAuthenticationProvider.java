package com.tuloid.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tuloid.user.dao.UserDAO;

@Service("customAuthenticationProvider")
@Transactional(readOnly=true)
public class CustomAuthenticationProvider implements AuthenticationProvider {
  private Logger log = Logger.getLogger(this.getClass().getName());
  	@Autowired
	private UserDAO userDao;

  static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = authentication.getName();
    String password = authentication.getCredentials().toString();
    com.tuloid.model.User user = userDao.findUser(username);

    if (user == null) {
      log.info("username not found " + username);
      throw new SecurityExecption("user " + username + " tidak ditemukan");
    }
    if (!passwordEncoder.matches(password, user.getPassword())) {
      log.info("invalid passpord for " + username);
      throw new BadCredentialsException("tidak berhasil login dengan user " + username);
    }
    

    Collection<? extends GrantedAuthority> authorities =  getAuthorities();


    return new UsernamePasswordAuthenticationToken(username, password, authorities);

  }

  public boolean supports(Class<?> authentication) {
    // TODO Auto-generated method stub
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }

  public Collection<? extends GrantedAuthority> getAuthorities() {
      List<GrantedAuthority> authList = getGrantedAuthorities("ROLE_ADMIN");
      return authList;
  }
	 public static List<GrantedAuthority> getGrantedAuthorities(String role) {
	        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	       
	       
	            authorities.add(new SimpleGrantedAuthority(role));
	       
	        return authorities;
	    }

}
