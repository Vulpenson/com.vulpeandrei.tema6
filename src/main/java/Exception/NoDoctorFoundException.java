package Exception;

public class NoDoctorFoundException extends Exception {
    public NoDoctorFoundException() {
        super("The doctor introduced does not exist in the database!");
    }
}
