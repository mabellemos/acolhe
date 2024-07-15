package io.github.mabellemos.acolheapi.core.domain.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Requests implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int id;
    private Donations donationsList;
    private Date date;

    public Requests(int id, Donations donationsList, Date date) {
        this.id = id;
        this.donationsList = donationsList;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public Donations getDonationsList() {
        return donationsList;
    }

    public void setDonationsList(Donations donationsList) {
        this.donationsList = donationsList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Requests requests = (Requests) o;
        return Objects.equals(id, requests.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Requests{" +
                "id=" + id +
                ", donationsList=" + donationsList +
                ", date=" + date +
                '}';
    }
}
