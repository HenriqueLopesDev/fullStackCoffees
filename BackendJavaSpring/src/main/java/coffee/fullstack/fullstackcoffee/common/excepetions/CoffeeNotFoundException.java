package coffee.fullstack.fullstackcoffee.common.excepetions;

public class CoffeeNotFoundException extends RuntimeException {
    public CoffeeNotFoundException(String message) {
        super(message);
    }
}
