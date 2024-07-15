package io.github.mabellemos.acolheapi.core.domain.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public class Responsible implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String telephone;

    Scanner input = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);

    public Responsible(){
    }

    public Responsible(int id, String name, String telephone) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Responsible that = (Responsible) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Responsible{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

    public void alter(UUID id){
        String esc;
        int opc;

        do {
            System.out.println("\nAlteração de responsável\n");
            System.out.println("Informe qual campo do responsável será alterado:\n");
            System.out.println("1 - Nome\n2 - Telefone\n3 - Alterar todos os dados de responsável\n");

            opc = input.nextInt();

            switch (opc){
                case 1:
                    System.out.println("Informe o novo nome: ");
                    String newName = inputString.nextLine();

                    setName(newName);
                    break;
                case 2:
                    System.out.println("Informe o novo telefone: ");
                    String newTelephone = input.next();

                    setTelephone(newTelephone);
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

