package Controller;

import DTO.DoctorDTO;
import Exception.NoDoctorFoundException;
import Model.Doctor;
import Model.Specialty;
import Service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("doctors")
public class DoctorController {
    private final DoctorService doctorService;

    // Method to get all doctors
    @GetMapping("all")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    // Method to get all doctors DTO
    @GetMapping("dto/all")
    public List<DoctorDTO> getAllDoctorsDTOs() {
        return doctorService.getAllDoctorsDTOs();
    }

    // Method to get a doctor by id
    @GetMapping("{id}")
    public Doctor getDoctorById(@PathVariable Integer id) {
        return doctorService.getDoctorById(id);
    }

    @GetMapping("/dto/{id}")
    public DoctorDTO getDoctorByIdDTO(@PathVariable Integer id) {
        return doctorService.getDoctorByIdDTO(id);
    }

    // Method to add a doctor
    @PostMapping("add")
    public void addDoctor(@RequestBody Doctor doctor) {
        doctorService.addDoctor(doctor);
    }

    // Method to delete a doctor by id
    @DeleteMapping("delete/{id}")
    public void deleteDoctor(@PathVariable Integer id) {
        doctorService.deleteById(id);
    }

    // Method to get doctors by specialty
    @GetMapping("all/{specialty}")
    public List<Doctor> getDoctorsBySpecialty(@PathVariable Specialty specialty) {
        return doctorService.getDoctorsBySpecialty(specialty);
    }

    // Method to get doctors DTO by specialty
    @GetMapping("dto/all/{specialty}")
    public List<DoctorDTO> getDoctorsBySpecialtyDTO(@PathVariable Specialty specialty) {
        return doctorService.getDoctorsDTOBySpecialty(specialty);
    }

    //Method to add a new patient to a doctor
    @PostMapping("addpatient/{doctorId}/{patientId}")
    public void addPatient(@PathVariable Integer doctorId, @PathVariable Integer patientId) throws NoDoctorFoundException {
        doctorService.addPatient(doctorId, patientId);
    }
}
