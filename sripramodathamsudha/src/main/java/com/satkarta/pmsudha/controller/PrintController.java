package com.satkarta.pmsudha.controller;

import org.springframework.stereotype.Controller;

@Controller
public class PrintController {
    public static void print(String input){
        System.out.println(input);
    }
}