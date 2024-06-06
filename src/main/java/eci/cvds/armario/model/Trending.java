package eci.cvds.armario.model;
import eci.cvds.armario.model.Prenda;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trending")
public class Trending {
    @Id
    @Column(name = "trending_id")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID trendingId;

    @Column(name = "conjunto_id")
    private UUID conjuntoId;

    @Column(name = "prenda_id1")
    private UUID prendaId1;

    @Column(name = "prenda_id2")
    private UUID prendaId2;

    @Column(name = "prenda_id3")
    private UUID prendaId3;

    @Column(name = "prenda_id4")
    private UUID prendaId4;


}
