package coffee.fullstack.fullstackcoffee.application.category;

import coffee.fullstack.fullstackcoffee.application.category.dto.CategoryRequestDTO;
import coffee.fullstack.fullstackcoffee.application.category.dto.CategoryResponseDTO;
import coffee.fullstack.fullstackcoffee.common.excepetions.CategoryNotFoundException;
import coffee.fullstack.fullstackcoffee.data.category.CategoryService;
import coffee.fullstack.fullstackcoffee.domain.category.CategoryMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> findAllCategories() {
        return ResponseEntity.ok(categoryService.findAllCategories().stream().map(CategoryMapper::ToDTO).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCategoryById(@PathVariable("id") UUID id) {
        try {
            return ResponseEntity.ok(CategoryMapper.ToDTO(categoryService.findCategoryById(id)));
        } catch (CategoryNotFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }


    @PostMapping
    public ResponseEntity<CategoryResponseDTO> saveCategory(@Valid @RequestBody CategoryRequestDTO categoryRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.ToDTO(categoryService.saveCategory(CategoryMapper.ToEntity(categoryRequestDTO))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@Valid @RequestBody CategoryRequestDTO categoryRequestDTO, @PathVariable("id") UUID id) {
        try {
            return ResponseEntity.ok().body(CategoryMapper.ToDTO(categoryService.updateCategory(CategoryMapper.ToEntity(categoryRequestDTO), id)));
        } catch (CategoryNotFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") UUID id) {
        categoryService.DeleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException errors) {
        Map<String, String> validationErrors = new HashMap<>();
        errors.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            validationErrors.put(fieldName, errorMessage);
        });

        return validationErrors;
    }
}
