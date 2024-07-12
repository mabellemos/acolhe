package io.github.mabellemos.acolheapi.core.domain;

import java.io.Serial;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public class Clothes extends Donations implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int code;
    private String size;
    private String type;

    Scanner input = new Scanner(System.in);

    public Clothes(UUID id) {
        super(id);
        attributeInitialization(id);
    }

    public Clothes(UUID id, int amount, Date date, int code, String size, String type) {
        super(id, amount, date);
        this.code = code;
        this.size = size;
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Clothes clothes = (Clothes) o;
        return code == clothes.code && Objects.equals(size, clothes.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), code, size, type);
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "code=" + code +
                ", size='" + size + '\'' +
                ", type=" + type + '\'' +
                '}';
    }

    public void attributeInitialization (UUID id){
        System.out.println("\nRoupas\n");

        System.out.println("Informe o tipo (infantil/adulto): ");
        type = input.next();

        System.out.println("Informe o tamanho (PP/P/M/G/GG): ");
        size = input.next();
    }

}
