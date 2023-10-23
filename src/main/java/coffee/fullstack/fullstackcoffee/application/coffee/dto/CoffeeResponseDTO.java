package coffee.fullstack.fullstackcoffee.application.coffee.dto;

import coffee.fullstack.fullstackcoffee.application.category.dto.CategoryResponseDTO;

import java.util.UUID;

public record CoffeeResponseDTO(UUID id, String name, String description, double price, String createdAt, CategoryResponseDTO category) {

}
