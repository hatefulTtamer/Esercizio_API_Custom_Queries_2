package co.develhope.esercizio_api_custom_queries_2.repositories;

import co.develhope.esercizio_api_custom_queries_2.entities.Flight;
import co.develhope.esercizio_api_custom_queries_2.entities.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByFlightStatus(FlightStatus status);

    @Query("SELECT f FROM Flight f WHERE f.flightStatus = :p1 OR f.flightStatus = :p2")
    List<Flight> findFlightsByFlightStatus(FlightStatus p1, FlightStatus p2);
}
