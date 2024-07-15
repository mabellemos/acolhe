package io.github.mabellemos.acolheapi.infra.db;

import io.github.mabellemos.acolheapi.core.domain.models.DistribuitionCenters;
import io.github.mabellemos.acolheapi.core.domain.models.Donations;
import io.github.mabellemos.acolheapi.core.interfaces.repositories.DonationsRepository;
import io.github.mabellemos.acolheapi.core.services.DistribuitionCentersService;
import io.github.mabellemos.acolheapi.core.services.DonationService;
import io.github.mabellemos.acolheapi.infra.db.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DonationsDAO implements DonationsRepository {

    DonationService donationService = new DonationService();
    Scanner input = new Scanner(System.in);

    ArrayList<Donations> donations = new ArrayList<>();

    public void registration(int centerId) throws SQLException {

        /*DistribuitionCenters center = new DistribuitionCenters();
        DistribuitionCentersService distribuitionCentersService = new DistribuitionCentersService();

        int itemCount = distribuitionCentersService.countItems(center.getId());

        if (itemCount >= 1000) {
            throw new SQLException("Capacidade do centro de distribuição atingida.");
        }*/

        System.out.println("\nCadastro de doações\n\nO que deseja cadastrar no sistema?\n\n1 - Roupas\n2 - Produtos de Higiene\n3 - Alimentos\n");
        int opc = input.nextInt();

        switch (opc) {
            case 1:
                donationService.registerClothes();
                break;
            case 2:
                donationService.registerHygieneProducts();
                break;
            case 3:
                donationService.registerFoods();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public List<Donations> display() throws SQLException {
        List<Donations> donations = new ArrayList<>();

        System.out.println("\nListagem de doações\n1 - Listar todas as doações\n2 - Procurar por id\n3 - Procurar por tipo (Roupa/Produto de Higiene/Alimentos)\n");
        int opc = input.nextInt();

        try (Connection conn = DatabaseConnection.getConnection()) {
            if (opc == 1) {
                donations = donationService.listAllDonations(conn);
            } else if (opc == 2) {
                System.out.print("Digite o ID da doação: ");
                int id = input.nextInt();
                Donations donation = donationService.findDonationById(conn, id);
                if (donation != null) {
                    donations.add(donation);
                }
            } else if (opc == 3) {
                System.out.print("Digite o tipo de doação (Roupa/Produto de Higiene/Alimentos): ");
                String type = input.next();
                donations = donationService.listDonationsByType(conn, type);
            }
        }

        return donations;
    }

    public void alter() throws SQLException {

        Donations donation = new Donations();

        System.out.println("\nAlterar dados das doações\n");

        System.out.println("Informe o id do centro de distribuição: ");
        int codeDC = input.nextInt();

        System.out.println("Informe o id da doação: ");
        int donationId = input.nextInt();

        try (Connection conn = DatabaseConnection.getConnection()) {
            // Verificar se o centro de distribuição existe
            String checkDCQuery = "SELECT COUNT(*) FROM DistributionCenters WHERE id = ?";
            try (PreparedStatement checkDCStmt = conn.prepareStatement(checkDCQuery)) {
                checkDCStmt.setInt(1, codeDC);
                ResultSet rs = checkDCStmt.executeQuery();
                if (rs.next() && rs.getInt(1) == 0) {
                    System.out.println("Centro de distribuição não encontrado.");
                    return;
                }
            }

            // Verificar se a doação pertence ao centro de distribuição informado
            String checkDonationQuery = "SELECT COUNT(*) FROM Donations WHERE id = ? AND distribution_center_id = ?";
            try (PreparedStatement checkDonationStmt = conn.prepareStatement(checkDonationQuery)) {
                checkDonationStmt.setInt(1, donationId);
                checkDonationStmt.setInt(2, codeDC);
                ResultSet rs = checkDonationStmt.executeQuery();
                if (rs.next() && rs.getInt(1) == 0) {
                    System.out.println("Não há doação com esse id no centro de distribuição informado.");
                    return;
                }
            }

            // Atualizar os dados da doação
            String updateQuery = "UPDATE Donations SET amount = ?, date = ?, type = ? WHERE id = ? AND distribution_center_id = ?";
            try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                updateStmt.setDouble(1, donation.getAmount());
                updateStmt.setDate(2, Date.valueOf(String.valueOf(donation.getDate())));
                updateStmt.setString(3, donation.getType());
                updateStmt.setInt(4, donationId);
                updateStmt.setInt(5, codeDC);
                int rowsUpdated = updateStmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Doação atualizada com sucesso.");
                } else {
                    System.out.println("Falha na atualização da doação.");
                }
            }
        }
    }

    public void delete(int donationId, int distributionCenterId) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {

            String checkQuery = "SELECT distribution_center_id FROM Donations WHERE id = ?";

            try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
                checkStmt.setInt(1, donationId);
                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (rs.next()) {
                        int foundDistributionCenterId = rs.getInt("distribution_center_id");
                        if (foundDistributionCenterId == distributionCenterId) {

                            String deleteQuery = "DELETE FROM Donations WHERE id = ?";

                            try (PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery)) {
                                deleteStmt.setInt(1, donationId);
                                deleteStmt.executeUpdate();
                                System.out.println("Doação deletada com sucesso.");
                            }
                        } else {
                            System.out.println("Não há doação com aquele ID no centro de distribuição informado.");
                        }
                    } else {
                        System.out.println("Doação não encontrada.");
                    }
                }
            }
        }
    }

}
