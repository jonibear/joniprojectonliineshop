package com.company.controller;

import com.company.model.Repository.ISellRepository;

public class SellController {

    private final ISellRepository repo;

    public SellController(ISellRepository repo) {
        this.repo = repo;
    }

    public void sellProduct(Product newProduct){
        repo.sellProduct(newProduct);
    }
}
