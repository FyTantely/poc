package com.poc.api.infrastructure.user;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.poc.api.commun.config.jwt.AuthRequest;
import com.poc.api.commun.config.jwt.JwtProperties;
import com.poc.api.commun.config.jwt.JwtUtil;
import com.poc.api.commun.utils.mapper.UserMapper;
import com.poc.api.donnee.dto.commun.user.LoginSuccessDto;
import com.poc.api.service.applicatif.crud.user.UserSA;
import com.poc.api.service.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api( description="API Login")
@RestController
public class LoginController {

	@Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserSA userSA;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;
    
    @CrossOrigin
    @ApiOperation(value = "Login")
    @PostMapping("/signin")
    public ResponseEntity<LoginSuccessDto> generateToken(@RequestBody AuthRequest authRequest, HttpServletResponse response) throws Exception {
          	  
    	try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getMail(), authRequest.getPassword())
            );
        } catch (Exception ex) {
             throw new Exception("Invalid username/password");
            //return new ResponseEntity<>(new LoginSuccessDto("Error", "Invalid username/password", "", userSA.findUserByMail(authRequest.getMail())), HttpStatus.NOT_FOUND);
        }
        String token = jwtUtil.generateToken(authRequest.getMail());
        response.addHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + token);
        return new ResponseEntity<>(new LoginSuccessDto("SUCCESS", "Successfully done", token, userSA.findUserByMail(authRequest.getMail())), HttpStatus.OK);
    }
}
