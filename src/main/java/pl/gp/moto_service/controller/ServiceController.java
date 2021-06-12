package pl.gp.moto_service.controller;


import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.gp.moto_service.entity.Oil;
import pl.gp.moto_service.entity.Service;
import pl.gp.moto_service.entity.Vehicle;
import pl.gp.moto_service.model.ServiceViewModel;
import pl.gp.moto_service.repository.oil.OilService;
import pl.gp.moto_service.repository.service.ServService;
import pl.gp.moto_service.repository.vehicle.VehicleService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Data
@Controller
@RequestMapping("panel")
public class ServiceController {
    private final ServService service;
    private final VehicleService vehicleService;
    private final OilService oilService;
    private final ServiceViewModel serviceViewModel;


    @GetMapping("/service/{id}")
    public String showServices(@PathVariable int id, Model model) {
        List<ServiceViewModel> list = serviceViewModel.showModelServicesView(id);
        list.sort(Comparator.comparing(ServiceViewModel::isActive).reversed());
        model.addAttribute("service", list);
        model.addAttribute("vehicle", vehicleService.getVehicleByID(id));
        model.addAttribute("oils", oilService.getOils());
        return "service/servicelist";
    }

    @GetMapping("/addservice")
    public String addService(Model model) {
        model.addAttribute("service", new Service());
        model.addAttribute("vehicles", vehicleList());
        model.addAttribute("oils", oilList());
        model.addAttribute("type", serviceTypeList());
        return "service/addservice";
    }

    @PostMapping("/addservice")
    public String addService(@ModelAttribute("vehicles") Vehicle vehicle,
                             @ModelAttribute("oils") Oil oil,
                             @ModelAttribute @Valid Service currentService,
                             @ModelAttribute("type") String type,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "service/addservice";
        }
        service.createService(currentService);
        return "redirect:../service/" + currentService.getVehicle().getId();
    }

    @GetMapping("service/addservice/{type}")
    @ResponseBody
    public String addServiceForm(@PathVariable String type) {
        return "jestem i mam " + type;
    }

    @ModelAttribute("vehicles")
    public List<Vehicle> vehicleList() {
        return vehicleService.getVehiclesByArchivesFalse();
    }

    @ModelAttribute("oils")
    public List<Oil> oilList() {
        return oilService.getOils();
    }

    @GetMapping("/service/{id}/sortbydays")
    public String showServicesSortByDays(@PathVariable int id, Model model) {
        List<ServiceViewModel> list = serviceViewModel.showModelServicesView(id);
        list.sort(Comparator.comparingInt(ServiceViewModel::getDaysToNextService));
        model.addAttribute("service", list);
        model.addAttribute("vehicle", vehicleService.getVehicleByID(id));
        model.addAttribute("oils", oilService.getOils());
        return "service/servicelist";
    }

    @GetMapping("/service/{id}/sortbymileage")
    public String showServicesSortByMileage(@PathVariable int id, Model model) {
        List<ServiceViewModel> list = serviceViewModel.showModelServicesView(id);
        list.sort(Comparator.comparingInt(ServiceViewModel::getMileageToNextService));
        model.addAttribute("service", list);
        model.addAttribute("vehicle", vehicleService.getVehicleByID(id));
        model.addAttribute("oils", oilService.getOils());
        return "service/servicelist";
    }

    @ModelAttribute("serviceType")
    public List<String> serviceTypeList() {
        return new ArrayList<String>(
                Arrays.asList(
                        "Engine oil",
                        "Differential oil",
                        "Engine air filter",
                        "Gearbox oil",
                        "Break fluid",
                        "Break pads - front",
                        "Break pads - rear"
                ));
    }
}
