package co.develhope.esercizio_api_custom_queries_2.repositories;

import co.develhope.esercizio_api_custom_queries_2.entities.Flight;
import co.develhope.esercizio_api_custom_queries_2.entities.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByFlightStatus(FlightStatus status);
    List<Flight> findByFlightStatus(FlightStatus p1, FlightStatus p2);
}
