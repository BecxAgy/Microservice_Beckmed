package com.ms.doctor.dto;


import com.ms.doctor.model.Address;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
public class AddressDTO {
    @NotBlank
    private String street;
    private String number;
    private String complement;
    @NotBlank
    private String neighborhood;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String postalCode;

    public static AddressDTO fromEntity(Address address) {
        ModelMapper modelMapper = new ModelMapper();

       return modelMapper.map(address, AddressDTO.class);

    }

    public Address toEntity() {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(this, Address.class);
    }

}
