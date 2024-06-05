package eci.cvds.armario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Tendencias")
public class Tendencias {
    @Id
    @Column(name = "idTendencia")
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    private String idTendencia;

    @Column(name = "prendaConjunto")
    private Prenda prendaPrincipal;

    @Column(name = "prenda1")
    private Prenda prenda1;

    @Column(name = "prenda2")
    private Prenda prenda2;

    @Column(name = "prenda3")
    private Prenda prenda3;

    @Column(name = "prenda4")
    private Prenda prenda4;

}
