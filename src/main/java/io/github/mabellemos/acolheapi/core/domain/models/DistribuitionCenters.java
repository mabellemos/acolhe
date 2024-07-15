package io.github.mabellemos.acolheapi.core.domain.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class DistribuitionCenters implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int id;
    private ArrayList<Donations> donations;
    private int limitItems;
    private Requests requestsList;

    public DistribuitionCenters(){
    }

    public DistribuitionCenters(int id, Donations donations, int limitItems, Requests requestsList) {
        this.id = id;
        this.donations = new ArrayList<>();
        this.limitItems = limitItems;
        this.requestsList = requestsList;
    }

    public int getId() {
        return id;
    }

    public int getLimitItems() {
        return limitItems;
    }

    public void setLimitItems(int limitItems) {
        this.limitItems = limitItems;
    }

    public Requests getRequestsList() {
        return requestsList;
    }

    public void setRequestsList(Requests requestsList) {
        this.requestsList = requestsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistribuitionCenters that = (DistribuitionCenters) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "DistribuitionCenters{" +
                "id=" + id +
                ", limitItems=" + limitItems +
                ", requestsList=" + requestsList +
                '}';
    }
}
