package br.com.fraanps.apifortests.services;

import br.com.fraanps.apifortests.domain.User;

public interface UserService {

    User findById(Integer id);
}
