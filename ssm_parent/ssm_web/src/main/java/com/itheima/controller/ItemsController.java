package com.itheima.controller;

import com.itheima.pojo.Items;
import com.itheima.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;
    @RequestMapping("/findAll")
    public String show(Model model){
        List<Items> itemsList = itemsService.findAll();
        model.addAttribute("itemsList",itemsList);
        return "items";
    }
    @RequestMapping("/add")
    public String addItems(Items items){
        itemsService.addItems(items);
        return "redirect:findAll";
    }
}
