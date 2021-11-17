package com.first.first.jwt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.first.first.jwt.model.JwtRequest;
import com.first.first.jwt.model.JwtResponse;
import com.first.first.jwt.service.UserJwtService;
import com.first.first.jwt.utility.JWTUtility;


@RestController
public class JWTTokenController {

	Logger logger = LoggerFactory.getLogger(JWTTokenController.class);
	
	 @Autowired
	    private JWTUtility jwtUtility;

	    @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private UserJwtService userService;
	
	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
		   try {
			   logger.info("Authenticate ");
			   
			   logger.info("Jwt Request {} ",jwtRequest);
			   
			   logger.debug("debug --Jwt Request {}",jwtRequest);
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(
	                            jwtRequest.getUsername(),
	                            jwtRequest.getPassword()
	                    )
	            );
	        } catch (BadCredentialsException e) {
	        	e.printStackTrace();
	        	logger.error("Exception occurs in {}",e);
	            throw new Exception("INVALID_CREDENTIALS", e);
	        }

	        final UserDetails userDetails
	                = userService.loadUserByUsername(jwtRequest.getUsername());

	        final String token =
	                jwtUtility.generateToken(userDetails);

	        logger.info("JWT Token -- "+token);
	        
	        return  new JwtResponse(token);
	    }

}
