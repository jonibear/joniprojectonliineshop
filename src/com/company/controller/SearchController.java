package com.company.controller;

import com.company.model.Repository.ISearchRepository;

import java.util.ArrayList;

public class SearchController {

    private final ISearchRepository repo;

    public SearchController(ISearchRepository repo) {
        this.repo = repo;
    }

    public ArrayList< Product > getAllProducts(){
        ArrayList < Product > ans = repo.getAllProducts();
        return ans;
    }

    public ArrayList < Product > getProductsType(String type){
        ArrayList < Product > ans = repo.getProductsType(type);
        return ans;
    }
}
