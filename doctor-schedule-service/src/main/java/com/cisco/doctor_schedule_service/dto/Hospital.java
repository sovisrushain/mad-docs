package com.cisco.doctor_schedule_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hospital implements Serializable {

    @NotNull(message = "Hospital ID can not be null")
    @Pattern(regexp = "^H\\d{3}$", message = "Wrong hospital ID format")
    private String hospitalId;

    @NotNull(message = "Hospital name can not be null")
    @NotBlank(message = "Hospital name cannot be blank")
    private String hospitalName;

    @NotNull(message = "Hospital address can not be null")
    @NotBlank(message = "Hospital address cannot be blank")
    private String hospitalAddress;

}
