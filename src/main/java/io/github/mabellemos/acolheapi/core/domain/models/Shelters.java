package io.github.mabellemos.acolheapi.core.domain.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class Shelters implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private Adresses adress;
    private Responsible responsible;
    private String telephone;
    private String email;
    private Double occupation;
    private Double capacity;
    private int limitItems;

    Scanner input = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);

    public Shelters (int id){
    }

    public Shelters(int id, String name, Adresses adress, Responsible responsible, String telephone, String email, Double occupation, Double capacity, int limitItems) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.responsible = responsible;
        this.telephone = telephone;
        this.email = email;
        this.occupation = occupation;
        this.capacity = capacity;
        this.limitItems = limitItems;
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

    public Adresses getAdress() {
        return adress;
    }

    public void setAdress(Adresses adress) {
        this.adress = adress;
    }

    public Responsible getResponsible() {
        return responsible;
    }

    public void setResponsible(Responsible responsible) {
        this.responsible = responsible;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String tefephone) {
        this.telephone = tefephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getOccupation() {
        return occupation;
    }

    public Double getCapacity() {
        return capacity;
    }

    public int getLimitItems() {
        return limitItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shelters shelters = (Shelters) o;
        return id == shelters.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Shelters{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress=" + adress +
                ", responsible=" + responsible +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", occupation=" + occupation +
                ", capacity=" + capacity +
                ", limitItems=" + limitItems +
                '}';
    }

    public void attributeInitialization (int id){
        System.out.println("\nAbrigo\n");

        System.out.println("Informe o nome do abrigo: ");
        name = inputString.nextLine();
        adress = new Adresses();
        responsible = new Responsible();
        System.out.println("Informe o telefone do abrigo: ");
        telephone = input.next();
        System.out.println("Informe o e-mail para contato: ");
        email = input.next();
        System.out.println("Informe a ocupação do abrigo: ");
        occupation = input.nextDouble();
    }

    public void alter(int id){
        String esc;
        int opc;

        do {
            System.out.println("\nAlteração de dados do Abrigo\n");
            System.out.println("Informe qual campo será alterado:\n");
            System.out.println("1 - Nome\n2 - Endereço\n3 - Responsável\n4 - Telefone\n5 - E-mail\n6 - Alterar todos os dados\n");

            opc = input.nextInt();

            switch (opc){
                case 1:
                    System.out.println("Informe o novo nome: ");
                    String newName = inputString.nextLine();

                    setName(newName);
                    break;
                case 2:
                    System.out.println("Informe o novo endereço do abrigo: ");
                    Adresses newAdress = new Adresses();

                    setAdress(newAdress);
                    break;
                case 3:
                    System.out.println("Informe o novo responsável pelo abrigo: ");
                    Responsible newResponsible = new Responsible();

                    setResponsible(newResponsible);
                    break;
                case 4:
                    System.out.println("Informe o novo telefone: ");
                    String newTelephone = input.next();

                    setTelephone(newTelephone);
                    break;
                case 5:
                    System.out.println("Informe o novo e-mail: ");
                    String newEmail = input.next();

                    setEmail(newEmail);
                    break;
                case 6:
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
