package br.com.fraanps.apifortests.services;

import br.com.fraanps.apifortests.domain.User;
import br.com.fraanps.apifortests.domain.dto.UserDTO;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
    User create(UserDTO obj);
    User update (UserDTO obj);
}
