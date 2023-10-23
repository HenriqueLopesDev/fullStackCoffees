package coffee.fullstack.fullstackcoffee.domain.category;

import coffee.fullstack.fullstackcoffee.application.category.dto.CategoryRequestDTO;
import coffee.fullstack.fullstackcoffee.application.category.dto.CategoryResponseDTO;
import coffee.fullstack.fullstackcoffee.common.helpers.date.DateFormatter;
import coffee.fullstack.fullstackcoffee.data.category.Category;

public class CategoryMapper {

    public static CategoryResponseDTO ToDTO(Category category) {
        return new CategoryResponseDTO(
                category.getId(),
                category.getName(),
                DateFormatter.toBrazilianFriendlyDate(category.getCreatedAt())
        );
    }

    public static Category ToEntity(CategoryRequestDTO categoryRequestDTO) {
        return new Category(
                categoryRequestDTO.name()
        );
    }
}
