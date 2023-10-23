package coffee.fullstack.fullstackcoffee.data.coffee;

import coffee.fullstack.fullstackcoffee.common.excepetions.CoffeeNotFoundException;
import coffee.fullstack.fullstackcoffee.data.category.Category;
import coffee.fullstack.fullstackcoffee.data.category.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;
    private final CategoryService categoryService;

    public List<Coffee> findAllCoffees() {
        return coffeeRepository.findAll();
    }

    public Coffee findCoffeeById(UUID id){
        return coffeeRepository.findById(id).orElseThrow(() -> new CoffeeNotFoundException("Coffee not found"));
    }

    public Coffee saveCoffee(Coffee coffee) {
        Coffee coffe = coffeeRepository.save(coffee);
        coffe.setCategory(categoryService.findCategoryById(coffee.getCategory().getId()));
        return coffe;
    }

    @Transactional
    public void deleteCoffee(UUID id) {
        coffeeRepository.deleteById(id);
    }
}
