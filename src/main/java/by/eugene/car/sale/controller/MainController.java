package by.eugene.car.sale.controller;


import by.eugene.car.sale.domain.Ad;
import by.eugene.car.sale.domain.Car;
import by.eugene.car.sale.domain.User;
import by.eugene.car.sale.repository.AdRepo;
import by.eugene.car.sale.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
public class MainController {

    @Autowired
    private AdRepo adRepo;

    @Autowired
    CarRepo carRepo;

    @Value("${upload.path}")
    private String uploadPath;


    @GetMapping("/")
    public String greeting(Map<String, Object> model) {

        return "greeting";
    }

    @GetMapping("/main")
    public String filter(@RequestParam(required = false, defaultValue = "") String filter,
                         @RequestParam(required = false, defaultValue = "") String filter1, Model model) {
        Iterable<Ad> ads;

        if (filter != null && !filter.isEmpty() &&
                filter1 != null && !filter1.isEmpty()) {
            ads = adRepo.findByTagAndCar_Brand(filter, filter1);

        } else if (filter != null && !filter.isEmpty()) {
            ads = adRepo.findByTag(filter);

        } else if (filter1 != null && !filter1.isEmpty()) {
            ads = adRepo.findByCar_Brand(filter1);
        } else {
            ads = adRepo.findAll();
        }

        model.addAttribute("ads", ads);
        model.addAttribute("filter", filter);
        model.addAttribute("filter1", filter1);
        return "main";

    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag,
            @Valid Ad ad, Car car,
            BindingResult bindingResult,
            @RequestParam String brand, @RequestParam String mod,
            @RequestParam int year, @RequestParam String bodyType,
            @RequestParam String transmission, @RequestParam String typeOfDrive,
            @RequestParam String fuel, @RequestParam double volume,
            @RequestParam double price,
          @RequestParam("file") MultipartFile file,
            Model model
    ) throws IOException {

         car = new Car(brand, mod, year, bodyType, transmission,
                typeOfDrive, fuel, volume, price, user);

        carRepo.save(car);


            ad = new Ad(text, tag, user, car);


        if(bindingResult.hasErrors()){
            Map<String, String> errorMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorMap);
            model.addAttribute("ad",ad);
        }else {

            if (file != null && !file.getOriginalFilename().isEmpty()) {
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }
                String uuidFile = UUID.randomUUID().toString();
                String resultFileName = uuidFile + "." + file.getOriginalFilename();
                file.transferTo(new File(uploadPath + "/" + resultFileName));
                ad.setFilename(resultFileName);
            }


            adRepo.save(ad);
        }
        Iterable<Ad> ads = adRepo.findAll();
        model.addAttribute("ads", ads);

        return "main";
    }




}
