package com.app.controller;

import com.app.model.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @PostMapping("/calculate")
    public String save(@RequestParam("first-operand") String first,@RequestParam String operator, @RequestParam("second-operand") String second, Model model) {
        float firstOperand = Integer.parseInt(first);
        float secondOperand = Integer.parseInt(second);
        char operatorc =operator.charAt(0);
        float result = Calculator.calculate(firstOperand, secondOperand, operatorc);
        model.addAttribute("first",first);
        model.addAttribute("operator",operator);
        model.addAttribute("second",second);
        model.addAttribute("result",result);
        return "result";
    }
    @GetMapping("/")
    public String index(){
        return "index";
    }

}