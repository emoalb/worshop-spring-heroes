package com.softuni.worshopspringheroes.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemsController {
    @GetMapping("/merchant")
    public String getMerchant() {
        return "items/merchant.html";

    }
    @GetMapping("/create")
    public String getCreateItem() {
        return "items/create-item.html";

    }
}
