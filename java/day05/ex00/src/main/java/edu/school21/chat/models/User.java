package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private Integer ID;
    private String Login;
    private String Password;
    private List<Room> _ListRooms;
    private List<Room> _ListRooms2;

    User(String login, String password){
        Login = login;
        Password = password;
        _ListRooms = new ArrayList<>();
        _ListRooms2 = new ArrayList<>();
    }

    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User)obj;
        return ID == user.ID && Objects.equals(Login, user.Login) && Objects.equals(Password, user.Password);
    }

    public int hashCode()
    {
        return Objects.hash(ID, Login, Password);
    }

    public String toString()
    {
        return ("User: login-" + this.Login + " password-" + this.Password);
    }
}
