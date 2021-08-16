package com.company.model.Repository;

import com.company.controller.Product;

import java.util.ArrayList;

public interface ISearchRepository {
    ArrayList<Product> getAllProducts();
    ArrayList<Product> getProductsType(String type);

}
