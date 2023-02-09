package com.codewithloyiso.C3app.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithloyiso.C3app.Models.Refund;
import com.codewithloyiso.C3app.Repositories.BookingRepository;
import com.codewithloyiso.C3app.Repositories.RefundRepository;

@Service
public class RefundService {

    @Autowired
    RefundRepository refundRepository;

    @Autowired
    BookingRepository bookingRepository;

    public Refund fileRefund(Integer id){

        Optional<Booking> booking= bookingRepository.findById(id);
        Refund refund = new Refund();
        return booking.map(
                booking1 -> {
                    refund.setBooking(booking1);
                    refund.setAmount((int) (booking1.getAmount()*0.2));
                    return refundRepository.save(refund);
                }
        ).orElseThrow(()->new RuntimeException());
    }
}
