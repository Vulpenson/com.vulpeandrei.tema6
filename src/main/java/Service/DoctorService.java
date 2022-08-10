package Service;

import DTO.DoctorDTO;
import Exception.NoDoctorsWithInsertedSpecialtyException;
import Mapper.DoctorMapper;
import Model.Doctor;
import Model.Patient;
import Model.Specialty;
import Repository.DoctorRepository;
import Repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import Exception.NoDoctorFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorService {
    DoctorRepository doctorRepository;
    PatientRepository patientRepository;
    DoctorMapper doctorMapper;

    // Method to get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Method to get all doctors with DTO
    public List<DoctorDTO> getAllDoctorsDTOs() {
        return doctorRepository.findAll()
                .stream()
                .map(doctorMapper::toDoctorDTO)
                .collect(Collectors.toList());
    }

    // Method to get a doctor by id
    public Doctor getDoctorById(Integer id) {
        return doctorRepository.findById(id).get();
    }

    // Method to get a doctorDTO by id
    public DoctorDTO getDoctorByIdDTO(Integer id) {
        return doctorMapper.toDoctorDTO(doctorRepository.findById(id).get());
    }

    // Method to add a doctor
    public void addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    // Method to add a patient to one doctor
    public void addPatient(Integer doctorId, Integer patientId) throws NoDoctorFoundException {
        Doctor tmp = doctorRepository.getById(doctorId);
        if (tmp == null) {
            throw new NoDoctorFoundException();
        } else {
            Optional<Patient> patient = patientRepository.findById(patientId);
            if (patient.isPresent()) {
                doctorRepository.findById(doctorId).get().addPatient(patient.get());
                patientRepository.findById(patientId).get().setDoctor(tmp);
            }
        }
    }

    // Method to get all doctors of a certain specialty
    public List<Doctor> getDoctorsBySpecialty(Specialty specialty) throws NoDoctorsWithInsertedSpecialtyException {
        if(doctorRepository.getAllBySpecialty(specialty).isEmpty()) {
            throw new NoDoctorsWithInsertedSpecialtyException();
        } else {
            return doctorRepository.getAllBySpecialty(specialty);
        }
//        return doctorRepository.getAllBySpecialty(specialty);
    }

    // Method to get all doctorsDTO of a certain specialty
    public List<DoctorDTO> getDoctorsDTOBySpecialty(Specialty specialty) {
        return doctorRepository.getAllBySpecialty(specialty)
                .stream()
                .map(doctorMapper::toDoctorDTO)
                .collect(Collectors.toList());
    }

    // Method to delete a doctor by his id
    public void deleteById(Integer id) {
        doctorRepository.deleteById(id);
    }
}
