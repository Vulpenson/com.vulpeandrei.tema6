package Controller;

import DTO.PatientDTO;
import Model.Patient;
import Service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("patients")
public class PatientController {

    private final PatientService patientService;

    // Method to get all patients
    @GetMapping("all")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    // Method to get all patients DTO
    @GetMapping("dto/all")
    public List<PatientDTO> getAllPatientsDTOs() {
        return patientService.getAllPatientsDTOs();
    }

    // Method to get a patient by id
    @GetMapping("{id}")
    public Patient getPatientById(@PathVariable Integer id) {
        return patientService.getPatientById(id);
    }

    // Method to get a patientDTO by id
    @GetMapping("/dto/{id}")
    public PatientDTO getPatientByIdDTO(@PathVariable Integer id) {
        return patientService.getPatientByIdDTO(id);
    }

    // Method to add a doctor
    @PostMapping("/add")
    public void addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }

    // Method to delete a doctor by id
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        patientService.deleteById(id);
    }

    // Method to get a patient by its cnp
    @GetMapping("cnp/{cnp}")
    public Patient getByCnp(@PathVariable String cnp) {
        return patientService.getByCnp(cnp);
    }

    // Method to get a patientDTO by its cnp
    @GetMapping("dto/cnp/{cnp}")
    public PatientDTO getByCnpDTO(@PathVariable String cnp) {
        return patientService.getByCnpDTO(cnp);
    }
}
