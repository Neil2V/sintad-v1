package com.example.sintadv1.security.controller;

import com.example.sintadv1.security.dto.JwtDto;
import com.example.sintadv1.security.dto.LoginUser;
import com.example.sintadv1.security.dto.NewUser;
import com.example.sintadv1.security.entity.Rol;
import com.example.sintadv1.security.entity.User;
import com.example.sintadv1.security.enums.RolEnum;
import com.example.sintadv1.security.jwt.JwtProvider;
import com.example.sintadv1.security.service.RolService;
import com.example.sintadv1.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/new")
    public ResponseEntity<?> newUser(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){

        if(bindingResult.hasErrors())
            return new ResponseEntity("Campos invalidados", HttpStatus.BAD_REQUEST);
        if(userService.existsByUsername(newUser.getUsername()))
            return new ResponseEntity("The username already exists", HttpStatus.BAD_REQUEST);
        if(userService.existsByEmail(newUser.getEmail()))
            return new ResponseEntity("The email already exists", HttpStatus.BAD_REQUEST);


        User user = new User(newUser.getName(), newUser.getUsername(), newUser.getEmail()
                ,passwordEncoder.encode(newUser.getPassword()));

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.findByRolname(RolEnum.ROLE_USER).get());

        if(newUser.getRoles().contains("admin"))
            roles.add(rolService.findByRolname(RolEnum.ROLE_ADMIN).get());

        user.setRoles(roles);
        userService.save(user);

        return new ResponseEntity("User create", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity("Campos invalidados", HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        JwtDto jwtDto = new JwtDto(jwt);
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
