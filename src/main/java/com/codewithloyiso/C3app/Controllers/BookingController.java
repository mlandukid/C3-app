package com.codewithloyiso.C3app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codewithloyiso.C3app.Dto.BookingDto;
import com.codewithloyiso.C3app.Dto.UserLoginDto;
import com.codewithloyiso.C3app.Models.Booking;
import com.codewithloyiso.C3app.Models.Room;

@RestController
@RequestMapping("/api/v1")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @PostMapping("/availableRooms")
    public List<Room> availableRooms(@RequestBody BookingDto bookingDto) throws Exception{
        System.out.println(bookingDto);
        List<Room> available = bookingService.findAllAvailableRooms(bookingDto.getCheckIn(),bookingDto.getCheckOut());
        return available;
    }

    @PostMapping("/showAllUserBookings")
    public List<Booking> showAllUserBookings(@RequestBody UserLoginDto userLoginDto){
        return bookingService.findBookingsByEmail(userLoginDto.getEmail());
    }

    @PostMapping("/book/{roomId}/{userId}")
    public ResponseEntity<String> saveBooking(@RequestBody Booking booking, @PathVariable Integer roomId, @PathVariable Integer userId) {
        System.out.println(userId);
        return ResponseEntity.ok(bookingService.createBooking(booking, roomId,userId).toString());
    }

    @GetMapping("/booking/cancel/{id}")
    public void cancelBooking (@PathVariable Integer id){
       bookingService.cancelBooking(id);
    }


    @GetMapping("/bookings")
    public List<Booking> showAllBookings(){
        return bookingService.getALlBookings();
    }

    @PostMapping("/reschedule/{id}")
    public Boolean rescheduleBooking(@PathVariable("id") Integer id, @RequestBody BookingDto bookingDto){
        return bookingService.rescheduleBooking(id, bookingDto).isPresent();

    }

    @GetMapping("/checkBooking/{roomName}")
    public List<Booking> checkBooking(@PathVariable String roomName) {
//        try {
//            var validationFlag = bookingService.validateBooking(booking.getCheckIn(), booking.getCheckOut(),roomName);
//            return ResponseEntity.ok(validationFlag.toString());
//        } catch (Exception e) {
//            return ResponseEntity.ok("Failed");
//        }

        return bookingService.getAllBookingsByRoomName(roomName);
    }

    @PostMapping("/validateBooking")
    public String validateBooking(@RequestBody BookingDto bookingDto){
    try{
        return bookingService.validateBooking(bookingDto.getCheckIn(),bookingDto.getCheckOut(), bookingDto.getRoomName()).toString();
    }
    catch (Exception e){
        return e.toString();

    }
    }
}
