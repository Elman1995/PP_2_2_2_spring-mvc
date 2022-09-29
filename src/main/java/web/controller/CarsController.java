package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    private final CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String Cars(ModelMap model, @RequestParam(value = "count", required = false) Integer count) {

        if(count != null) {
            if(count >= 5) {
                model.addAttribute("cars", carService.getEverything());
            }
            else {
                model.addAttribute("cars", carService.getByQuantity(count));
            }
        }
        else {
             model.addAttribute("cars", carService.getEverything());
        }
        return "car";
    }

}
