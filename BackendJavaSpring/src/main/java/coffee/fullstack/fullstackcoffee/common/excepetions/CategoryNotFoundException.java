package coffee.fullstack.fullstackcoffee.common.excepetions;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
