package coffee.fullstack.fullstackcoffee.domain.coffee.mapper;

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
                CategoryMapper.ToDTO(coffee.getCategory())
        );
    }

    public static Coffee toEntity(CoffeeResquestDTO coffee){
        Category category = new Category(coffee.category().id());
        return new Coffee(
                coffee.name(),
                coffee.description(),
                coffee.price(),
                category
        );
    }
}
