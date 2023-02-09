package com.codewithloyiso.C3app.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithloyiso.C3app.Repositories.BookingRepository;

@RestController
@RequestMapping("api/v1/refund/{id}")
public class RefundController {
    
    @Autowired
    refundService refundService;
    @Autowired
    BookingRepository bookingRepository;

    @GetMapping
    public Refund makeRefund(@PathVariable("id") Integer id){
        
        return refundService.fileRefund(id);

    }
}
