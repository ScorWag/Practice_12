package ru.netology.repository;

import ru.netology.object.Product;

public class ProductRepository {

    Product[] products = new Product[0];

    public void saveProduct(Product product) {
        int id = product.getId();
        Product result = findById(id);

        if (result != null) {
            throw new AlreadyExistsException("Element with id: " + id + " already exists");
        }
        Product[] tmp = new Product[products.length + 1];

        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        Product result = findById(id);
        if (result == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        Product[] tmp = new Product[products.length - 1];

        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }
}
