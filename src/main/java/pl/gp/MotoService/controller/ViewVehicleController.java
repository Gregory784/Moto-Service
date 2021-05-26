package pl.gp.MotoService.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.gp.MotoService.entity.Insurance;
import pl.gp.MotoService.entity.Vehicle;
import pl.gp.MotoService.repository.insurance.InsuranceService;
import pl.gp.MotoService.repository.vehicle.VehicleService;

import javax.validation.Valid;

@Controller
@RequestMapping("vehicle")
public class ViewVehicleController {

    private final VehicleService vehicleService;
    private final InsuranceService insuranceService;

    public ViewVehicleController(final VehicleService vehicleService, final InsuranceService insuranceService) {
        this.vehicleService = vehicleService;
        this.insuranceService = insuranceService;
    }

    @GetMapping("/addvehicle")
    public String addVehicle(Model model){
        model.addAttribute("vehicle", new Vehicle());
        return "vehicle/addform";
    }


    @PostMapping("/addvehicle")
    public String addVehicle(@ModelAttribute ("vehicle") @Valid Vehicle vehicle, BindingResult violations, Model model){
        if (violations.hasErrors()){
            return "vehicle/addform";
        }
        vehicleService.createVehicle(vehicle);
        model.addAttribute("vehicle", new Vehicle());
        model.addAttribute("message", "Dodano nowy pojazd o nazwie: "+vehicle.getName());
        return /*"redirect:addvehicle"*/ "vehicle/addform";
    }

    @GetMapping ("/show")
    public String showVehicle(Model model){
        model.addAttribute("vehicles", vehicleService.getVehiclesByArchivesFalse());
        return "vehicle/showvehicle";
    }
}
