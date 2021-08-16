package com.company.view;

import com.company.controller.BuyController;
import com.company.controller.Product;
import com.company.controller.SearchController;
import com.company.controller.SellController;
import com.company.model.Repository.IBuyRepository;
import com.company.model.Repository.ISearchRepository;
import com.company.model.Repository.ISellRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    private final BuyController buyController;
    private final SearchController searchController;
    private final SellController sellController;

    public Application(IBuyRepository buyRepo, ISearchRepository searchRepo, ISellRepository sellRepo) {
        buyController = new BuyController(buyRepo);
        searchController = new SearchController(searchRepo);
        sellController = new SellController(sellRepo);
    }

    public void start(){
        System.out.println("Hello, Welcome to JoniShop");

        Scanner in = new Scanner(System.in);

        int choice;

        while(true){
            System.out.println("1: Show products");
            System.out.println("2: Buy");
            System.out.println("3: Sell");
            System.out.println("#: exit");

            choice = in.nextInt();

            if(choice == 1){
                System.out.println("1: Show all products");
                System.out.println("2: Show by group (Electronics, Clothes, Sport, Beauty)");

                choice = in.nextInt();

                if(choice == 1){
                    showAll();
                } else if(choice == 2){
                    System.out.println("Enter type: ");
                    String type = in.next();
                    showByType(type);
                }
            } else if(choice == 2){
                System.out.println("Input id: ");
                int id = in.nextInt();

                Buy(id);


            } else if(choice == 3){
                System.out.println("Input name of your product:");
                String name = in.next();
                System.out.println("Input type of your product:");
                String type = in.next();
                System.out.println("input quantity of your product");
                int quantity = in.nextInt();

                Product product = new Product(name, type, quantity);

                Sell(product);


            } else {
                System.out.println("Thanks for visiting JoniShop. See you soon :)");
                System.exit(0);
            }
        }

    }

    void showAll(){
        ArrayList <Product> ans = searchController.getAllProducts();

        for(Product to : ans){
            System.out.println(to.toString());
        }
    }

    void showByType(String type){
        ArrayList < Product > ans = searchController.getProductsType(type);
        for(Product to : ans){
            System.out.println(to.toString());
        }
    }

    void Buy(int id){
        if(buyController.buyProduct(id)){
            System.out.println("Congratulations!!!");
        } else {
            System.out.println("Sorry item out of stock :/");
        }
    }

    void Sell(Product product){
        sellController.sellProduct(product);
        System.out.println("Congratulations, we added your item to our marketplace");
    }

}

