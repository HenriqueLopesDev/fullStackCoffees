package coffee.fullstack.fullstackcoffee.application.coffee.dto;

import java.util.UUID;

public record CoffeeCategoryResponseDTO(UUID id, String name, String createdAt) {
}
