package com.example.springfoxuebung.controller;

import com.example.springfoxuebung.model.Calculator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private Calculator calculator = new Calculator();

    @GetMapping
    public ResponseEntity<Calculator> getValue(
            @RequestParam(required = false) String add,
            @RequestParam(required = false) String subtract,
            @RequestParam(required = false) String multiply,
            @RequestParam(required = false) String divide
    ) {
        if (add != null) {
            try {
                calculator.add(Integer.parseInt(add));
            }
            catch (NumberFormatException e) {
                return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
            }
        }

        if (subtract != null) {
            try {
                calculator.subtract(Integer.parseInt(subtract));
            }
            catch (NumberFormatException e) {
                return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
            }
        }

        if (multiply != null) {
            try {
                calculator.multiply(Integer.parseInt(multiply));
            }
            catch (NumberFormatException e) {
                return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
            }
        }

        if (divide != null) {
            try {
                calculator.divide(Integer.parseInt(divide));
            }
            catch (NumberFormatException e) {
                return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
            }
        }

        return new ResponseEntity<>(calculator, HttpStatus.OK);
    }

    @PostMapping
    public void setValue(@RequestBody Calculator calculator) {
        this.calculator = calculator;
    }
}
