package ua.slava.flyhub.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.slava.flyhub.domen.models.Member;
import ua.slava.flyhub.domen.models.Plane;
import ua.slava.flyhub.repositories.PlaneRepository;
import ua.slava.flyhub.services.PlaneService;

@Controller
@RequiredArgsConstructor
public class PlaneController {

    private final PlaneService planeService;
    private final PlaneRepository planeRepository;

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("planes", planeRepository.findAll());
        return "planes-page";
    }

    @GetMapping("/getPlane")
    public String getPlane(@RequestParam(name = "name", required = false) String name, Model model) {
        Plane plane = planeService.getPlane(name);
        model.addAttribute("plane", plane);
        return "planes-page";
    }


    @GetMapping("/plane/{id}")
    public String planeInfo(@PathVariable Long id, Model model) {
        Plane plane = planeService.getPlaneById(id);
        model.addAttribute("plane", plane);
        return "plane-info";
    }

    @PostMapping("/plane/create")
    public String createPlane(Plane plane) {
        planeService.savePlane(plane);
        return "redirect:/";
    }

    @GetMapping("/plane/delete/{planeId}")
    public String deletePlane(@PathVariable Long planeId) {
        planeService.deletePlane(planeId);
        return "redirect:/";
    }

    @GetMapping("/plane/fuel/{planeId}")
    public String fuelCons(@RequestParam(name = "dist", required = false) double dist,
                           @PathVariable(name = "planeId", required = false) Long planeId,
                           Model model) {
        model.addAttribute("fuelConsumption", planeService.fuelConsumption(planeId, dist));
        return "fuel";
    }


}
