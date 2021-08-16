package com.company;

import com.company.model.Repository.*;
import com.company.model.database.IDB;
import com.company.model.database.PostgresDB;
import com.company.view.Application;

public class Main {

    public static void main(String[] args) {


        IDB db = new PostgresDB();
        IBuyRepository buyRepo = new BuyRepository(db);
        ISellRepository sellRepo = new SellRepository(db);
        ISearchRepository searchRepo = new SearchRepository(db);

        Application app = new Application(buyRepo, searchRepo, sellRepo);



        app.start();

    }
}
