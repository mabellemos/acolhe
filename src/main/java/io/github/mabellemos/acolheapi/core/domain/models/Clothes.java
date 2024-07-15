package io.github.mabellemos.acolheapi.core.domain.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class Clothes extends Donations implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String size;
    private String gender;
    private String type;
    private String description;

    Scanner input = new Scanner(System.in);

    public Clothes() {}

    public Clothes(int id, int amount, Date date, String size, String gender, String type, String description) {
        super(id, amount, date);
        this.size = size;
        this.gender = gender;
        this.type = type;
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", gender='" + gender + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    public void attributeInitialization (UUID id){
        System.out.println("\nRoupas\n");

        System.out.println("Informe o tipo (infantil/adulto): ");
        type = input.next();

        System.out.println("Informe o tamanho (PP/P/M/G/GG): ");
        size = input.next();

        System.out.println("Informe o gênero (M/F): ");
        gender = input.next();

        System.out.println("Informe uma descrição da roupa: ");
        description = input.next();
    }

}
