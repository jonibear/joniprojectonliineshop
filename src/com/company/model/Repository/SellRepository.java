package com.company.model.Repository;

import com.company.controller.Product;
import com.company.model.database.IDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SellRepository implements ISellRepository{

    private final IDB db;

    public SellRepository(IDB db) {
        this.db = db;
    }

    @Override
    public void sellProduct(Product newProduct) {
        Connection con = null;
        ResultSet rs = null;

        ArrayList<Product> res = new ArrayList<>();

        try {
            con = db.getConnection();

            String sql = "insert into products values (default, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, newProduct.getName());
            st.setString(2, newProduct.getType());
            st.setInt(3, newProduct.getQuantity());

            st.execute();
        } catch (Exception e){
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println(e);
            }
        }

    }
}
