package com.emi.medicalimageprocessing.Controller;

import com.emi.medicalimageprocessing.dto.auth.AuthenticationRequest;
import com.emi.medicalimageprocessing.dto.auth.AuthenticationResponse;
import com.emi.medicalimageprocessing.services.auth.ApplicationUserDetailsService;
import com.emi.medicalimageprocessing.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.emi.medicalimageprocessing.utils.Constants.*;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ApplicationUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
      authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(AuthenticationResponse.builder().accessToken(jwt).build());

    }
}
