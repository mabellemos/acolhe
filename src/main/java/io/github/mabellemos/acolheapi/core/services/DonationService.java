package io.github.mabellemos.acolheapi.core.services;

import io.github.mabellemos.acolheapi.core.domain.models.Clothes;
import io.github.mabellemos.acolheapi.core.domain.models.Donations;
import io.github.mabellemos.acolheapi.core.domain.models.Foods;
import io.github.mabellemos.acolheapi.core.domain.models.HygieneProducts;
import io.github.mabellemos.acolheapi.infra.db.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DonationService {

    private Scanner input = new Scanner(System.in);

    public void registerClothes() throws SQLException {

        System.out.println("Cadastro de Roupas");
        Clothes clothes = new Clothes();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Clothes (id, amount, date, size, gender, type, description) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, clothes.getAmount());
                stmt.setDate(2, Date.valueOf(String.valueOf(clothes.getDate())));
                stmt.setString(3, clothes.getSize());
                stmt.setString(4, clothes.getGender());
                stmt.setString(5, clothes.getType());
                stmt.setString(6, clothes.getDescription());

                stmt.executeUpdate();
            }
        }
    }

    public void registerHygieneProducts() throws SQLException {

        System.out.println("Cadastro de Produtos de Higiene");
        HygieneProducts hygieneProducts = new HygieneProducts();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO HygieneProducts (id, amount, date) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(2, hygieneProducts.getAmount());
                stmt.setDate(3, Date.valueOf(String.valueOf(hygieneProducts.getDate())));

                stmt.executeUpdate();
            }
        }
    }

    public void registerFoods() throws SQLException {

        System.out.println("Cadastro de Alimentos");
        Foods foods = new Foods();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Foods (id, amount, date, description, type, validity, measure) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(2, foods.getAmount());
                stmt.setDate(3, Date.valueOf(String.valueOf(foods.getDate())));
                stmt.setString(5, foods.getDescription());
                stmt.setString(6, foods.getType());
                stmt.setDate(7, Date.valueOf(String.valueOf(foods.getValidity())));
                stmt.setString(8, foods.getMeasure());

                stmt.executeUpdate();
            }
        }
    }

    public List<Donations> listAllDonations(Connection conn) throws SQLException {
        List<Donations> donations = new ArrayList<>();
        String query = "SELECT * FROM Donations";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Donations donation = createDonationFromResultSet(rs);
                donations.add(donation);
            }
        }
        return donations;
    }

    public Donations findDonationById(Connection conn, int id) throws SQLException {
        String query = "SELECT * FROM Donations WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return createDonationFromResultSet(rs);
                }
            }
        }
        return null;
    }

    public List<Donations> listDonationsByType(Connection conn, String type) throws SQLException {
        List<Donations> donations = new ArrayList<>();
        String query = "SELECT * FROM Donations WHERE type = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, type);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Donations donation = createDonationFromResultSet(rs);
                    donations.add(donation);
                }
            }
        }
        return donations;
    }

    public Donations createDonationFromResultSet(ResultSet rs) throws SQLException {
        Donations donation;

        String type = rs.getString("type");

        if (type.equals("clothes")) {
            donation = new Clothes();
        } else if (type.equals("hygieneProducts")) {
            donation = new HygieneProducts();
        } else if (type.equals("foods")) {
            donation = new Foods();
        } else {
            donation = new Donations();
        }

        donation.setAmount(rs.getInt("Quantidade"));
        donation.setDate(rs.getDate("Data da doação"));
        donation.setType(rs.getString("type"));

        return donation;
    }

}
