package Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotNull
    String name;

    @JsonManagedReference
    @OneToMany
    List<Patient> patientList;
    Specialty specialty;

    public void addPatient(Patient patient) {
        patientList.add(patient);
        System.out.println("Patient " + patient.getId() + " was successfully assigned to doctor " + this.getName());
    }
}
