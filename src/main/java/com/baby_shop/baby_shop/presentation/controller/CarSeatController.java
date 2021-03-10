package com.baby_shop.baby_shop.presentation.controller;

import com.baby_shop.baby_shop.model.Car_seat;
import com.baby_shop.baby_shop.repository.CarSeatRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/car-seat")
public class CarSeatController {

    private final CarSeatRepository carSeatRepository;

    private String prod_name;
    private String thumbnail;
    private int price;
    private String availability;
    private String description;

    public CarSeatController(CarSeatRepository carSeatRepository) {
        this.carSeatRepository = carSeatRepository;
    }

    @GetMapping(path = "")
    public String getSeats(Model model){
        List<Car_seat> seats = carSeatRepository.findAll();
        model.addAttribute("seats", seats);
        return "CarSeats";
    }

    @GetMapping(path = "/add-new")
    public String addFood(){
        return "CarSeatAddNew";
    }

    @PostMapping(path = "/add-new")
    public String saveCarSeat(Model model, @RequestParam(name = "prod_name") String prod_name, @RequestParam(name = "thumbnail") String thumbnail, @RequestParam(name = "price") int price, @RequestParam(name = "availability") String availability, @RequestParam(name = "description") String description){

        this.availability=availability;
        this.description=description;
        this.price=price;
        this.thumbnail=thumbnail;
        this.prod_name=prod_name;

        Car_seat car_seat = new Car_seat();

        car_seat.setAvailability(availability);
        car_seat.setThumbnail(thumbnail);
        car_seat.setDescription(description);
        car_seat.setProd_name(prod_name);
        car_seat.setPrice(price);

        carSeatRepository.save(car_seat);

        return "redirect:/car-seat/";
    }


    @GetMapping(path = "/{id}/edit")
    public String editCarSeat(Model model, @PathVariable("id") Integer id){
        try{
            Car_seat carSeat = this.carSeatRepository.findById(id).orElseThrow();
            model.addAttribute("carSeat", carSeat);
            return "CarSeatEdit";
        } catch (RuntimeException ex){
            return "error";
        }
    }

    @PostMapping(path = "/{id}/edit")
    public String saveCarSeat(@PathVariable Integer id, @Valid Car_seat seat,
                           BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "CarSeats";
        }
        Car_seat car_seat = carSeatRepository.findById(id).orElseThrow();

        car_seat.setAvailability(seat.getAvailability());
        car_seat.setThumbnail(seat.getThumbnail());
        car_seat.setDescription(seat.getDescription());
        car_seat.setProd_name(seat.getProd_name());
        car_seat.setPrice(seat.getPrice());

        carSeatRepository.save(car_seat);

        return "redirect:/car-seat/";
    }

    @GetMapping(path = "/{id}")
    public String getSingleProduct(@PathVariable Integer id, Model model){
        Car_seat seat = carSeatRepository.getOne(id);
        model.addAttribute("seat", seat);
        return "SingleCarSeat";
    }


}
