package com.ms.mspatient.dtos;


import com.ms.mspatient.models.Address;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
public class AddressDTO {
    @NotNull
    private String street;
    private String number;
    private String complement;
    @NotNull
    private String neighborhood;
    @NotNull
    private String city;
    @NotNull
    private String state;
    @NotNull
    private String postalCode; // CEP

    public static AddressDTO fromEntity(Address address) {
        ModelMapper modelMapper = new ModelMapper();

       return modelMapper.map(address, AddressDTO.class);

    }

    public Address toEntity() {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(this, Address.class);
    }

}
