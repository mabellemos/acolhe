package io.github.mabellemos.acolheapi.core.domain.models;

import java.io.Serial;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class Foods extends Donations implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String description;
    private String type;
    private Date validity;
    private String measure;

    Scanner input = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);

    public Foods() {
    }

    public Foods(int id, int amount, Date date, String type, Date validity, String measure) {
        super(id, amount, date);
        this.type = type;
        this.validity = validity;
        this.measure = measure;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    @Override
    public String toString() {
        return "Foods{" +
                "measure='" + measure + '\'' +
                ", validity=" + validity +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public void attributeInitialization (UUID id){
        System.out.println("\nAlimentos\n");

        System.out.println("Informe o tipo de alimento (Perecível/Não perecível): ");
        type = inputString.nextLine();

        System.out.println("Informe a data de validade: ");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            validity = sdf.parse(input.next());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Informe a unidade de medida (mm/mg/g/kg): ");
        measure = input.next();

        System.out.println("Informe uma descrição: ");
        description = inputString.nextLine();
    }
}
