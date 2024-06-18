package eci.cvds.armario.controller;
import eci.cvds.armario.model.Icono;
import eci.cvds.armario.repository.IconoRepostory;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RequestMapping("/icono")
@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://armariolocochonback.azurewebsites.net/"})
public class IconoController {
    private IconoRepostory iconoRepository;
    public IconoController(IconoRepostory iconoRepository) {
        this.iconoRepository = iconoRepository;
    }
    @GetMapping("/iconos")
    public Iterable<Icono> getAllIconos() {
        return iconoRepository.findAll();
    }
    @GetMapping("/{idIcono}")
    public Icono getIconoById(@PathVariable("idIcono") UUID idIcono) {
        return iconoRepository.findByIconoId(idIcono);
    }
    @GetMapping("/nombre/{nombre}")
    public Icono getIconoByNombre(@PathVariable("nombre") String nombre) {
        return iconoRepository.findByIconoNombre(nombre);
    }
    @PostMapping("")
    public Icono addIcono(@RequestBody Icono icono) {
        return iconoRepository.save(icono);
    }
}
