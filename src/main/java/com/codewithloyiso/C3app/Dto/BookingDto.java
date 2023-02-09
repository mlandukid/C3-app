package com.codewithloyiso.C3app.Dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
    private LocalDate checkIn;
    private  LocalDate checkOut;
    private String email;
    private String roomName;
}
