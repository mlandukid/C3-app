package com.codewithloyiso.C3app.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithloyiso.C3app.Dto.UserLoginDto;
import com.codewithloyiso.C3app.Repositories.UserRepository;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtService jwtService;

    public String authenticateUserDetails(UserLoginDto userLoginDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userLoginDto.getEmail(), userLoginDto.getPassword()
                    )
            );

            return "Bearer "+jwtService.generateToken(userLoginDto.getEmail());
        }
        catch (Exception e){
            return "false";
        }
    }
}
