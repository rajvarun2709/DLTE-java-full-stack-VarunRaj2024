package com.example.tasktwo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/loans")
public class LoanController {
    private List<Loan> myLoans = Stream.of(
            new Loan(12341324L, 13244.0, "13/02/2024", "personal Loan", "vijay", 12341324L),
            new Loan(12351324L, 1324324.0, "15/03/2024", "home loan", "savith", 12341324L),
            new Loan(1841324L, 132432524.0, "17/04/2024", "personal loan", "vimal", 12432324L),
            new Loan(14571324L, 13233334.0, "11/05/2024", "home loan", "kiran", 121341324L)
    ).collect(Collectors.toList());
    @GetMapping("/{index}")
    public Loan readAllLoans(@PathVariable int index){
        if (index>=0 && index < myLoans.size())
            return myLoans.get(index);
        else
            throw new IndexOutOfBoundsException("Loan not found");
    }
    @PostMapping("/")
    public String createLoan(@RequestBody Loan loan){
        myLoans.add(loan);

        return ("Loan added successfully"+myLoans);
    }

}