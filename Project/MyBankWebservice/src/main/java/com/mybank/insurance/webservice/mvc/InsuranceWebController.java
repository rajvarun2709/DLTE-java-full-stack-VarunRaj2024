package com.mybank.insurance.webservice.mvc;
import com.mybank.dao.insurance.entity.Customer;
import com.mybank.dao.insurance.remotes.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ui")
public class InsuranceWebController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/dash")
    public String dash(){
        return "dashboard";
    }
    @GetMapping("/")
    public String landing()
    {
        return "index";
    }
    @PostMapping("/")
    public String loginError(Model model) {
        model.addAttribute("error", true);
        return "index";
    }
    @GetMapping("/name")
    @ResponseBody
    public String customerName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        Customer customer = customerRepository.findByUserName(name);
        return customer.getCustomerName();
    }


    @GetMapping("/view")
    public String view(){
        return "viewInsurance";
    }

    @GetMapping("/error")
    public String errorPage() {
        return "error";
    }

}
