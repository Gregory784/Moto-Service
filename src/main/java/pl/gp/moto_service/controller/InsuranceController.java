package pl.gp.moto_service.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.gp.moto_service.entity.Insurance;
import pl.gp.moto_service.entity.Vehicle;
import pl.gp.moto_service.repository.insurance.InsuranceService;
import pl.gp.moto_service.repository.vehicle.VehicleService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("panel")
public class InsuranceController {
    private final VehicleService vehicleService;
    private final InsuranceService insuranceService;

    public InsuranceController(final VehicleService vehicleService, final InsuranceService insuranceService) {
        this.vehicleService = vehicleService;
        this.insuranceService = insuranceService;
    }

    @GetMapping("/insurancelist/{id}")
    public String showInsurance(@PathVariable int id, Model model){
        model.addAttribute("insurance", insuranceService.getInsuranceByVehicle_Id(id));
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
