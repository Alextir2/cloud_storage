package alex.tir.storage.controller;

import alex.tir.storage.dto.AuthRequestDTO;
import alex.tir.storage.dto.AuthResponseDTO;
import alex.tir.storage.dto.UserDTO;
import alex.tir.storage.entity.User;
import alex.tir.storage.mapper.UserMapper;
import alex.tir.storage.security.CustomPrincipal;
import alex.tir.storage.security.SecurityService;
import alex.tir.storage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final SecurityService securityService;

    private final UserService userService;

    private final UserMapper userMapper;

    @PostMapping("/register")
    public Mono<UserDTO> register(@RequestBody UserDTO dto) {
        User user = userMapper.convertToUser(dto);
        return userService.registerUser(user)
                .map(userMapper::convertToUserDTO);
    }

    @PostMapping("/login")
    public Mono<AuthResponseDTO> login(@RequestBody AuthRequestDTO dto) {
        return securityService.authenticate(dto.getEmail(), dto.getPassword())
                .flatMap(tokenDetails -> Mono.just(
                        AuthResponseDTO.builder()
                                .userId(tokenDetails.getUserId())
                                .token(tokenDetails.getToken())
                                .issuedAt(tokenDetails.getIssuedAt())
                                .expiresAt(tokenDetails.getExpiresAt())
                                .build()
                ));
    }

    @GetMapping("/info")
    public Mono<UserDTO> getUserInfo(Authentication authentication) {
        CustomPrincipal customPrincipal = (CustomPrincipal) authentication.getPrincipal();

        return userService.getUserById(customPrincipal.getId())
                .map(userMapper::convertToUserDTO);
    }
}
