package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.object.Product;

public class Smartphone extends Product {

    private String producer;

    public Smartphone(int id, String name, int price, String producer) {
        super(id, name, price);
        this.producer = producer;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        } else return getProducer().contains(search);
    }

    public String getProducer() {
        return producer;
    }
}
