package eci.cvds.armario.controller;

import eci.cvds.armario.repository.TendenciasRepository;
import eci.cvds.armario.repository.SessionRepository;
import eci.cvds.armario.repository.PrendaRepository;
import eci.cvds.armario.model.Prenda;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://armariolocochonback.azurewebsites.net/"})
@RequestMapping(value = "/prendas")
public class TendenciasController {
    private final TendenciasRepository tendenciasRepository;
    private SessionRepository sessionRepository;
    private PrendaRepository prendaRepository;

    public TendenciasController(SessionRepository sessionRepository, PrendaRepository prendaRepository, TendenciasRepository tendenciasRepository) {
        this.sessionRepository = sessionRepository;
        this.prendaRepository = prendaRepository;
        this.tendenciasRepository = tendenciasRepository;
    }

    @GetMapping("/tendencias")
    public List<Prenda> getAllPrendas() {
        return prendaRepository.findAll(PageRequest.of(0, 6)).getContent();
    }
}
