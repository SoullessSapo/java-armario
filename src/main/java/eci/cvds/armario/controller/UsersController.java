package eci.cvds.armario.controller;

import eci.cvds.armario.model.Roles;
import eci.cvds.armario.model.User;
import eci.cvds.armario.repository.SessionRepository;
import eci.cvds.armario.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import eci.cvds.armario.model.Roles;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://armariolocochonback.azurewebsites.net/"})
@RequestMapping(value = "/user")
public class UsersController {
    private final UserService userService;
    private final SessionRepository sessionRepository;

    @Autowired
    public UsersController(UserService userService, SessionRepository sessionRepository) {
        this.userService = userService;
        this.sessionRepository = sessionRepository;
    }

    @GetMapping("/admin/greeting")
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/admin/users")
    public ResponseEntity<List<User>> getUsers(@RequestHeader("authToken") UUID authToken) {
        User user = this.sessionRepository.findByToken(authToken).getUser();
        if (user.getRole() != Roles.ADMINISTRADOR) {
            throw new RuntimeException("Unauthorized access. User is not an administrator.");
        }
        return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);
    }
    @GetMapping("/admin/username/{id}")
    public User getUserByUsername(@PathVariable("id") String id) {
        try{
            return this.userService.getUserById(id);
        }catch (Exception e){
            return null;
        }
    }

    @GetMapping("/userId")
    public User getUserByID(@RequestHeader("authToken") UUID id) {
        return this.sessionRepository.getReferenceById(id).getUser();
    }

    @GetMapping("/token")
    public User getUserByToken(@RequestHeader("authToken") UUID authToken) {
        return this.sessionRepository.findByToken(authToken).getUser();
    }



    @PostMapping("/admin/adicionarUsuario")
    public void adicionar(@RequestBody User user) {
        userService.adicionar(user);
    }

    @PutMapping("/admin/actualizarUsuario/{id}")
    public User actualizar(@PathVariable String id, @RequestBody User user) {
        return userService.actualizar(id, user);
    }

    @PostMapping("/admin/chequearUsuario")
    public boolean validarUsuario(@RequestBody User user) {
        return this.userService.validarUsuario(user);
    }

    @DeleteMapping("/admin/eliminarUsuario/{id}")
    public void eliminarUsuario(@PathVariable String id) {
        userService.eliminarUsuario(id);
    }
}
