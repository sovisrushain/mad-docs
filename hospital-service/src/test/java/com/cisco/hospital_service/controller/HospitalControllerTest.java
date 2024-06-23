package com.cisco.hospital_service.controller;

import com.cisco.hospital_service.dto.ResponseDTO;
import com.cisco.hospital_service.model.Hospital;
import com.cisco.hospital_service.service.HospitalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HospitalControllerTest {

    @Mock
    private HospitalService hospitalService;

    @InjectMocks
    private HospitalController hospitalController;

    @BeforeEach
    void setUp() {
        hospitalController = new HospitalController(hospitalService);
    }

    @Test
    void test_get_all_hospitals_no_hospitals() {
        when(hospitalService.getAllHospitals()).thenReturn(Collections.emptyList());
        ResponseDTO<List<Hospital>> response = hospitalController.getAllHospitals();

        assertNotNull(response);
        assertTrue(response.getData().isEmpty());
        assertEquals("there are no hospitals registered", response.getMessage());
        assertEquals(HttpStatus.OK, response.getStatusCode());

        verify(hospitalService, times(1)).getAllHospitals();
    }

    @Test
    void test_get_all_hospitals_with_hospitals() {
        List<Hospital> hospitals = List.of(new Hospital());
        when(hospitalService.getAllHospitals()).thenReturn(hospitals);
        ResponseDTO<List<Hospital>> response = hospitalController.getAllHospitals();

        assertNotNull(response);
        assertFalse(response.getData().isEmpty());
        assertEquals("all hospitals", response.getMessage());
        assertEquals(HttpStatus.OK, response.getStatusCode());

        verify(hospitalService, times(1)).getAllHospitals();
    }

    @Test
    void test_get_hospital_by_id_hospital_found() {
        String id = "1";
        Hospital hospital = new Hospital();
        when(hospitalService.getHospitalById(id)).thenReturn(hospital);
        ResponseDTO<Hospital> response = hospitalController.getHospitalById(id);

        assertNotNull(response);
        assertEquals(hospital, response.getData());
        assertEquals("hospital found for id: " + id, response.getMessage());
        assertEquals(HttpStatus.OK, response.getStatusCode());

        verify(hospitalService, times(1)).getHospitalById(id);
    }

    @Test
    void test_get_hospital_by_id_hospital_not_found() {
        String id = "1";
        when(hospitalService.getHospitalById(id)).thenReturn(null);
        ResponseDTO<Hospital> response = hospitalController.getHospitalById(id);

        assertNotNull(response);
        assertNull(response.getData());
        assertEquals("hospital not found", response.getMessage());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        verify(hospitalService, times(1)).getHospitalById(id);
    }

    @Test
    void test_create_hospital_valid_hospital() {
        Hospital hospital = new Hospital();
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(false);
        when(hospitalService.addHospital(hospital)).thenReturn(1);
        ResponseDTO<Integer> response = hospitalController.createHospital(hospital, bindingResult);

        assertNotNull(response);
        assertEquals(1, response.getData());
        assertEquals("hospital created", response.getMessage());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        verify(hospitalService, times(1)).addHospital(hospital);
    }

//    @Test
//    void test_create_hospital_invalid_hospital() {
//        Hospital hospital = new Hospital();
//        BindingResult bindingResult = mock(BindingResult.class);
//        when(bindingResult.hasErrors()).thenReturn(true);
//        ResponseDTO<Integer> response = hospitalController.createHospital(hospital, bindingResult);
//
//        assertNotNull(response);
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//        verify(hospitalService, never()).addHospital(hospital);
//    }

    @Test
    void test_update_hospital_valid_hospital() {
        String id = "1";
        Hospital hospital = new Hospital();
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(false);
        when(hospitalService.updateHospital(id, hospital)).thenReturn(1);
        ResponseDTO<Integer> response = hospitalController.updateHospital(id, hospital, bindingResult);

        assertNotNull(response);
        assertEquals(1, response.getData());
        assertEquals("hospital updated with id: " + id, response.getMessage());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        verify(hospitalService, times(1)).updateHospital(id, hospital);
    }

//    @Test
//    void test_update_hospital_invalid_hospital() {
//        String id = "1";
//        Hospital hospital = new Hospital();
//        BindingResult bindingResult = mock(BindingResult.class);
//        when(bindingResult.hasErrors()).thenReturn(true);
//        ResponseDTO<Integer> response = hospitalController.updateHospital(id, hospital, bindingResult);
//
//        assertNotNull(response);
//        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
//        verify(hospitalService, never()).updateHospital(id, hospital);
//    }

    @Test
    void test_delete_hospital_hospital_deleted() {
        String id = "1";
        when(hospitalService.deleteHospital(id)).thenReturn(1);
        ResponseDTO<Integer> response = hospitalController.deleteHospital(id);

        assertNotNull(response);
        assertEquals(1, response.getData());
        assertEquals("hospital deleted", response.getMessage());
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

        verify(hospitalService, times(1)).deleteHospital(id);
    }

    @Test
    void test_delete_hospital_hospital_not_deleted() {
        String id = "1";
        when(hospitalService.deleteHospital(id)).thenReturn(0);
        ResponseDTO<Integer> response = hospitalController.deleteHospital(id);

        assertNotNull(response);
        assertEquals(0, response.getData());
        assertEquals("hospital not deleted", response.getMessage());
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());

        verify(hospitalService, times(1)).deleteHospital(id);
    }

    @Test
    void test_get_hospital_count() {
        when(hospitalService.getHospitalsCount()).thenReturn(5);
        ResponseDTO<Integer> response = hospitalController.getHospitalCount();

        assertNotNull(response);
        assertEquals(5, response.getData());
        assertEquals("total hospital count", response.getMessage());
        assertEquals(HttpStatus.OK, response.getStatusCode());

        verify(hospitalService, times(1)).getHospitalsCount();
    }

}