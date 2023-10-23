package coffee.fullstack.fullstackcoffee.application.coffee;

import coffee.fullstack.fullstackcoffee.application.coffee.dto.CoffeeResponseDTO;
import coffee.fullstack.fullstackcoffee.application.coffee.dto.CoffeeResquestDTO;
import coffee.fullstack.fullstackcoffee.common.excepetions.CoffeeNotFoundException;
import coffee.fullstack.fullstackcoffee.data.coffee.Coffee;
import coffee.fullstack.fullstackcoffee.data.coffee.CoffeeService;
import coffee.fullstack.fullstackcoffee.domain.coffee.mapper.CoffeeMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController()
@RequestMapping("/api/v1/coffees")
@RequiredArgsConstructor
public class CoffeeController {

    private final CoffeeService coffeeService;

    @GetMapping
    public ResponseEntity<List<CoffeeResponseDTO>> findAllCoffees() {
        return ResponseEntity.ok(coffeeService.findAllCoffees().stream().map(CoffeeMapper::toDTO).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCoffeeById(@PathVariable("id") UUID id) {
        try {
            return ResponseEntity.ok(CoffeeMapper.toDTO(coffeeService.findCoffeeById(id)));
        } catch (CoffeeNotFoundException error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }

    }

    @PostMapping
    public ResponseEntity<CoffeeResponseDTO> saveCoffee(@Valid @RequestBody CoffeeResquestDTO coffee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(CoffeeMapper.toDTO(coffeeService.saveCoffee(CoffeeMapper.toEntity(coffee))));
    }

    @PutMapping
    public ResponseEntity<String> updateCoffee() {
        return ResponseEntity.ok("Fazendo uma requisição do tipo PUT");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoffee(@PathVariable UUID id) {
        coffeeService.deleteCoffee(id);
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
