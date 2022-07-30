package school21.spring.service.models;

import java.util.Objects;

public class User {
    private Long id;
    private String email;

    public User(){}

    public User(Long id, String email){
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public int hashCode()
    {
        return Objects.hash(id, email);
    }

    public String toString()
    {
        return ("Massage: TextMassages-" + this.id + " DataMassages-" + this.email);
    }

}
