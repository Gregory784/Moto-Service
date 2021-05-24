package pl.gp.MotoService.controller;


import org.springframework.web.bind.annotation.*;
import pl.gp.MotoService.entity.Vehicle;
import pl.gp.MotoService.repository.vehicle.VehicleService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(final VehicleService vehicleService) {
        this.vehicleService = vehicleService;
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
