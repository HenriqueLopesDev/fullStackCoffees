package coffee.fullstack.fullstackcoffee.application.category.dto;

import java.util.UUID;

public record CategoryResponseDTO(UUID id, String name, String createdAt) {
}
