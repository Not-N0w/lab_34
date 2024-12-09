package objects.creatures;

public class NotPositional extends Exception {
    public NotPositional() {
        super("Не работает");
    }

    public NotPositional(String message) {
        super(message);
    }

    public NotPositional(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}