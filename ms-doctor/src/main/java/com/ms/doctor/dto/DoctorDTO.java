package com.ms.doctor.dto;


import com.ms.doctor.model.Address;
import com.ms.doctor.model.Doctor;
import com.ms.doctor.model.Speciality;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DoctorDTO {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String phone;
    @NotBlank
    private String crm;
    @NotNull
    private Speciality speciality;

    private AddressDTO address;

    public static DoctorDTO fromEntity(Doctor medicoEntity) {
        ModelMapper mapper = new ModelMapper();
        //first map address to addressDTO
        AddressDTO addDto = AddressDTO.fromEntity(medicoEntity.getAddress());
        //last map doctor
         DoctorDTO dto = mapper.map(medicoEntity, DoctorDTO.class);
         dto.setAddress(addDto);

        return dto;
    }

    public Doctor toEntity() {
        ModelMapper modelMapper = new ModelMapper();
        //last map doctor
        Address address = this.address.toEntity();
        Doctor dto = modelMapper.map(this, Doctor.class);
        dto.setAddress(address);

        return dto;
    }
}
