package co.develhope.esercizio_api_custom_queries_2.services;

import co.develhope.esercizio_api_custom_queries_2.entities.Flight;
import co.develhope.esercizio_api_custom_queries_2.entities.FlightStatus;
import co.develhope.esercizio_api_custom_queries_2.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public void insertFlights () {
        List<Flight> flightsToPost = generateRandomFlightList();
        for (Flight flight : flightsToPost) {
            flightRepository.save(flight);
        }
    }

    public List<Flight> findAllFlights () {
        return flightRepository.findAll();
    }

    public Page<Flight> findFlightsSortByFromAirport (int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("fromAirport").ascending());
        return flightRepository.findAll(pageable);
    }

    public List<Flight> findByOnTimeFlights () {
        return flightRepository.findByFlightStatus(FlightStatus.ON_TIME);
    }

    public List<Flight> findByP1orP2Flights (FlightStatus p1, FlightStatus p2) {
        return flightRepository.findByFlightStatus(p1, p2);
    }

    public String generateRandomString() {
        Random random = new Random();
        StringBuilder resultString = new StringBuilder();
        int length = random.nextInt(10);
        for (int i = 0; i <= length; i++) {
            char character = (char) ('a' + random.nextInt(26));
            resultString.append(character);
        }
        return resultString.toString();
    }

    public FlightStatus generateRandomFlightStatus () {
        Random random = new Random();
        FlightStatus[] statuses = FlightStatus.values();
        return statuses[random.nextInt(statuses.length)];
    }

    public List<Flight> generateRandomFlightList (int n) {
        List<Flight> flights = new ArrayList<>();
        for (int i = 1; i<=n; i++) {
            Flight flight = new Flight(i, generateRandomString(), generateRandomString(),
                    generateRandomString(), generateRandomFlightStatus());
            flights.add(flight);
        }
        return flights;
    }

    public List<Flight> generateRandomFlightList () {
        List<Flight> flights = new ArrayList<>();
        for (int i = 1; i<=100; i++) {
            Flight flight = new Flight(i, generateRandomString(), generateRandomString(),
                    generateRandomString(), generateRandomFlightStatus());
            flights.add(flight);
        }
        return flights;
    }


}
