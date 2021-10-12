package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import web.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao{
    private List<Car> cars = new ArrayList<>();
    {
        cars.add(new Car("Zhiguli", "VAZ", "1999"));
        cars.add(new Car("Corolla", "Toyota", "2001"));
        cars.add(new Car("Camry", "Toyota", "2002"));
        cars.add(new Car("RAV4", "Toyota", "2003"));
        cars.add(new Car("Fortuner", "Toyota", "2004"));
    }

    @Override
    public List<Car> getAllCars() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public List<Car> getSomeCars(int count) {
        return Collections.unmodifiableList(cars.subList(0, count));
    }

    @Override
    public String printCars(Integer count, ModelMap modelMap) {
        List<Car> cars;
        if (count >= 5) {
            cars = getAllCars();
        } else {
            cars = getSomeCars(count);
        }
        modelMap.addAttribute("messages", cars);
        return "cars";
    }
}
