package coffee.fullstack.fullstackcoffee.data.coffee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoffeeRepository extends JpaRepository<Coffee, UUID> {
}
