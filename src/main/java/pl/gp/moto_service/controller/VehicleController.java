package pl.gp.moto_service.controller;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.gp.moto_service.entity.Vehicle;
import pl.gp.moto_service.model.DetailsVehicleViewModel;
import pl.gp.moto_service.repository.vehicle.VehicleService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("panel")
public class VehicleController {

    private final VehicleService vehicleService;
    private final DetailsVehicleViewModel detailsVehicleViewModel;


    @GetMapping("/")
    public String test (){
        return "welcome";
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
                .ifPresent(vehicle ->
                        model.addAttribute("vehicledetails", vehicle).
                                addAttribute("distance", detailsVehicleViewModel.distance(id)).
                                addAttribute("using", detailsVehicleViewModel.useTime(id)).
                                addAttribute("servicecost", detailsVehicleViewModel.serviceCosts(id)));

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
            if(current.get().getMileage() < vehicle.getMileage()) {
                current.get().setMileage(vehicle.getMileage());
                vehicleService.updateVehicle(current.get());
            } else {
                return "redirect:../panel/updatemileage/"+vehicle.getId();}
        }
        return "redirect:../panel/vehicleslist";
    }

    @GetMapping("/edit/{id}")
    public String editVehicle(@PathVariable int id, Model model){
        model.addAttribute("vehicle", vehicleService.getVehicleByID(id));
        return "vehicle/addform";
    }

    @Transactional
    @PostMapping("/edit/{id}")
    public String editVehicle(@ModelAttribute @Valid Vehicle vehicle, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "vehicle/addform";
        }
        vehicleService.updateVehicle(vehicle);
        return "redirect:../panel/vehicleslist";
    }

    @GetMapping("/delete/{id}")
    public String deleteVehicle(@PathVariable int id){
        vehicleService.deleteVehicleByID(id);
        return "redirect:../vehicleslist";
    }
}
