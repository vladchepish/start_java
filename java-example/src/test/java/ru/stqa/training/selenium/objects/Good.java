package ru.stqa.training.selenium.objects;

import java.util.Objects;

public class Good {

    String name;
    String regularPrice;
    String comparingPrice;

    public String getName() {
        return name;
    }

    public Good setName(String name) {
        this.name = name;
        return this;
    }

    public String getRegularPrice() {
        return regularPrice;
    }

    public Good setRegularPrice(String regularPrice) {
        this.regularPrice = regularPrice;
        return this;
    }

    public String getComparingPrice() {
        return comparingPrice;
    }

    public Good setComparingPrice(String comparingPrice) {
        this.comparingPrice = comparingPrice;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return Objects.equals(name, good.name) &&
                Objects.equals(regularPrice, good.regularPrice) &&
                Objects.equals(comparingPrice, good.comparingPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, regularPrice, comparingPrice);
    }
}
