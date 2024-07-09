package io.github.mabellemos.acolheapi.core.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
import java.util.Scanner;

public class Adresses implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String cep;
    private String state;
    private String city;
    private String district;
    private String street;
    private String number;

    Scanner input = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);

    public Adresses(UUID id){
        this.id = id;
        attributeInitialization(id);
    }

    public Adresses(UUID id, String cep, String state, String city, String district, String street, String number){
        this.id = id;
        this.cep = cep;
        this.state = state;
        this.city = city;
        this.district = district;
        this.street = street;
        this.number = number;
    }

    public UUID getId(){
        return id;
    }

    public String getCep(){
        return cep;
    }

    public void setCep(String cep){
        this.cep = cep;
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getDistrict(){
        return district;
    }

    public void setDistrict(String district){
        this.district = district;
    }

    public String getStreet(){
        return street;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public String getNumber(){
        return number;
    }

    public void setNumber(String number){
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adresses adresses = (Adresses) o;
        return Objects.equals(id, adresses.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public void attributeInitialization (UUID id){
        System.out.println("\nNovo endereço\n");

        System.out.println("Informe o CEP: ");
        cep = input.next();
        System.out.println("Informe o estado: ");
        state = inputString.nextLine();
        System.out.println("Informe a cidade: ");
        city = inputString.nextLine();
        System.out.println("Informe o bairro: ");
        district = inputString.nextLine();
        System.out.println("Informe a rua: ");
        street = inputString.nextLine();
        System.out.println("Informe o número: ");
        number = input.next();
    }

    @Override
    public String toString() {
        return "Adresses{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public void alter(UUID id){
        String esc;
        int opc;

        do {
            System.out.println("\nAlteração de endereço\n");
            System.out.println("Informe qual campo do endereço será alterado:\n");
            System.out.println("1 - CEP\n2 - Estado\n3 - Cidade\n4 - Bairro\n5 - Rua\n6 - Número\n7 - Alterar endereço completo\n");
            opc = input.nextInt();
            switch (opc){
                case 1:
                    System.out.println("Informe o novo CEP: ");
                    String newCep = input.next();

                    setCep(newCep);
                    break;
                case 2:
                    System.out.println("Informe o novo estado: ");
                    String newState = input.next();

                    setCep(newState);
                    break;
                case 3:
                    System.out.println("Informe a nova cidade: ");
                    String newCity = input.next();

                    setCep(newCity);
                    break;
                case 4:
                    System.out.println("Informe o novo bairro: ");
                    String newDistrict = input.next();

                    setCep(newDistrict);
                    break;
                case 5:
                    System.out.println("Informe a nova rua: ");
                    String newStreet = input.next();

                    setCep(newStreet);
                    break;
                case 6:
                    System.out.println("Informe o novo número: ");
                    String newNumber = input.next();

                    setCep(newNumber);
                    break;
                case 7:
                    attributeInitialization(id);
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }
            System.out.println("\nDeseja alterar endereço novamente? (Sim/Não)");
            esc = input.next();
        } while(esc.equalsIgnoreCase("sim"));
    }
}