package Observer;

import java.util.Observable;
import java.util.Observer;

public class PatientObserver implements Observer {
    @Override
    public void update(Observable observable, Object object) {
        System.out.println("New patient assigned!");
    }
}
