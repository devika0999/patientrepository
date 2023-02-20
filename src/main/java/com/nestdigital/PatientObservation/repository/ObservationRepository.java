package com.nestdigital.PatientObservation.repository;

import com.nestdigital.PatientObservation.model.Observation;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ObservationRepository extends ReactiveMongoRepository<Observation, String> {
    Flux<Observation> findByPatientId(String patientId);

}
