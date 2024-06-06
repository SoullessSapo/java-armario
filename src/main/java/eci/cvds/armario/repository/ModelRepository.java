package eci.cvds.armario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import eci.cvds.armario.model.Model;

import java.util.UUID;

public interface ModelRepository extends JpaRepository<Model, UUID>{
    Model getModelByModelId(UUID modelId);
    Model getModelByModelName(String name);
}