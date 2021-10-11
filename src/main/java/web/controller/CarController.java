package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Service.CarService;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String printCars(@RequestParam(value = "count", required = false) Integer count, ModelMap modelMap) {
        List<Car> cars;
        if (count >= 5) {
            cars = carService.getAllCars();
        } else {
            cars = carService.getSomeCars(count);
        }
        modelMap.addAttribute("messages", cars);
        return "cars";
    }
}
