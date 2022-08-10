package Service;

import Model.Specialty;
import Model.Visit;
import Repository.DoctorRepository;
import Repository.PatientRepository;
import Repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitService {
    VisitRepository visitRepository;

    public List<Visit> getAllVisits() {
        return visitRepository.findAll();
    }

    public List<Visit> getVisitsByCnp(String cnp) {
        return visitRepository.findAllByPatientCnp(cnp);
    }

    public List<Visit> getVisitBySpeciality(Specialty specialty) {
        return visitRepository.findAllByDoctorSpecialty(specialty);
    }

    public void addVisit(Visit visit) {
        visitRepository.save(visit);
    }

    public void deleteVisit(Integer id) {
        visitRepository.deleteById(id);
    }
}
