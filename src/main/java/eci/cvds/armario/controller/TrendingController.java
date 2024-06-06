package eci.cvds.armario.controller;
import eci.cvds.armario.model.Model;
import eci.cvds.armario.model.Prenda;
import eci.cvds.armario.model.Trending;
import eci.cvds.armario.repository.PrendaRepository;
import eci.cvds.armario.repository.TrendingRepository;
import eci.cvds.armario.repository.SessionRepository;
import eci.cvds.armario.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://armariolocochonback.azurewebsites.net/"})
@RequestMapping(value = "/trending")
public class TrendingController {
    private TrendingRepository trendingRepository;
    private PrendaRepository prendaRepository;
    private SessionRepository sessionRepository;
    private ModelRepository modelRepository;

    public TrendingController(TrendingRepository trendingRepository, PrendaRepository prendaRepository, SessionRepository sessionRepository, ModelRepository modelRepository) {
        this.trendingRepository = trendingRepository;
        this.prendaRepository = prendaRepository;
        this.sessionRepository = sessionRepository;
        this.modelRepository = modelRepository;
    }

    @GetMapping("")
    public List<Map<String, Object>> getTrending() {
        List<Trending> trendings = trendingRepository.findAll();
        List<Map<String, Object>> result = new ArrayList<>();

        for (Trending trending : trendings) {
            Map<String, Object> map = new HashMap<>();
            Model model = modelRepository.getModelByModelId(trending.getConjuntoId());
            map.put("model", model != null ? Map.of(
                    "category", model.getModeCategory(),
                    "image", model.getModelImage()
            ) : null);

            Prenda prenda1 = prendaRepository.findById(trending.getPrendaId1()).orElse(null);
            map.put("prenda1", prenda1 != null ? Map.of(
                    "category", prenda1.getCategoria(),
                    "type", prenda1.getTipo(),
                    "image", prenda1.getImageUrlBase64()
            ) : null);

            Prenda prenda2 = prendaRepository.findById(trending.getPrendaId2()).orElse(null);
            map.put("prenda2", prenda2 != null ? Map.of(
                    "category", prenda2.getCategoria(),
                    "type", prenda2.getTipo(),
                    "image", prenda2.getImageUrlBase64()
            ) : null);

            Prenda prenda3 = prendaRepository.findById(trending.getPrendaId3()).orElse(null);
            map.put("prenda3", prenda3 != null ? Map.of(
                    "category", prenda3.getCategoria(),
                    "type", prenda3.getTipo(),
                    "image", prenda3.getImageUrlBase64()
            ) : null);

            Prenda prenda4 = prendaRepository.findById(trending.getPrendaId4()).orElse(null);
            map.put("prenda4", prenda4 != null ? Map.of(
                    "category", prenda4.getCategoria(),
                    "type", prenda4.getTipo(),
                    "image", prenda4.getImageUrlBase64()
            ) : null);

            result.add(map);
        }

        return result;
    }
    @GetMapping("/{idCongunto}")
    public Trending getTrendingById(@PathVariable("idConjunto") UUID idConjunto) {
        return trendingRepository.findByConjuntoId(idConjunto);
    }
    @PostMapping("")
    public Trending addTrending(@RequestBody Trending trending) {
        return trendingRepository.save(trending);
    }
}
