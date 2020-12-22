package by.eugene.car.sale.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String text;

    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private Car car;

    private String filename;



    public Ad() {

    }

    public Ad(String text, String tag, User user, Car car) {
        this.text = text;
        this.tag = tag;
        this.author = user;
        this.car = car;

    }

    public String getAuthorName(){
        return author != null ? author.getUsername(): "<none>";
    }



    public List<String> listInfoCar(){
        List<String> listInfoCar = new ArrayList<>();
        listInfoCar.add(car.getBrand());
        listInfoCar.add(car.getMod());
        listInfoCar.add(String.valueOf(car.getYear()));
        listInfoCar.add(car.getBodyType());
        listInfoCar.add(car.getTransmission());
        listInfoCar.add(car.getTypeOfDrive());
        listInfoCar.add(car.getFuel());
        listInfoCar.add(String.valueOf(car.getVolume()));
        listInfoCar.add(String.valueOf(car.getPrice()));

        return listInfoCar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}


