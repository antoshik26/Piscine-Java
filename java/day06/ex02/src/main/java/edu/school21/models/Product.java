package edu.school21.models;

public class Product {
    private Long id;
    private String Name;
    private Long Pryce;

    public Product(Long id, String name, Long Pryce)
    {
        this.id = id;
        this.Name = name;
        this.Pryce = Pryce;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public Long getPryce() {
        return Pryce;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPryce(Long pryce) {
        Pryce = pryce;
    }
}
