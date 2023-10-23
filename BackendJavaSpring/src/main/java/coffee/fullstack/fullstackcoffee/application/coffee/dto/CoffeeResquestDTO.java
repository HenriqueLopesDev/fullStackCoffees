package coffee.fullstack.fullstackcoffee.application.coffee.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CoffeeResquestDTO(

        @NotBlank(message = "Name is required")
        String name,
        @NotBlank(message = "Description is required")
        String description,
        @NotNull(message = "Price is required")
        @Positive(message = "Price must be greater than zero")
        double price,

        CoffeeCategoryRequestDTO category
) {
}
