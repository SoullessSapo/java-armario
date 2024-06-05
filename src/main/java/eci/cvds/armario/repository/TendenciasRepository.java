package eci.cvds.armario.repository;

import eci.cvds.armario.model.Prenda;
import eci.cvds.armario.model.Tendencias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TendenciasRepository extends JpaRepository<Tendencias, UUID>{
    List<Tendencias> findAll();


}
