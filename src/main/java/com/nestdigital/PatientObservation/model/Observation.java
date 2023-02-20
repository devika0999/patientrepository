package com.nestdigital.PatientObservation.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "observations")
@Getter
@Setter
public class Observation {
    @Id
    private String id;
    private String patientId;
    private String code;
    private String value;
    private String unit;
    private String display;

    public Observation() {
    }

    public Observation(String id, String patientId, String code, String value, String unit, String display) {
        this.id = id;
        this.patientId = patientId;
        this.code = code;
        this.value = value;
        this.unit = unit;
        this.display = display;
    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getPatientId() {
//        return patientId;
//    }
//
//    public void setPatientId(String patientId) {
//        this.patientId = patientId;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
//
//    public String getUnit() {
//        return unit;
//    }
//
//    public void setUnit(String unit) {
//        this.unit = unit;
//    }
//
//    public String getDisplay() {
//        return display;
//    }
//
//    public void setDisplay(String display) {
//        this.display = display;
//    }
}