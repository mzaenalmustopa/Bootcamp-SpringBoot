package mzaaenalmustopa.springwebmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

    @GetMapping(path = "orders/{orderId}/products/{productsId}")
    @ResponseBody
    public String order(@PathVariable("orderId") String orderId,@PathVariable("productsId") String productId){
        return "Order : " + orderId + ", Product : " + productId;
    }
}
