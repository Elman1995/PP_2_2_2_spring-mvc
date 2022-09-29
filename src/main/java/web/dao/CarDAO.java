package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Car;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDAO {

    private static int CARS_COUNT = 0;
    private List<Car> cars;
    {
        cars = new ArrayList<>();
        cars.add(new Car(++CARS_COUNT, "Mercedes-Benz", "Elman"));
        cars.add(new Car(++CARS_COUNT, "BMW", "Elman"));
        cars.add(new Car(++CARS_COUNT, "Audi", "Elman"));
        cars.add(new Car(++CARS_COUNT, "Porsche", "Elman"));
        cars.add(new Car(++CARS_COUNT, "Lamborghini", "Elman"));
        cars.add(new Car(++CARS_COUNT, "Bugatti", "Elman"));
        cars.add(new Car(++CARS_COUNT, "Koenigsegg", "Elman"));
        cars.add(new Car(++CARS_COUNT, "Pagani", "Elman"));
        cars.add(new Car(++CARS_COUNT, "Ferrari", "Elman"));
    }

    public List<Car> getEverything() {
        return cars;
    }

    public List<Car> getByQuantity(int amount) {
        return cars.stream().limit(amount).collect(Collectors.toList());
    }

}
