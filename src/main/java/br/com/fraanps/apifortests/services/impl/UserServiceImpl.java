package br.com.fraanps.apifortests.services.impl;

import br.com.fraanps.apifortests.domain.User;
import br.com.fraanps.apifortests.repositories.UserRepository;
import br.com.fraanps.apifortests.services.UserService;
import br.com.fraanps.apifortests.services.exceptions.ObjectNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotfoundException("Object not found!"));
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
