package mutsa.shoppingmall.user.service;

import lombok.RequiredArgsConstructor;
import mutsa.shoppingmall.user.entity.User;
import mutsa.shoppingmall.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;

    public User findByUserId(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("User not found"));
    }
}
