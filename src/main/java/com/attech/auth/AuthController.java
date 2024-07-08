package com.attech.auth;

import com.attech.model.AppResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/test")
    public ResponseEntity<AppResponse> getMessage(){
        AppResponse appResponse =  AppResponse.builder()
                .message("tested and trusted")
                .build();
        return ResponseEntity.status(HttpStatus.OK)
                .body(appResponse);
    }
}
