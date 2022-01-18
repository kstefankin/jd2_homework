package by.academy.homework.controller;


import by.academy.homework.dao.ManagerDao;
import by.academy.homework.pojos.Manager1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class MyController {

    @Autowired
    private ManagerDao dao;


    @GetMapping("/start")
    public String sayHello() {
        return "startpage";
    }

    @GetMapping("/exit")
    public String sayGoodbye() {
        return "exitpage";
    }


    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("manager1", new Manager1());
        return "addform";
    }

    @PostMapping("/addNewMan")
    public String addNewMan(@ModelAttribute("manager1") Manager1 manager1) {

        dao.add(manager1);


        return "successpage";
    }


}
