package eci.cvds.armario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contactanos")
public class Contactanos {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator= "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    private UUID id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo")
    private String correo;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "mensaje")
    private String mensaje;
}
