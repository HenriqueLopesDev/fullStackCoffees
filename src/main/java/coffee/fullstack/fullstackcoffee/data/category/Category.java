package coffee.fullstack.fullstackcoffee.data.category;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // TO-DO - Validation not working in Domain Layer
    private String name;

    private LocalDateTime createdAt;

    public Category(String name) {
        setName(name);
    }

    public Category(UUID id){
        setId(id);
    }
}
