package io.github.mabellemos.acolheapi.core.services;

import io.github.mabellemos.acolheapi.core.domain.models.Clothes;
import io.github.mabellemos.acolheapi.core.domain.models.DistribuitionCenters;
import io.github.mabellemos.acolheapi.infra.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DistribuitionCentersService {

    private Scanner input = new Scanner(System.in);

        /*public int countItems(int centerId) throws SQLException {
            try (Connection conn = DatabaseConnection.getConnection()) {
                String query = "SELECT COUNT(*) FROM Donations WHERE distribuitionCenterId = ?";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setInt(1, centerId);
                    try (ResultSet rs = stmt.executeQuery()) {
                        if (rs.next()) {
                            return rs.getInt(1);
                        }
                    }
                }
            }
            return 0;
        }*/
}
