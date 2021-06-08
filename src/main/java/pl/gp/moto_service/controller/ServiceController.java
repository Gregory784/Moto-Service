package pl.gp.moto_service.controller;


import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gp.moto_service.entity.Oil;
import pl.gp.moto_service.entity.Service;
import pl.gp.moto_service.entity.Vehicle;
import pl.gp.moto_service.repository.oil.OilService;
import pl.gp.moto_service.repository.service.ServService;
import pl.gp.moto_service.repository.vehicle.VehicleService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Data
@Controller
@RequestMapping("panel")
public class ServiceController {
    private final ServService service;
    private final VehicleService vehicleService;
    private final OilService oilService;

    @GetMapping("/service/{id}")
    public String showServices(@PathVariable int id, Model model){
        Oil test = service.getServiceById(1).getOil();
        System.out.println(test.toString());
        model.addAttribute("service", service.findAllServiceByVehicleId(id));
        model.addAttribute("vehicle", vehicleService.getVehicleByID(id));
        model.addAttribute("oils", oilService.getOils());
        return "service/servicelist";
    }

    @GetMapping("/addservice")
    public String addService(Model model){
        model.addAttribute("service", new Service());
        model.addAttribute("vehicles", vehicleList());
        model.addAttribute("oils", oilList());
        return "service/addservice";
    }
    @PostMapping("/addservice")
    public String addService(@ModelAttribute("vehicles") Vehicle vehicle, @ModelAttribute("oils") Oil oil, Model model){

        return "redirect:../service/addservice/";
    }

    @GetMapping("service/addservice/{type}")
    @ResponseBody
    public String addServiceForm (@PathVariable String type){
        return "jestem i mam "+ type;
    }

    @ModelAttribute("serviceType")
    public List<String> serviceTypeList() {
        return new ArrayList<String>(
                Arrays.asList(
                        "Engine oil",
                        "Oil filter",
                        "Engine air filter",
                        "Gearbox oil",
                        "Gearbox oil filter",
                        "Break fluid",
                        "Break pads - front",
                        "Break pads - rear",
                        "Drive chain",
                        "Other"
                ));
    }

    @ModelAttribute("vehicles")
    public List<Vehicle> vehicleList(){
        return vehicleService.getVehicles();
    }
    @ModelAttribute("oils")
    public List<Oil> oilList(){
        return oilService.getOils();
    }

}
