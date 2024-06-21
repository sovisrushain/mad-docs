package com.cisco.hospital_service.controller;

import com.cisco.hospital_service.dto.ResponseDTO;
import com.cisco.hospital_service.model.Hospital;
import com.cisco.hospital_service.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hospitals")
public class HospitalController {

    private final HospitalService hospitalService;

    @GetMapping
    public ResponseDTO<List<Hospital>> getAllHospitals() {
        List<Hospital> hospitals = hospitalService.getAllHospitals();
        ResponseDTO<List<Hospital>> responseDTO = new ResponseDTO<>();
        if (hospitals.isEmpty()) {
            responseDTO.setData(hospitals);
            responseDTO.setMessage("there are no hospitals registered");
            responseDTO.setStatusCode(HttpStatus.OK);
        } else {
            responseDTO.setData(hospitals);
            responseDTO.setMessage("all hospitals");
            responseDTO.setStatusCode(HttpStatus.OK);
        }
        return responseDTO;
    }

    @GetMapping("/{id}")
    public ResponseDTO<Hospital> getHospitalById(@PathVariable String id) {
        Hospital hospital = hospitalService.getHospitalById(id);
        ResponseDTO<Hospital> responseDTO = new ResponseDTO<>();
        if (hospital != null) {
            responseDTO.setData(hospital);
            responseDTO.setMessage("hospital found for id: " + id);
            responseDTO.setStatusCode(HttpStatus.OK);
        } else {
            responseDTO.setStatusCode(HttpStatus.NOT_FOUND);
            responseDTO.setMessage("hospital not found");
            responseDTO.setData(null);
        }
        return responseDTO;
    }

    @PostMapping
    public ResponseDTO<Integer> createHospital(@RequestBody Hospital hospital, BindingResult bindingResult) {
        ResponseDTO<Integer> responseDTO = new ResponseDTO<>();
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(err -> err.getField() + ": " + err.getDefaultMessage())
                    .toList();
            responseDTO.setMessage(errors.getFirst());
            responseDTO.setStatusCode(HttpStatus.BAD_REQUEST);
            return responseDTO;
        }
        Integer res = hospitalService.addHospital(hospital);
        if (res == 1) {
            responseDTO.setData(res);
            responseDTO.setStatusCode(HttpStatus.CREATED);
            responseDTO.setMessage("hospital created");
        } else {
            responseDTO.setData(res);
            responseDTO.setMessage("hospital not created");
            responseDTO.setStatusCode(HttpStatus.CONFLICT);
        }
        return responseDTO;
    }

    @PutMapping("/{id}")
    public ResponseDTO<Integer> updateHospital(@PathVariable String id, @RequestBody Hospital hospital, BindingResult bindingResult) {
        ResponseDTO<Integer> responseDTO = new ResponseDTO<>();
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(err -> err.getField() + ": " + err.getDefaultMessage())
                    .toList();
            responseDTO.setMessage(errors.getFirst());
            responseDTO.setStatusCode(HttpStatus.BAD_REQUEST);
            return responseDTO;
        }
        Integer res = hospitalService.updateHospital(id, hospital);
        if (res == 1) {
            responseDTO.setData(res);
            responseDTO.setStatusCode(HttpStatus.CREATED);
            responseDTO.setMessage("hospital updated with id: " + id);
        } else {
            responseDTO.setData(res);
            responseDTO.setMessage("hospital not updated");
            responseDTO.setStatusCode(HttpStatus.CONFLICT);
        }
        return responseDTO;
    }

    @DeleteMapping("/{id}")
    public ResponseDTO<Integer> deleteHospital(@PathVariable String id) {
        Integer res = hospitalService.deleteHospital(id);
        ResponseDTO<Integer> responseDTO = new ResponseDTO<>();
        if (res == 1) {
            responseDTO.setData(res);
            responseDTO.setMessage("hospital deleted");
            responseDTO.setStatusCode(HttpStatus.NO_CONTENT);
        } else {
            responseDTO.setData(res);
            responseDTO.setMessage("hospital not deleted");
            responseDTO.setStatusCode(HttpStatus.CONFLICT);
        }
        return responseDTO;
    }

    @GetMapping("/all")
    public ResponseDTO<Integer> getHospitalCount() {
        ResponseDTO<Integer> responseDTO = new ResponseDTO<>();
        Integer hospitalsCount = hospitalService.getHospitalsCount();
        responseDTO.setData(hospitalsCount);
        responseDTO.setStatusCode(HttpStatus.OK);
        return responseDTO;
    }

}
