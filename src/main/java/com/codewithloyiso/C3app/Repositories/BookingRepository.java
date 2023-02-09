package com.codewithloyiso.C3app.Repositories;

import com.codewithloyiso.C3app.Models.Booking;
import com.codewithloyiso.C3app.Models.Room;
import com.codewithloyiso.C3app.Models.User;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findBookingByCheckInBetween(LocalDate checkIn , LocalDate checkOut);
    List<Booking> findAllByRoom(Room room);
    List<Booking> findBookingsByUser(User user);
}
