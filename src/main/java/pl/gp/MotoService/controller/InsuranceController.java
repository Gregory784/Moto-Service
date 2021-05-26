package pl.gp.MotoService.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.gp.MotoService.entity.Insurance;
import pl.gp.MotoService.repository.insurance.InsuranceService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/vehicle/insurance")
public class InsuranceController {
    private final InsuranceService insuranceService;

    public InsuranceController(final InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @GetMapping
    public List<Insurance> showVehicles(){
        return insuranceService.getInsurance();
    }

    @PostMapping("/add")
    public String create(@RequestBody @Valid Insurance insurance){
        insuranceService.createInsurance(insurance);
        return insurance.toString();
    }
}
