package br.com.fraanps.apifortests.config;

import br.com.fraanps.apifortests.domain.User;
import br.com.fraanps.apifortests.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public void startDb(){
        User u1 = new User(null, "Francilene", "fran@gmail.com", "123");
        User u2 = new User(null, "Pedro", "pedro@gmail.com", "1234");

        userRepository.saveAll(List.of(u1, u2));

    }
}
