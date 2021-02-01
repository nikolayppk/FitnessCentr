package ru.lushenko.fitnesscentr.domain;

import java.util.Objects;

public class Buy implements Identification {
    public Buy(String buyName, String buyId) {
        this.buyName = buyName;
        this.buyId = buyId;
    }

    private String buyId;
    private String buyName;

    @Override
    public String getId() { return this.buyId; }
    public String getBuyName() { return this.buyName; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Buy)) return false;
        Buy buy = (Buy) o;
        return buyId.equals(buy.buyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyId);
    }
}