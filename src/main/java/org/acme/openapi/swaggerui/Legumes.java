package org.acme.openapi.swaggerui;

public class Legumes {

    public Integer id;
    public String name;
    public String description;
    public String quantity;

    public Legumes() {
    }

    public Legumes(Integer id,String name, String description, String quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }
}