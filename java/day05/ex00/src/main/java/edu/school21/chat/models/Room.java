package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room {
    private Long Id;
    private String NameRoom;
    private List<Messages> IdMessage;
    private User UserRoom;

    Room(User userRoom, String NameRoom){
        this.UserRoom = userRoom;
        IdMessage = new ArrayList<>();
        this.NameRoom = NameRoom;
    }
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Room room = (Room)obj;
        return Id == room.Id && Objects.equals(NameRoom, room.NameRoom) && Objects.equals(IdMessage, room.IdMessage) && Objects.equals(UserRoom, room.UserRoom);
    }

    public int hashCode()
    {
        return Objects.hash(Id, NameRoom, IdMessage, UserRoom);
    }

    public String toString()
    {
        return ("Room: NameRoom-" + this.NameRoom);
    }

}
