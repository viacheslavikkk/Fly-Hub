package ua.slava.flyhub.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FuelConsumptionDto {

    private double fuelRemainder;
    private double consumeFuelOnRoute;

}
