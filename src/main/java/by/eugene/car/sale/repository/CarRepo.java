package by.eugene.car.sale.repository;



import by.eugene.car.sale.domain.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepo  extends CrudRepository<Car, Long> {

    List<Car> findByBrand(String brand);

}
