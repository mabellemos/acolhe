package io.github.mabellemos.acolheapi.core.domain.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Donations implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int id;
    private int amount;
    private Date dateDonation;
    private String typeDonation;

    Scanner input = new Scanner(System.in);

    public Donations(){
    }

    public Donations(int id, int amount, Date date) {
        this.id = id;
        this.amount = amount;
        this.dateDonation = dateDonation;
        this.typeDonation = typeDonation;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return dateDonation;
    }

    public void setDate(Date dateDonation) {
        this.dateDonation = dateDonation;
    }

    public String getType() {
        return typeDonation;
    }

    public void setType(String typeDonation) {
        this.typeDonation = typeDonation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donations donations = (Donations) o;
        return id == donations.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Donations{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + dateDonation +
                ", type=" + typeDonation +
                '}';
    }

    public void alter(int id){
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
                    break;
                case 3:
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }
            System.out.println("\nDeseja alterar dados novamente? (Sim/Não)");
            esc = input.next();

        } while(esc.equalsIgnoreCase("sim"));
    }

}
