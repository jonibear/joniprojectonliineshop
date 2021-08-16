package com.company.model.Repository;

import com.company.controller.Product;
import com.company.model.database.IDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SearchRepository implements ISearchRepository{
    private final IDB db;

    public SearchRepository(IDB db) {
        this.db = db;
    }

    @Override
    public ArrayList<Product> getAllProducts() {


        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        ArrayList < Product > res = new ArrayList<>();

        try {

            con = db.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from products");


            while(rs.next()){
                if(rs.getInt(4) != 0) {
                    res.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
                }
            }

            return res;


        } catch (Exception e){
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println(e);
            }
        }

        return null;
    }

    @Override
    public ArrayList<Product> getProductsType(String type) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        ArrayList < Product > res = new ArrayList<>();

        try {
            con = db.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from products");

            while(rs.next()){
                if(rs.getString(3).equals(type) && rs.getInt(4) != 0) {
                    res.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
                }
            }

            return res;


        } catch (Exception e){
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println(e);
            }
        }

        return null;
    }
}
