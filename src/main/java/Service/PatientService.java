package Service;

import DTO.PatientDTO;
import Mapper.PatientMapper;
import Model.Patient;
import Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {

    PatientRepository patientRepository;
    PatientMapper patientMapper;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public List<PatientDTO> getAllPatientsDTOs() {
        return patientRepository.findAll()
                .stream()
                .map(patientMapper::toPatientDTO)
                .collect(Collectors.toList());
    }

    public Patient getPatientById(Integer id) {
        return patientRepository.findById(id).get();
    }

    public PatientDTO getPatientByIdDTO(Integer id) {
        return patientMapper.toPatientDTO(patientRepository.findById(id).get());
    }

    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    public void deleteById(Integer id) {
        patientRepository.deleteById(id);
    }

    public Patient getByCnp(String cnp) {
        return patientRepository.getByCnp(cnp);
    }

    public PatientDTO getByCnpDTO(String cnp) {
        return patientMapper.toPatientDTO(patientRepository.getByCnp(cnp));
    }

}
