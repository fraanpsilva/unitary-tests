package br.com.fraanps.apifortests.resource;

import br.com.fraanps.apifortests.domain.User;
import br.com.fraanps.apifortests.domain.dto.UserDTO;
import br.com.fraanps.apifortests.services.UserService;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/users")
public class UserResource {


    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService userService;

    @GetMapping(value="/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(mapper.map(userService.findById(id), UserDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = userService.findAll();
        List<UserDTO> listDto = list.stream().map(x -> mapper.map(x, UserDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<List<UserDTO>> create(@RequestBody UserDTO obj){
        User newObj = userService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }
}
