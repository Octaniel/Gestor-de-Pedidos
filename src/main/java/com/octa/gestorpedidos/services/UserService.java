package com.octa.gestorpedidos.services;

import com.octa.gestorpedidos.exceptions.RestException;
import com.octa.gestorpedidos.models.User;
import com.octa.gestorpedidos.repository.UserRepository;
import com.octa.gestorpedidos.wrappers.result.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ApiResponse<List<User>> findAll() {
        return new ApiResponse<>(userRepository.findAll());
    }

    public ApiResponse<User> findById(Long id) {
        return new ApiResponse<>(userRepository.findById(id).orElse(null));
    }

    public ApiResponse<User> save(User user) {
        return new ApiResponse<>(userRepository.save(user));
    }

    public ApiResponse<User> update(User user) {
        if (user.getId() == null) {
            throw new RestException("User id does not exist");
        }
        return new ApiResponse<>(userRepository.save(user));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
