package Mapper;

import DTO.DoctorDTO;
import Model.Doctor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorDTO toDoctorDTO(Doctor doctor);
}
