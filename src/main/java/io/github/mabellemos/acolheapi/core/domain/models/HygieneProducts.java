package io.github.mabellemos.acolheapi.core.domain.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class HygieneProducts extends Donations implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String description;

    public HygieneProducts(){

    }

    public HygieneProducts(int id, int amount, Date date) {
        super(id, amount, date);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description){ this.description = description; }

    @Override
    public String toString() {
        return "HygieneProducts{" +
                ", description='" + description + '\'' +
                '}';
    }
}
