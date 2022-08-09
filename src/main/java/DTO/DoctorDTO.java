package DTO;

import Model.Specialty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DoctorDTO {
    private String name;
    private Specialty specialty;
}
