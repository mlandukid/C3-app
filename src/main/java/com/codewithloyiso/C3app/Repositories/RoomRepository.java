package com.codewithloyiso.C3app.Repositories;

import com.codewithloyiso.C3app.Models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    Room findRoomByRoomName(String roomName);
}