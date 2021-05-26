package pl.gp.MotoService.controller;


import org.springframework.web.bind.annotation.*;
import pl.gp.MotoService.entity.Vehicle;
import pl.gp.MotoService.repository.insurance.InsuranceService;
import pl.gp.MotoService.repository.vehicle.VehicleService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class RESTVehicleController {

    private final VehicleService vehicleService;
    private final InsuranceService insuranceService;

    public RESTVehicleController(final VehicleService vehicleService, final InsuranceService insuranceService) {
        this.vehicleService = vehicleService;
        this.insuranceService = insuranceService;
    }

    @GetMapping
    public List<Vehicle> showVehicles(){
        return vehicleService.getVehicles();
    }

    @PostMapping("/add")
    public String create(@RequestBody @Valid Vehicle vehicle){
        vehicleService.createVehicle(vehicle);
        return vehicle.toString();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id){
        vehicleService.deleteVehicleByID(id);
        return "Delete vehicel by id: "+id;
    }
}
