package com.cisco.hospital_service.model;

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
    private String hospitalId;
    private String hospitalName;
    private String hospitalAddress;
}
