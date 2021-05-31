package pl.gp.moto_service.controller;


import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.gp.moto_service.entity.Vehicle;
import pl.gp.moto_service.repository.insurance.InsuranceService;
import pl.gp.moto_service.repository.vehicle.VehicleService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("panel")
public class VehicleController {

    private final VehicleService vehicleService;
    private final InsuranceService insuranceService;

    public VehicleController(final VehicleService vehicleService, final InsuranceService insuranceService) {
        this.vehicleService = vehicleService;
        this.insuranceService = insuranceService;
    }

    @GetMapping("/")
    public String test (){
        return "test";
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
        return "redirect:../panel/vehicleslist";
    }

    @GetMapping ("/vehicleslist")
    public String showVehicles(Model model){
        model.addAttribute("vehicles", vehicleService.getVehiclesByArchivesFalse());
        return "vehicle/showall";
    }

    @Transactional
    @GetMapping("/arch/{id}")
    public String toggleArch(@PathVariable int id){
        vehicleService.getVehicleByID(id)
                .ifPresent(vehicle -> vehicle.setArchives(!vehicle.isArchives()));
        return "redirect:../vehicleslist";
    }
    @GetMapping("/getvehicle/{id}")
    public String showVehicleById (@PathVariable int id, Model model){
        vehicleService.getVehicleByID(id)
                .ifPresent(vehicle -> model.addAttribute("vehicledetails", vehicle));
        return "vehicle/getvehicle";
    }

    @GetMapping("/updatemileage/{id}")
    public String upDateMileAge (@PathVariable int id, Model model){
        model.addAttribute("vehicle", vehicleService.getVehicleByID(id));
        return "vehicle/updatemileage";
    }

    @PostMapping("/updatemileage")
    public String upDateMileAge(@ModelAttribute("vehicle") Vehicle vehicle, BindingResult violations){
        Optional<Vehicle> current = vehicleService.getVehicleByID(vehicle.getId());
        if(current.isPresent()){
            current.get().setMileage(vehicle.getMileage());
            vehicleService.updateVehicle(current.get());
        }
        return "redirect:../panel/vehicleslist";
    }

}
