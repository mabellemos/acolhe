package io.github.mabellemos.acolheapi.core.interfaces.repositories;

import io.github.mabellemos.acolheapi.core.domain.models.DistribuitionCenters;
import io.github.mabellemos.acolheapi.core.domain.models.Donations;

import java.sql.SQLException;
import java.util.List;

public interface DonationsRepository {
    void registration(int centerId) throws SQLException;
    List<Donations> display() throws SQLException;
    void alter() throws SQLException;
    void delete(int donationId, int distributionCenterId) throws SQLException;
}
