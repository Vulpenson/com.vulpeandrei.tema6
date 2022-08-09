package Exception;

public class NoSpecialtyFoundException extends Exception {
    public NoSpecialtyFoundException() {
        super("The specialty introduced does not exist");
    }
}
