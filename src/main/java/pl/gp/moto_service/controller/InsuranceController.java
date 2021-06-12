package pl.gp.moto_service.controller;


import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.gp.moto_service.entity.Insurance;
import pl.gp.moto_service.entity.Vehicle;
import pl.gp.moto_service.model.InsuranceViewModel;
import pl.gp.moto_service.repository.insurance.InsuranceServices;
import pl.gp.moto_service.repository.vehicle.VehicleService;

import javax.validation.Valid;
import java.util.List;

@Data
@Controller
@RequestMapping("panel")
public class InsuranceController {
    private final VehicleService vehicleService;
    private final InsuranceServices insuranceService;
    private final InsuranceViewModel insuranceViewModel;



    @GetMapping("/insurancelist/{id}")
    public String showInsurance(@PathVariable int id, Model model){
        model.addAttribute("expire", insuranceViewModel.activeList(id));
        model.addAttribute("vehId", vehicleService.getVehicleByID(id).get().getId());
        return "insurance/showinsurance";
    }

    @GetMapping("/insurancelist/{id}/all")
    public String showAllInsurance(@PathVariable int id, Model model){
        model.addAttribute("expire", insuranceViewModel.showAllList(id));
        model.addAttribute("vehId", vehicleService.getVehicleByID(id).get().getId());
        return "insurance/showinsurance";
    }

    @GetMapping("/addinsurance")
    public String addInsurance(Model model){
        model.addAttribute("insurance", new Insurance());
        model.addAttribute("vehicles", vehicleList());
        return "insurance/addform";
    }
    @PostMapping("/addinsurance")
    public String addInsurancePost(@ModelAttribute ("insurance") @Valid Insurance insurance, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "insurance/addform";
        }
        insuranceService.createInsurance(insurance);
        return "redirect:../insurancelist/"+insurance.getVehicle().getId();
    }

    @ModelAttribute("vehicels")
    public List<Vehicle> vehicleList(){
        return vehicleService.getVehiclesByArchivesFalse();
    }
}
