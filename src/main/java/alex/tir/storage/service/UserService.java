package alex.tir.storage.service;

import alex.tir.storage.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> getByEmail(String email);

    Mono<User> getUserById(Long id);

    Mono<User> registerUser(User user);
}
