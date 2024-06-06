package eci.cvds.armario.controller;
import eci.cvds.armario.model.Model;
import eci.cvds.armario.model.User;
import eci.cvds.armario.repository.ModelRepository;
import eci.cvds.armario.repository.SessionRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.UUID;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://armariolocochonback.azurewebsites.net/"})
@RequestMapping(value = "/model")
public class ModelController {
    private ModelRepository modelRepository;
    private SessionRepository sessionRepository;

    public ModelController(ModelRepository modelRepository, SessionRepository sessionRepository) {
        this.modelRepository = modelRepository;
        this.sessionRepository = sessionRepository;
    }

    @GetMapping("")
    public ResponseEntity<Model> getModelByModelId(@PathVariable("idModel") UUID idModel) {
        Model model = modelRepository.getModelByModelId(idModel);
        if (model != null) {
            return new ResponseEntity<>(model, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/{idModel}/image")
    public ResponseEntity<String> getModelImageByModelId(@PathVariable("idModel") UUID idModel) {
        Model model = modelRepository.getModelByModelId(idModel);
        if (model != null) {
            return new ResponseEntity<>(model.getModelImage(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
    }
    @PostMapping("")
    public ResponseEntity<?> addModel(@RequestHeader("authToken") UUID token, @RequestBody Model model) {
        User user = this.sessionRepository.findByToken(token).getUser();
        if (user == null) {
            return new ResponseEntity<>("admin not found", HttpStatus.FORBIDDEN);
        }
        Model savedModel = modelRepository.save(model);
        return new ResponseEntity<>(savedModel, HttpStatus.OK);
    }
}
