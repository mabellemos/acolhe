package io.github.mabellemos.acolheapi.app;

import io.github.mabellemos.acolheapi.core.interfaces.repositories.Manageable;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class Adm {

    public void menu(Manageable obj) throws SQLException {
        String resp;
        int opc;

        Scanner input = new Scanner(System.in);

        do {
            System.out.println("1 - Cadastrar\n2 - Visualizar dados\n3 - Alterar dados\n4 - Deletar\n");
            opc = input.nextInt();

            switch (opc) {
                case 1:
                    obj.registration();
                    break;
                case 2:
                    obj.display();
                    break;
                case 3:
                    obj.alter();
                    break;
                case 4:
                    obj.delete();
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }

            System.out.println("Deseja realizar outra operação? (Sim/Não)");
            resp = input.next();

        } while (resp.equalsIgnoreCase("sim"));
    }
}
