package com.nestdigital.PatientObservation.controller;

import com.nestdigital.PatientObservation.model.Observation;
import com.nestdigital.PatientObservation.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static org.springframework.web.reactive.function.BodyExtractors.toMono;

import java.util.List;
import java.util.Map;

@Service
public class ObservationController {
    @Autowired
    private ObservationRepository repository;
    @Bean
    public RouterFunction<ServerResponse> route(ObservationController observationController){
        return RouterFunctions.route(RequestPredicates.POST("/view"),
                request -> request.body(toMono(new ParameterizedTypeReference<Map<String, Object>>() {}))
                        .flatMapMany(observationController::getBypatientId)
                        .collectList()
                        .flatMap(messages -> ServerResponse.ok().bodyValue(messages)));
    }

    public Flux<Observation> getBypatientId(Map<String, Object> observation) {
        String patientId = (String) observation.get("patientId");
        return repository.findByPatientId(patientId);
    }
}
