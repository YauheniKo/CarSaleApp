package by.eugene.car.sale.controller;



import by.eugene.car.sale.domain.Ad;
import by.eugene.car.sale.domain.Car;
import by.eugene.car.sale.domain.User;
import by.eugene.car.sale.repository.AdRepo;
import by.eugene.car.sale.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private AdRepo adRepo;

    @Autowired
    CarRepo carRepo;



    @GetMapping("/")
    public String greeting(Map<String, Object> model) {

        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Ad> ads = adRepo.findAll();
        model.put("ads", ads);

        return "main";

    }


    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String brand,
            @RequestParam String tag, Map<String, Object> model
    ) {

        Car car = new Car(brand, user);
        carRepo.save(car);
        Ad ad = new Ad(text, tag, user, car);

        adRepo.save(ad);
        Iterable<Ad> ads = adRepo.findAll();
        model.put("ads", ads);

        return "main";
    }



    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){
        Iterable<Ad> ads;

        if(filter !=null && !filter.isEmpty()){
             ads = adRepo.findByTag(filter);

        }else {
            ads = adRepo.findAll();
        }
        model.put("ads", ads);

        return "main";
    }
    @PostMapping("filter1")
    public String filter1(@RequestParam String filter, Map<String, Object> model){
        Iterable<Ad> ads;

        if(filter !=null && !filter.isEmpty()){
            ads = adRepo.findByCar_Brand(filter);

        }else {
            ads = adRepo.findAll();
        }
        model.put("ads", ads);

        return "main";
    }





}
