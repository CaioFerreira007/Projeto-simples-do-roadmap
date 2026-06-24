package middlewares;

public class ErroGeralException extends RuntimeException {
    public ErroGeralException(String message) {
        super(message);
    }
}
