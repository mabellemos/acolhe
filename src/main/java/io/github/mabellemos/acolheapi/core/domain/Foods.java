package io.github.mabellemos.acolheapi.core.domain;

import java.io.Serial;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public class Foods extends Donations implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int code;
    private String type;
    private Date validity;
    private String measure;

    Scanner input = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);

    public Foods(UUID id) {
        super(id);
        attributeInitialization(id);
    }

    public Foods(UUID id, int amount, Date date, int code, String type, Date validity, String measure) {
        super(id, amount, date);
        this.code = code;
        this.type = type;
        this.validity = validity;
        this.measure = measure;
    }

    public int getCode() {
        return code;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Foods foods = (Foods) o;
        return code == foods.code && Objects.equals(type, foods.type) && Objects.equals(validity, foods.validity) && Objects.equals(measure, foods.measure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), code, type, validity, measure);
    }

    @Override
    public String toString() {
        return "Foods{" +
                "code=" + code +
                ", type='" + type + '\'' +
                ", validity=" + validity +
                ", measure='" + measure + '\'' +
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
    }
}
