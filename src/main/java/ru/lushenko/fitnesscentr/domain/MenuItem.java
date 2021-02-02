package ru.lushenko.fitnesscentr.domain;

import java.util.Objects;

public class MenuItem extends Menu{

    public MenuItem(String position, String name) {
        this.name = name;
        this.position = position;
    }

    private String name;
    private String position;

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuItem)) return false;
        MenuItem menuItem = (MenuItem) o;
        return getPosition().equals(menuItem.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition());
    }
}
