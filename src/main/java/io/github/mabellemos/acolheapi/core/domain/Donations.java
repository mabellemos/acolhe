package io.github.mabellemos.acolheapi.core.domain;

import java.io.Serial;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public class Donations implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;
    private int amount;
    private Date date;

    Scanner input = new Scanner(System.in);

    public Donations(UUID id){
        this.id = id;
        attributeInitialization(id);

    }
    public Donations(UUID id, int amount, Date date) {
        this.id = id;
        this.amount = amount;
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donations donations = (Donations) o;
        return amount == donations.amount && Objects.equals(id, donations.id) && Objects.equals(date, donations.date) && Objects.equals(input, donations.input);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, date, input);
    }

    @Override
    public String toString() {
        return "Donations{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                ", input=" + input +
                '}';
    }

    public void attributeInitialization (UUID id){
        System.out.println("\nDoações\n");

        System.out.println("Informe a quantidade de doações: ");
        amount = input.nextInt();
        System.out.println("Informe a data: ");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = sdf.parse(input.next());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void alter(UUID id){
        String esc;
        int opc;

        do {
            System.out.println("\nAlteração de dados de doações\n");
            System.out.println("Informe qual campo será alterado:\n");
            System.out.println("1 - Quantidade\n2 - Data\n3 - Alterar todos os dados\n");

            opc = input.nextInt();

            switch (opc){
                case 1:
                    System.out.println("Informe a nova quantidade: ");
                    int newAmount = input.nextInt();

                    setAmount(newAmount);
                    break;
                case 2:
                    System.out.println("Informe a nova data: ");
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date newDate = null;

                    try {
                        newDate = sdf.parse(input.next());
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }

                    setDate(newDate);
                    break;
                case 3:
                    attributeInitialization(id);
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }
            System.out.println("\nDeseja alterar dados novamente? (Sim/Não)");
            esc = input.next();

        } while(esc.equalsIgnoreCase("sim"));
    }

}
