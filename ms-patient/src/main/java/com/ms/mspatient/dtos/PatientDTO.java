package com.ms.mspatient.dtos;


import com.ms.mspatient.models.Address;
import com.ms.mspatient.models.Patient;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private String id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String telefone;
    @NotNull
    private String cpf;
    private AddressDTO address;
    public static PatientDTO fromEntity(Patient patientEntity) {
        ModelMapper mapper = new ModelMapper();
        //first map address to addressDTO
        AddressDTO addDto = AddressDTO.fromEntity(patientEntity.getAddress());
        //last map Patient
        PatientDTO dto = mapper.map(patientEntity, PatientDTO.class);
        dto.setAddress(addDto);

        return dto;
    }

    public Patient toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        //last map Patient
        Address address = this.address.toEntity();
        Patient dto = modelMapper.map(this, Patient.class);
        dto.setAddress(address);

        return dto;
    }
}
