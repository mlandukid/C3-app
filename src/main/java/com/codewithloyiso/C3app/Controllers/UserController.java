package com.codewithloyiso.C3app.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithloyiso.C3app.Dto.TokenDto;
import com.codewithloyiso.C3app.Dto.UserLoginDto;
import com.codewithloyiso.C3app.Models.User;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthService authService;

    @Autowired
    UserDetailService userDetailService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/auth/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userDetailService.saveUser(user);
        return ResponseEntity.ok("Dpme");
    }

    @PostMapping("/getUserInfo")
    public User userInfo(@RequestBody TokenDto token){
        String userName = jwtService.extractUsername(token.getToken());
        User user = userRepository.findByEmail(userName);
        if(user==null){
            return null;
        }
        return user;
    }
    @PostMapping("/auth/login")
    public ResponseEntity<String> authenticateUser(@RequestBody  UserLoginDto userLoginDto) {

        return ResponseEntity.ok(authService.authenticateUserDetails(userLoginDto));
    }

}
