package com.cisco.hospital_service.controller;

import com.cisco.hospital_service.dto.ResponseDTO;
import com.cisco.hospital_service.model.Hospital;
import com.cisco.hospital_service.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ResponseDTO<List<Hospital>>> getAllHospitals() {
        List<Hospital> hospitals = hospitalService.getAllHospitals();
        ResponseDTO<List<Hospital>> responseDTO = new ResponseDTO<>();
        responseDTO.setData(hospitals);
        responseDTO.setMessage("all hospitals");
        responseDTO.setStatusCode(HttpStatus.OK);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<Hospital>> getHospitalById(@PathVariable Integer id) {
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
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<Integer>> createHospital(@RequestBody Hospital hospital, BindingResult bindingResult) {
        ResponseDTO<Integer> responseDTO = new ResponseDTO<>();
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(err -> err.getField() + ": " + err.getDefaultMessage())
                    .toList();
            responseDTO.setMessage(errors.getFirst());
            responseDTO.setStatusCode(HttpStatus.BAD_REQUEST);
            return ResponseEntity.ok(responseDTO);
        }
        Integer res = hospitalService.addHospital(hospital);
        responseDTO.setData(res);
        responseDTO.setStatusCode(HttpStatus.CREATED);
        responseDTO.setMessage("hospital created");
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO<Integer>> updateHospital(@PathVariable Integer id, @RequestBody Hospital hospital, BindingResult bindingResult) {
        ResponseDTO<Integer> responseDTO = new ResponseDTO<>();
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(err -> err.getField() + ": " + err.getDefaultMessage())
                    .toList();
            responseDTO.setMessage(errors.getFirst());
            responseDTO.setStatusCode(HttpStatus.BAD_REQUEST);
            return ResponseEntity.ok(responseDTO);
        }
        Integer res = hospitalService.updateHospital(hospital);
        responseDTO.setData(res);
        responseDTO.setStatusCode(HttpStatus.CREATED);
        responseDTO.setMessage("hospital updated with id: " + id);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO<Integer>> deleteHospital(@PathVariable Integer id) {
        Integer res = hospitalService.deleteHospital(id);
        ResponseDTO<Integer> responseDTO = new ResponseDTO<>();
        responseDTO.setData(res);
        responseDTO.setStatusCode(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDTO<Integer>> getHospitalCount() {
        ResponseDTO<Integer> responseDTO = new ResponseDTO<>();
        Integer hospitalsCount = hospitalService.getHospitalsCount();
        responseDTO.setData(hospitalsCount);
        responseDTO.setStatusCode(HttpStatus.OK);
        return ResponseEntity.ok(responseDTO);
    }

}
