package eci.cvds.armario.repository;
import eci.cvds.armario.model.Trending;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TrendingRepository extends JpaRepository<Trending, UUID>{
    Trending findByConjuntoId(UUID conjuntoId);
    List<Trending> findAll();
}
