package Repository;

import Model.Specialty;
import Model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Integer> {
    List<Visit> findAllByPatientCnp(String cnp);
    List<Visit> findAllByDoctorSpecialty(Specialty specialty);
}
