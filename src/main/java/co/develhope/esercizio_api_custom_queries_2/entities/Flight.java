package co.develhope.esercizio_api_custom_queries_2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    @Id
    @GeneratedValue
    private long id;
    private String description;
    private String fromAirport;
    private String toAirport;
    @Enumerated(EnumType.STRING)
    private FlightStatus flightStatus;
}
