package alex.tir.storage.service;

import alex.tir.storage.entity.User;
import alex.tir.storage.mapper.UserMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Locale;
@Service
public interface UserService {
    public Mono<User> getByEmail(String email);

    public Mono<User> getUserById(Long id);

    Mono<User> registerUser(User user);
}
