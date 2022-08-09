package Repository;

import Model.Doctor;
import Model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    public List<Doctor> getAllBySpecialty(Specialty specialty);
}
