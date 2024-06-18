package eci.cvds.armario.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "models")
public class Model {
    @Id
    @Column(name = "model_id")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID modelId;

    @Column(name = "model_name")
    private String modelName;


    @Column(name = "model_image_base64", columnDefinition = "LONGTEXT")
    private String modelImage;

    @Enumerated(EnumType.STRING)
    @Column(name = "model_category")
    private CategoriaPrenda modelCategory;
}