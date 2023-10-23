package coffee.fullstack.fullstackcoffee.domain.coffee.mapper;

import coffee.fullstack.fullstackcoffee.application.coffee.dto.CoffeeCategoryResponseDTO;
import coffee.fullstack.fullstackcoffee.application.coffee.dto.CoffeeResponseDTO;
import coffee.fullstack.fullstackcoffee.application.coffee.dto.CoffeeResquestDTO;
import coffee.fullstack.fullstackcoffee.common.helpers.date.DateFormatter;
import coffee.fullstack.fullstackcoffee.data.category.Category;
import coffee.fullstack.fullstackcoffee.data.coffee.Coffee;
import coffee.fullstack.fullstackcoffee.domain.category.CategoryMapper;

public class CoffeeMapper {

    public static CoffeeResponseDTO toDTO(Coffee coffee) {
        return new CoffeeResponseDTO(
                coffee.getId(),
                coffee.getName(),
                coffee.getDescription(),
                coffee.getPrice(),
                DateFormatter.toBrazilianFriendlyDate(coffee.getCreatedAt()),
                CoffeeMapper.toSimpleCoffeeCategoryDTO(coffee.getCategory())
        );
    }

    public static Coffee toEntity(CoffeeResquestDTO coffee) {
        return new Coffee(
                coffee.name(),
                coffee.description(),
                coffee.price(),
                new Category(coffee.category().id(), coffee.category().name())
        );
    }

    public static CoffeeCategoryResponseDTO toSimpleCoffeeCategoryDTO(Category category){
        return new CoffeeCategoryResponseDTO(
                category.getId(),
                category.getName()
        );
    }
}
