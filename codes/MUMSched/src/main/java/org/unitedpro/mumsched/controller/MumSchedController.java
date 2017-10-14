package org.unitedpro.mumsched.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Duong Truong on 10/13/2017.
 */
@Controller
public class MumSchedController {
    @RequestMapping(value="/",method= RequestMethod.GET)
    public String Hello(Model model) {
        model.addAttribute("name", "SWE Class");
        return "Hello";
    }
}
