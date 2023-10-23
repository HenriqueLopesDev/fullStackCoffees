package coffee.fullstack.fullstackcoffee.application.coffee.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record CoffeeCategoryRequestDTO(
        UUID id,
        String name
) {
}
