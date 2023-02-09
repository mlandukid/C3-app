package com.codewithloyiso.C3app.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithloyiso.C3app.Models.Room;
import com.codewithloyiso.C3app.Repositories.RoomRepository;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;


    
    public String createRoom(Room room){
        roomRepository.save(room);
        return  "Room adeded";
    }



}
