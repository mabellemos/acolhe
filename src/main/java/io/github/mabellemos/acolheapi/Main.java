package io.github.mabellemos.acolheapi;

import io.github.mabellemos.acolheapi.core.domain.Adresses;
import io.github.mabellemos.acolheapi.core.domain.Clothes;
import io.github.mabellemos.acolheapi.core.domain.Responsible;
import io.github.mabellemos.acolheapi.core.domain.Shelters;

import java.util.Scanner;
import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String opc;
        do {
            System.out.println("ACOLHE");
            System.out.println("1 - Doações\n2 - Centros de Distribuição");
            int esc = input.nextInt();

            switch (esc){
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println("Deseja realizar outra operação? (Sim/Não)");
            opc = input.next();

        } while (opc.equalsIgnoreCase("sim"));
    }
}