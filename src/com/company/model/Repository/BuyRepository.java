package com.company.model.Repository;

import com.company.controller.Product;
import com.company.model.database.IDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BuyRepository implements IBuyRepository{
    private final IDB db;

    public BuyRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean buyProduct(int searchId) {
        Connection con = null;
        ResultSet rs = null;

        ArrayList<Product> res = new ArrayList<>();
        try {
            con = db.getConnection();

            String getCountQuery = "select quantity from products where id=?";
            PreparedStatement st = con.prepareStatement(getCountQuery);

            st.setInt(1, searchId);

            rs = st.executeQuery();

            int cnt = 0;

            while(rs.next()){
                cnt = rs.getInt(1);
            }
            if(cnt == 0){
                return false;
            }

            String reduceCountStatement = "update products set quantity = ? where id=?";

            PreparedStatement st1 = con.prepareStatement(reduceCountStatement);
            st1.setInt(1, cnt - 1);
            st1.setInt(2, searchId);

            st1.execute();

        } catch (Exception e){
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println(e);
            }
        }
        return true;
    }
}
