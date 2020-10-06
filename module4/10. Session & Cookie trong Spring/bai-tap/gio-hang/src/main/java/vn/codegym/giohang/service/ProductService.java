package vn.codegym.giohang.service;

import vn.codegym.giohang.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Long id);

    void save(Product product);
}
