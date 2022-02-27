/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.agecalculator;

import java.time.LocalDate;
import java.time.Period;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Fanky
 */
@Controller
public class ProjectController {
    
    @RequestMapping("/check")
    @ResponseBody
    public String checkAge(HttpServletRequest params) {
        String birthDate = params.getParameter("Birth_Date");
        String calculateDate = params.getParameter("Calculate_Date");
//        LocalDate date = LocalDate.parse(birthDate);
//        LocalDate calDate = LocalDate.parse(calculateDate);
//        Period period = Period.between(date, calDate);
//        String result = period.getYears()+" tahun "+period.getMonths()+" bulan "+period.getDays()+" hari";
//        return result;
        return calculate(birthDate, calculateDate);
    }
    
    public String calculate(String birthDate, String calDate) {
        String[] birthSplit = birthDate.split("-");
        String[] calSplit = calDate.split("-");
        
        int birthYear = Integer.parseInt(birthSplit[0]);
        int birthMonth = Integer.parseInt(birthSplit[1]);
        int birthDay = Integer.parseInt(birthSplit[2]);
        int calYear = Integer.parseInt(calSplit[0]);
        int calMonth = Integer.parseInt(calSplit[1]);
        int calDay = Integer.parseInt(calSplit[2]);
        
        int month[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        
        if (birthDay > calDay) {
            calMonth = calMonth - 1;
            calDay = calDay + month[birthMonth - 1];
        }
        
        if (birthMonth > calMonth) {
            calYear = calYear - 1;
            calMonth = calMonth + 12;
        }
        
        int resultDay = calDay - birthDay;
        int resultMonth = calMonth - birthMonth;
        int resultYear = calYear - birthYear;
        return resultYear+" tahun "+resultMonth+" bulan "+resultDay+" hari";
    }
}
