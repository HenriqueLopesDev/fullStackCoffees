package coffee.fullstack.fullstackcoffee.data.category;

import coffee.fullstack.fullstackcoffee.common.excepetions.CategoryNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public Category findCategoryById(UUID id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category not found"));
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }


    public Category updateCategory(Category category, UUID id) {
        Category foundCategory = findCategoryById(id);
        foundCategory.setName(category.getName());
        return categoryRepository.save(foundCategory);
    }

    @Transactional
    public void DeleteCategory(UUID id) {
        categoryRepository.deleteById(id);
    }

}
