package br.com.fraanps.apifortests.services;

import br.com.fraanps.apifortests.domain.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
}
