package io.github.mabellemos.acolheapi;

import io.github.mabellemos.acolheapi.app.Adm;
import io.github.mabellemos.acolheapi.core.domain.models.DistribuitionCenters;
import io.github.mabellemos.acolheapi.infra.db.DonationsDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        String resp;
        int opc;

        Scanner input = new Scanner(System.in);
        Adm adm = new Adm();

        do {

            System.out.println("\nACOLHE\n");
            System.out.println("1 - Doações");
            opc = input.nextInt();

            switch (opc){
                case 1:
                    System.out.println("\n---- Doações ----");
                    DonationsDAO donationDAO = new DonationsDAO();

                    String respD;
                    int opcD;

                    do {
                        System.out.println("1 - Cadastrar\n2 - Visualizar dados\n3 - Alterar dados\n4 - Deletar\n");
                        opcD = input.nextInt();

                        switch (opc) {
                            case 1:
                                System.out.println("Informe o id do centro de distribuição: ");
                                int centerIdReg = input.nextInt();

                                donationDAO.registration(centerIdReg);
                                break;
                            case 2:
                                donationDAO.display();
                                break;
                            case 3:
                                donationDAO.alter();
                                break;
                            case 4:
                                System.out.println("Informe o id do centro de distribuição: ");
                                int centerIdDelete = input.nextInt();

                                donationDAO.registration(centerIdDelete);

                                System.out.println("Informe o id da doação: ");
                                int donationIdDelete = input.nextInt();

                                donationDAO.delete(centerIdDelete, donationIdDelete);
                                break;
                            default:
                                System.out.println("\nOpção inválida!");
                        }

                        System.out.println("Deseja realizar outra operação? (Sim/Não)");
                        respD = input.next();

                    } while (respD.equalsIgnoreCase("sim"));

                    break;
                default:
                    System.out.println("\nOpção inválida!");
                    break;
            }

            System.out.println("Deseja realizar outra operação? (SIm/Não)");
            resp = input.next();

        } while (resp.equalsIgnoreCase("sim"));
      
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