package com.valpoSystems.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.valpoSystems.domain.request.AuthRequest;
import com.valpoSystems.service.JwtUserDetailsService;
import com.valpoSystems.util.JwtTokenUtil;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	 private final AuthenticationManager authenticationManager;
	    private final JwtUserDetailsService userDetailsService;

	    public AuthController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, JwtUserDetailsService userDetailsService) {
	        this.authenticationManager = authenticationManager;
	        this.userDetailsService = userDetailsService;
	    }

  
	    @PostMapping(value = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<?> createAuthentication1(@RequestBody AuthRequest authRequest) throws Exception {
	    	final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
	    	authenticate(authRequest.getUsername(), authRequest.getPassword());

	        return new ResponseEntity<>(userDetails, HttpStatus.OK);
	    }

	    private void authenticate(String username, String password) throws Exception {
	        try {
	            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	        } catch (DisabledException e) {
	            throw new Exception("USER_DISABLED", e);
	        } catch (BadCredentialsException e) {
	            throw new Exception("INVALID_CREDENTIALS", e);
	        }
	    }
}
