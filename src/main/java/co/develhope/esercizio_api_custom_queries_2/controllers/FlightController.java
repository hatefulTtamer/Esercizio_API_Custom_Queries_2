package co.develhope.esercizio_api_custom_queries_2.controllers;

import co.develhope.esercizio_api_custom_queries_2.entities.Flight;
import co.develhope.esercizio_api_custom_queries_2.entities.FlightStatus;
import co.develhope.esercizio_api_custom_queries_2.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @PostMapping
    public ResponseEntity<List<Flight>> insertMany () {
        return ResponseEntity.ok().body(flightService.insertFlights());
    }

    @GetMapping
    public ResponseEntity<List<Flight>> findMany (@RequestParam(required = false, defaultValue = "100") int n) {
        return ResponseEntity.ok().body(flightService.findNFlights(n));
    }

    @GetMapping("/sorting")
    public ResponseEntity<Page<Flight>> findSortByFromAirport (
            @RequestParam(required = false, defaultValue = "1") int pageNumber,
            @RequestParam(required = false, defaultValue = "10") int pageSize) {
        return ResponseEntity.ok().body(flightService.findFlightsSortByFromAirport(pageNumber, pageSize));
    }

    @GetMapping("/on-time")
    public ResponseEntity<List<Flight>> findOnTime () {
        return ResponseEntity.ok().body(flightService.findByOnTimeFlights());
    }

    @GetMapping("/flight-status")
    public ResponseEntity<List<Flight>> findByP1OrP2 (
            @RequestParam FlightStatus p1, @RequestParam FlightStatus p2
            ) {
        return ResponseEntity.ok().body(flightService.findByP1orP2Flights(p1, p2));
    }
}
