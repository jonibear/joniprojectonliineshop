package com.company.controller;

import com.company.model.Repository.IBuyRepository;

public class BuyController {
    private final IBuyRepository repo;

    public BuyController(IBuyRepository repo) {
        this.repo = repo;
    }

    public boolean buyProduct(int id) {
        return repo.buyProduct(id);
    }
}
