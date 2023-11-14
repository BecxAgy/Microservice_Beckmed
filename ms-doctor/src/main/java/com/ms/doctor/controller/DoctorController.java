package com.ms.doctor.controller;


import com.ms.doctor.dto.DoctorDTO;
import com.ms.doctor.model.Doctor;
import com.ms.doctor.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService service;
    @GetMapping("/get-all-actives")
    public Page<DoctorDTO> listActive(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size) {
        return service.getActiveDoctors(page, size);
    }

    @GetMapping("/get-all")
    public Page<DoctorDTO> getAll(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size) {
        return service.searchAll(page, size);
    }

    @GetMapping("/get-all-without-page")
    public ResponseEntity<List<DoctorDTO>> getAll(){

        return ResponseEntity.status(HttpStatus.OK).body(service.getAllActives());

    }

    @GetMapping("/active/{id}")
    public ResponseEntity<DoctorDTO> isActive(@PathVariable Long id){
        Doctor patient = service.getDoctorActiveById(id);

        return  ResponseEntity.status(HttpStatus.OK).body(DoctorDTO.fromEntity(patient));

    }
    @PostMapping("/create")
    public ResponseEntity<DoctorDTO> createDoctor(@RequestBody @Valid DoctorDTO doctorDTO){
        //torno ele para entidade

        Doctor doctorSave = doctorDTO.toEntity();
        //crio
        service.createDoctor(doctorSave);
        //retorno
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorDTO);
    }

    @PutMapping("/find/{id}")
    public ResponseEntity<DoctorDTO> putDoctor(@PathVariable Long id, @RequestBody @Valid DoctorDTO doctorDTO) {
        //primeiro converto para entity
        Doctor doctorUpdate = doctorDTO.toEntity();

        //depois verifico se existe no banco com findByID
        Optional<Doctor> doctorExist = service.findById(id);

        service.updateDoctor(doctorExist.get(),doctorDTO);

        return ResponseEntity.ok(doctorDTO.fromEntity(doctorExist.get()));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        service.markDoctorAsInactive(id);
        return ResponseEntity.noContent().build(); // Retorne uma resposta 204 No Content
    }

}
