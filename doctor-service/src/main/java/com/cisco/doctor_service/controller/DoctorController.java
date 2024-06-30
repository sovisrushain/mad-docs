package com.cisco.doctor_service.controller;

import com.cisco.doctor_service.dto.ResponseDTO;
import com.cisco.doctor_service.model.Doctor;
import com.cisco.doctor_service.service.DoctorService;
import com.cisco.doctor_service.utl.ValidationHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping
    public ResponseDTO<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        ResponseDTO<List<Doctor>> responseDTO = new ResponseDTO<>();
        if (doctors.isEmpty()) {
            responseDTO.setData(doctors);
            responseDTO.setMessage("there are no doctors registered");
            responseDTO.setStatusCode(HttpStatus.OK);
        } else {
            responseDTO.setData(doctors);
            responseDTO.setMessage("all doctors");
            responseDTO.setStatusCode(HttpStatus.OK);
        }
        return responseDTO;
    }

    @GetMapping("/{id}")
    public ResponseDTO<Doctor> getDoctorById(@PathVariable String id) {
        Doctor doctor = doctorService.getDoctorById(id);
        ResponseDTO<Doctor> responseDTO = new ResponseDTO<>();
        if (doctor != null) {
            responseDTO.setData(doctor);
            responseDTO.setMessage("doctor found for id: " + id);
            responseDTO.setStatusCode(HttpStatus.OK);
        } else {
            responseDTO.setStatusCode(HttpStatus.NOT_FOUND);
            responseDTO.setMessage("doctor not found");
            responseDTO.setData(null);
        }
        return responseDTO;
    }

    @PostMapping
    public ResponseDTO<Integer> createDoctor(@RequestBody Doctor doctor, BindingResult bindingResult) {
        ResponseDTO<Integer> responseDTO = new ResponseDTO<>();
        if (bindingResult.hasErrors()) {
            return ValidationHandler.handleValidation(bindingResult, responseDTO);
        }
        Integer res = doctorService.addDoctor(doctor);
        if (res == 1) {
            responseDTO.setData(res);
            responseDTO.setStatusCode(HttpStatus.CREATED);
            responseDTO.setMessage("doctor created");
        } else {
            responseDTO.setData(res);
            responseDTO.setMessage("doctor not created");
            responseDTO.setStatusCode(HttpStatus.CONFLICT);
        }
        return responseDTO;
    }

    @PutMapping("/{id}")
    public ResponseDTO<Integer> updateDoctor(@PathVariable String id, @RequestBody Doctor doctor, BindingResult bindingResult) {
        ResponseDTO<Integer> responseDTO = new ResponseDTO<>();
        if (bindingResult.hasErrors()) {
            return ValidationHandler.handleValidation(bindingResult, responseDTO);
        }
        Integer res = doctorService.updateDoctor(id, doctor);
        if (res == 1) {
            responseDTO.setData(res);
            responseDTO.setStatusCode(HttpStatus.CREATED);
            responseDTO.setMessage("doctor updated with id: " + id);
        } else {
            responseDTO.setData(res);
            responseDTO.setMessage("doctor not updated");
            responseDTO.setStatusCode(HttpStatus.CONFLICT);
        }
        return responseDTO;
    }

    @DeleteMapping("/{id}")
    public ResponseDTO<Integer> deleteDoctor(@PathVariable String id) {
        Integer res = doctorService.deleteDoctor(id);
        ResponseDTO<Integer> responseDTO = new ResponseDTO<>();
        if (res == 1) {
            responseDTO.setData(res);
            responseDTO.setMessage("doctor deleted");
            responseDTO.setStatusCode(HttpStatus.NO_CONTENT);
        } else {
            responseDTO.setData(res);
            responseDTO.setMessage("doctor not deleted");
            responseDTO.setStatusCode(HttpStatus.CONFLICT);
        }
        return responseDTO;
    }

    @GetMapping("/all")
    public ResponseDTO<Integer> getDoctorCount() {
        ResponseDTO<Integer> responseDTO = new ResponseDTO<>();
        Integer doctorsCount = doctorService.getDoctorsCount();
        responseDTO.setData(doctorsCount);
        responseDTO.setMessage("total doctor count");
        responseDTO.setStatusCode(HttpStatus.OK);
        return responseDTO;
    }

}
