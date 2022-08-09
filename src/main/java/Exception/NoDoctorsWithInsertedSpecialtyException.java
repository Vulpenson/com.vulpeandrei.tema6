package Exception;

public class NoDoctorsWithInsertedSpecialtyException extends Exception {
    NoDoctorsWithInsertedSpecialtyException() {
        super("The specialty introduced does not have any doctors!");
    }
}
