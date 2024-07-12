package io.github.mabellemos.acolheapi.core.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class HygieneProducts extends Donations implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int code;

    public HygieneProducts(UUID id){
        super(id);
    }

    public HygieneProducts(UUID id, int amount, Date date, int code) {
        super(id, amount, date);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        HygieneProducts that = (HygieneProducts) o;
        return code == that.code;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), code);
    }

    @Override
    public String toString() {
        return "HygieneProducts{" +
                "code=" + code +
                '}';
    }
}
