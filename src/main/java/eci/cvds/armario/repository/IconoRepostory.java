package eci.cvds.armario.repository;

import eci.cvds.armario.model.Icono;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IconoRepostory extends JpaRepository<Icono, UUID> {
    Icono findByIconoId(UUID iconoId);
    List<Icono> findAll();
    Icono findByIconoNombre(String iconoNombre);
}
