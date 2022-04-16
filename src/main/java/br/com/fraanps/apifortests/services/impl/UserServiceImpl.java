package br.com.fraanps.apifortests.services.impl;

import br.com.fraanps.apifortests.domain.User;
import br.com.fraanps.apifortests.domain.dto.UserDTO;
import br.com.fraanps.apifortests.repositories.UserRepository;
import br.com.fraanps.apifortests.services.UserService;
import br.com.fraanps.apifortests.services.exceptions.DataIntegratyViolationException;
import br.com.fraanps.apifortests.services.exceptions.ObjectNotfoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotfoundException("Object not found!"));
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User create(UserDTO obj){
        findByEmail(obj);
        return userRepository.save(mapper.map(obj, User.class));
    }

    @Override
    public User update(UserDTO obj) {
        findByEmail(obj);
        return userRepository.save(mapper.map(obj, User.class));
    }

    private void findByEmail(UserDTO obj){
        Optional<User> user= userRepository.findByEmail(obj.getEmail());
        if (user.isPresent() && !user.get().getId().equals(obj.getId())){
            throw new DataIntegratyViolationException("E-mail already registered!");
        }

    }
}
