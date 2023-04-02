package ua.slava.flyhub.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.slava.flyhub.domen.models.Plane;
import ua.slava.flyhub.dto.FuelConsumptionDto;
import ua.slava.flyhub.repositories.PlaneRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlaneService {

    private final PlaneRepository planeRepository;

    public Plane getPlane(String name) {
        if (name != null) {
            return planeRepository.findByName(name);
        }
        return null;
    }


    public Plane getPlaneById(Long id) {
        return planeRepository.findById(id).orElse(null);
    }

    public void savePlane(Plane plane) {
        planeRepository.save(plane);
    }

    public void deletePlane(Long id) {
        planeRepository.deleteById(id);
    }

    public FuelConsumptionDto fuelConsumption(Long planeId, double dist) {

        Plane plane = planeRepository.getById(planeId);

        double fullFuelOnBoard = plane.getFuelCapacity();
        double consumeFuelPerHour = plane.getConsumeFuelPerHour();
        int cruisingSpeed = plane.getCruisingSpeed();

        double timeOfFlight = dist / cruisingSpeed;

        double consumeFuelOnRoute = consumeFuelPerHour * timeOfFlight;

        double fuelRemainder = fullFuelOnBoard - consumeFuelOnRoute;

        return FuelConsumptionDto.builder()
                .consumeFuelOnRoute(consumeFuelOnRoute)
                .fuelRemainder(fuelRemainder)
                .build();
    }
}
