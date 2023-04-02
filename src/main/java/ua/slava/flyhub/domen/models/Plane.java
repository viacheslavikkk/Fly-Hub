package ua.slava.flyhub.domen.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "plane")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "modification")
    private String modification;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "country")
    private String country;

    @Column(name = "price")
    private Long price;

    @Column(name = "crew_and_passengers")
    private int crewAndPassengers;

    @Column(name = "fuel_capacity")
    private int fuelCapacity;

    @Column(name = "wing_span")
    private double wingSpan;

    @Column(name = "wing_area")
    private double wingArea;

    @Column(name = "empty_mass")
    private int emptyMass;

    @Column(name = "max_take_off_weight")
    private int maxTakeOffWeight;

    @Column(name = "engine")
    private byte engine;

    @Column(name = "payload")
    private int payload;

    @Column(name = "max_speed")
    private int maxSpeed;

    @Column(name = "cruising_speed")
    private int cruisingSpeed;

    @Column(name = "stall_speed")
    private int stallSpeed;

    @Column(name = "celling")
    private int celling;

    @Column(name = "coeff_of_aerodynamic_quality")
    private double coeffOfAerodynamicQuality;

    @Column(name = "consume_fuel_per_hour")
    private double consumeFuelPerHour;

    private LocalDateTime dateOfCreated;

    @PrePersist
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private Member member;


}
