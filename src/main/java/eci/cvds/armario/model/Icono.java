package eci.cvds.armario.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "iconos")
public class Icono {
    @Id
    @Column(name="icono_id")
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    private UUID iconoId;

    @Column(name="icono_name")
    private String iconoNombre;

    @Column(name="icono_image_base64", columnDefinition="LONGTEXT")
    private String iconoImageBase64;
}
