package com.ms.doctor.service;


import com.ms.doctor.dto.DoctorDTO;
import com.ms.doctor.exceptions.DoctorNotFoundException;
import com.ms.doctor.model.Address;
import com.ms.doctor.model.Doctor;
import com.ms.doctor.producers.DoctorProducer;
import com.ms.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository repository;
    @Autowired
    private DoctorProducer doctorProducer;
    @Autowired
    private AddressService addressService;

    public List<DoctorDTO> convertList(List<Doctor> list){

        return list.stream().map(DoctorDTO :: fromEntity).collect(Collectors.toList());
    }

    public List<DoctorDTO> searchAll(){
        return  this.convertList(this.repository.findAll());
    }

    public List<DoctorDTO> getActiveDoctors() {
        return this.convertList(repository.findByActive(true));
    }
    @Transactional
    public Doctor createDoctor(Doctor doctor) {
        //create Adress
        Address doctorAddress = doctor.getAddress();
        doctorAddress = addressService.saveAddress(doctorAddress);
        doctor.getAddress().setId(doctorAddress.getId());

        doctor = repository.save(doctor);
        doctorProducer.publishMessageEmail(doctor);

        return doctor;
    }
    public Optional<Doctor> findById(Long id){
        Optional<Doctor> doctorExist=  repository.findById(id);

        if (doctorExist.isEmpty()) {
            throw new DoctorNotFoundException("Doctor not found with id " + id);
        }

        return doctorExist;
    }
    public Doctor updateDoctor(Doctor updatedDoctor, DoctorDTO updatedData) {

        updatedDoctor.setName(updatedData.getName());
        updatedDoctor.setPhone(updatedData.getPhone());

        updatedDoctor.setAddress(addressService.updateAddress(updatedDoctor.getAddress(), updatedData.getAddress()));

        return repository.save(updatedDoctor);
    }

    public void markDoctorAsInactive(Long id) {
        Optional<Doctor> optionalDoctor = repository.findById(id);

        if (optionalDoctor.isPresent()) {
            Doctor doctor = optionalDoctor.get();
            doctor.setActive(false); // Marque o médico como inativo
            repository.save(doctor); // Atualize o estado no banco de dados
        } else {
            throw new DoctorNotFoundException("Médico não encontrado.");
        }
    }


}
