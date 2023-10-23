package coffee.fullstack.fullstackcoffee.data.coffee;

import coffee.fullstack.fullstackcoffee.data.category.Category;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "coffees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String description;

    private double price;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Coffee(String name, String description, double price, Category category) {
        setName(name);
        setDescription(description);
        setPrice(price);
        setCreatedAt(LocalDateTime.now());
        setCategory(category);
    }

}
