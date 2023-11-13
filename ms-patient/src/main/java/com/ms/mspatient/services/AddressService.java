package com.ms.mspatient.services;


import com.ms.mspatient.dtos.AddressDTO;
import com.ms.mspatient.models.Address;
import com.ms.mspatient.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository repository;


        @Autowired
        private AddressRepository addressRepository;

        public Address saveAddress(Address data){
            return addressRepository.save(data);
        }

        public Address updateAddress(Address existingAddress, AddressDTO updatedData) {
            if (existingAddress == null || updatedData == null) {
                throw new IllegalArgumentException("Endereço ou dados de atualização inválidos.");
            }

            // Verifique cada campo do endereço no DTO e atualize apenas se não for nulo
            if (updatedData.getStreet() != null) {
                existingAddress.setStreet(updatedData.getStreet());
            }
            if (updatedData.getNumber() != null) {
                existingAddress.setNumber(updatedData.getNumber());
            }
            if (updatedData.getComplement() != null) {
                existingAddress.setComplement(updatedData.getComplement());
            }
            if (updatedData.getNeighborhood() != null) {
                existingAddress.setNeighborhood(updatedData.getNeighborhood());
            }
            if (updatedData.getCity() != null) {
                existingAddress.setCity(updatedData.getCity());
            }
            if (updatedData.getState() != null) {
                existingAddress.setState(updatedData.getState());
            }
            if (updatedData.getPostalCode() != null) {
                existingAddress.setPostalCode(updatedData.getPostalCode());
            }

            // Salve o endereço atualizado no repositório (se necessário)
            return addressRepository.save(existingAddress);
        }
    }


