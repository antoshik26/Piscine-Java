package edu.school21.chat.models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class Messages {
    private int Id;
    private User IdCreatMessages;
    private Room IdRoomMassages;
    private String TextMassages;
    private Timestamp DataMassages;

    public Messages(User CreatMassages, Room IdRoomMassages, String TextMassages){
        this.IdCreatMessages = CreatMassages;
        this.IdRoomMassages = IdRoomMassages;
        this.TextMassages = TextMassages;
        Date date = new Date();
        this.DataMassages = new Timestamp(date.getTime());
    }

    public Messages(int id, User CreatMassages, Room IdRoomMassages, String TextMassages, Timestamp date){
        this.Id = id;
        this.IdCreatMessages = CreatMassages;
        this.IdRoomMassages = IdRoomMassages;
        this.TextMassages = TextMassages;
        this.DataMassages = date;
    }

    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Messages massages = (Messages)obj;
        return Id == massages.Id && Objects.equals(IdCreatMessages, massages.IdCreatMessages) && Objects.equals(IdRoomMassages, massages.IdRoomMassages) && Objects.equals(TextMassages, massages.TextMassages) && Objects.equals(DataMassages, massages.DataMassages);
    }

    public int hashCode()
    {
        return Objects.hash(Id, IdCreatMessages, IdRoomMassages, TextMassages, DataMassages);
    }

    public String toString()
    {
        return ("Massage: TextMassages-" + this.TextMassages + " DataMassages-" + DataMassages.toString());
    }

    public int getId() {
        return Id;
    }

    public User getIdCreatMessages() {
        return IdCreatMessages;
    }

    public Room getIdRoomMassages() {
        return IdRoomMassages;
    }

    public String getTextMassages() {
        return TextMassages;
    }

    public Timestamp getDataMassages() {
        return DataMassages;
    }

    public void setId(int id) {
        Id = id;
    }
}
