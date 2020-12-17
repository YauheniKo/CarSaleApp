package by.eugene.car.sale.repository;


import by.eugene.car.sale.domain.Ad;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdRepo extends CrudRepository<Ad, Long> {

    List<Ad> findByTag(String tag);

    List<Ad> findByCar_Brand(String brand);






}
