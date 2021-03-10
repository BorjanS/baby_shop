package com.baby_shop.baby_shop.presentation.controller;

import com.baby_shop.baby_shop.model.Food;
import com.baby_shop.baby_shop.repository.FoodRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/food")
public class FoodController {

    private String prod_name;
    private String thumbnail;
    private int price;
    private String availability;
    private String description;


    private final FoodRepository foodRepository;

    public FoodController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @GetMapping(path = "")
    public String getFood(Model model){
        List<Food> food = foodRepository.findAll();
        model.addAttribute("food", food);
        return "Food";
    }

    @GetMapping(path = "/add-new")
    public String addFood(){
        return "FoodAddNew";
    }


    @PostMapping(path = "/add-new")
    public String saveFood(Model model, @RequestParam(name = "prod_name") String prod_name, @RequestParam(name = "thumbnail") String thumbnail, @RequestParam(name = "price") int price, @RequestParam(name = "availability") String availability, @RequestParam(name = "description") String description){

        this.availability=availability;
        this.description=description;
        this.price=price;
        this.thumbnail=thumbnail;
        this.prod_name=prod_name;

        Food food = new Food();

        food.setAvailability(availability);
        food.setThumbnail(thumbnail);
        food.setDescription(description);
        food.setProd_name(prod_name);
        food.setPrice(price);

        foodRepository.save(food);

        return "redirect:/food/";
    }

    @GetMapping(path = "/{id}/edit")
    public String editFood(Model model, @PathVariable("id") Integer id){
        try{
            Food food = this.foodRepository.findById(id).orElseThrow();
            model.addAttribute("food", food);
            return "FoodEdit";
        } catch (RuntimeException ex){
            return "error";
        }
    }

    @PostMapping(path = "/{id}/edit")
    public String saveFood(@PathVariable Integer id, @Valid Food food,
                           BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "Food";
        }
        Food food1 = foodRepository.findById(id).orElseThrow();

        food1.setAvailability(food.getAvailability());
        food1.setThumbnail(food.getThumbnail());
        food1.setDescription(food.getDescription());
        food1.setProd_name(food.getProd_name());
        food1.setPrice(food.getPrice());

        foodRepository.save(food1);

        return "redirect:/food/";
    }

    @GetMapping(path = "/{id}")
    public String getSingleProduct(@PathVariable Integer id, Model model){
        Food food = foodRepository.getOne(id);
        model.addAttribute("food", food);
        return "SingleFood";
    }
}



