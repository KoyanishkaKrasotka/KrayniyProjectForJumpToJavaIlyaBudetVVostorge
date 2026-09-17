package ru.jumptojava.kinopoiskz.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.jumptojava.kinopoiskz.entity.User;
import ru.jumptojava.kinopoiskz.repository.UserRepository;
import ru.jumptojava.kinopoiskz.security.UserDetailsImpl;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        if(user.isEmpty()) {
            throw  new UsernameNotFoundException("Такой пользователь не найден");
        }
        return new UserDetailsImpl(user.get());
    }
}
