package pl.gp.moto_service.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.gp.moto_service.entity.TechReview;
import pl.gp.moto_service.entity.Vehicle;
import pl.gp.moto_service.model.TechViewModel;
import pl.gp.moto_service.repository.tech_review.TechReviewService;
import pl.gp.moto_service.repository.vehicle.VehicleService;

import javax.validation.Valid;
import java.util.List;

@Data
@Controller
@RequestMapping("panel")
public class TechReviewController {
    private final TechReviewService techReviewService;
    private final VehicleService vehicleService;
    private final TechViewModel techViewModel;

    @GetMapping("/techlist/{id}")
    public String showActivTech(@PathVariable int id, Model model){
        model.addAttribute("tech", techViewModel.showActivTech(id));
        model.addAttribute("vehId", vehicleService.getVehicleByID(id).get().getId());
        return "techreview/showtech";
    }
    @GetMapping("/techlist/{id}/all")
    public String showAllTech(@PathVariable int id, Model model){
        model.addAttribute("tech", techViewModel.showInsurances(id));
        model.addAttribute("vehId", vehicleService.getVehicleByID(id).get().getId());
        return "techreview/showtech";
    }

    @GetMapping("/addtech")
    public String addtech(Model model){
        model.addAttribute("tech", new TechReview());
        model.addAttribute("veh", vehicleList());
        return "techreview/addform";
    }
    @PostMapping("/addtech")
    public String addtech(@ModelAttribute("tech")  @Valid TechReview techReview,  BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "techreview/addform";
        }
        techReviewService.createTechReviews(techReview);
        return "redirect:../insurancelist/"+techReview.getVehicle().getId();
    }
    @ModelAttribute("veh")
    public List<Vehicle> vehicleList(){
        return vehicleService.getVehiclesByArchivesFalse();
    }
}
