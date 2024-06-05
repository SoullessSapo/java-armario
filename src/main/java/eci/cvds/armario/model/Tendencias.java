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

    @ManyToOne
    @JoinColumn(name = "prendaConjunto")
    private Prenda prendaPrincipal;

    @ManyToOne
    @JoinColumn(name = "prenda1")
    private Prenda prenda1;

    @ManyToOne
    @JoinColumn(name = "prenda2")
    private Prenda prenda2;

    @ManyToOne
    @JoinColumn(name = "prenda3")
    private Prenda prenda3;

    @ManyToOne
    @JoinColumn(name = "prenda4")
    private Prenda prenda4;

}
