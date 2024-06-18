package eci.cvds.armario.controller;
import eci.cvds.armario.model.Conjuntos;
import eci.cvds.armario.model.Prenda;
import eci.cvds.armario.model.Session;
import eci.cvds.armario.model.User;
import eci.cvds.armario.repository.ConjuntosRepository;
import eci.cvds.armario.repository.PrendaRepository;
import eci.cvds.armario.repository.SessionRepository;
import eci.cvds.armario.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://armariolocochonback.azurewebsites.net/"})
@RequestMapping(value = "/user")
public class conjuntosController {

    private ConjuntosRepository conjuntosRepository;
    private SessionRepository sessionRepository;

    @Autowired
    public conjuntosController( SessionRepository sessionRepository, ConjuntosRepository conjuntosRepository) {

        this.sessionRepository = sessionRepository;
        this.conjuntosRepository = conjuntosRepository;
    }

    @GetMapping("/client/conjuntos")
public List<List<Prenda>> getAllConjuntosOfUser(@RequestHeader("authToken") UUID authToken) {
    User user = this.sessionRepository.findByToken(authToken).getUser();
    List<Conjuntos> conjuntos = conjuntosRepository.findByUser(user);
    List<List<Prenda>> prendasPorConjunto = new ArrayList<>();
    for (Conjuntos conjunto : conjuntos) {
        List<Prenda> prendas = new ArrayList<>();
        if (conjunto.getPrenda1() != null) prendas.add(conjunto.getPrenda1());
        if (conjunto.getPrenda2() != null) prendas.add(conjunto.getPrenda2());
        if (conjunto.getPrenda3() != null) prendas.add(conjunto.getPrenda3());
        if (conjunto.getPrenda4() != null) prendas.add(conjunto.getPrenda4());
        prendasPorConjunto.add(prendas);
    }
    return prendasPorConjunto;
}

    @GetMapping("/client/conjunto/{idConjunto}")
    public ResponseEntity<Conjuntos> getConjuntoById(@RequestHeader("authToken") UUID authToken, @PathVariable("idConjunto") UUID idConjunto) {
        User user = this.sessionRepository.findByToken(authToken).getUser();
        Conjuntos conjunto = conjuntosRepository.findById(idConjunto).get();
        if (user != null) {
            return new ResponseEntity<>(conjunto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
    }


   @PostMapping("/client/conjunto")
public Conjuntos addConjunto(@RequestBody Conjuntos conjunto, @RequestHeader("authToken") UUID authToken) {
    User user = this.sessionRepository.findByToken(authToken).getUser();
    conjunto.setUser(user);
    return conjuntosRepository.save(conjunto);
}
}
