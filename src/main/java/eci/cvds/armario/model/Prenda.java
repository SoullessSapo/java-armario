package eci.cvds.armario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prenda")
public class Prenda implements java.io.Serializable {
    @Id
    @Column(name = "prenda_id")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID prendaId;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoPrenda tipo;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private CategoriaPrenda categoria;

    @Column(name = "image_url_base_64", columnDefinition = "LONGTEXT")
    private String imageUrlBase64;


}
