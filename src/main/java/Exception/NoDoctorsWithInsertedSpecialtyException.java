package Exception;

public class NoDoctorsWithInsertedSpecialtyException extends Exception {
    public NoDoctorsWithInsertedSpecialtyException() {
        super("The specialty introduced does not have any doctors!");
    }
}
