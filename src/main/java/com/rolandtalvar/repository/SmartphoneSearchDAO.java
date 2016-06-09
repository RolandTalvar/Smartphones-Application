package com.rolandtalvar.repository;

import com.rolandtalvar.model.Smartphone;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rolandtalvar on 06/06/16.
 */
@Repository
public class SmartphoneSearchDAO {

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/smartphones";

    static final String USER = "smartphonemanager";
    static final String PASS = "smartphonepassword";

    List<Smartphone> smartphoneList;

    public List<Smartphone> searchByModel(String manufacturer, String model, Integer price, String description) {
        smartphoneList = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            statement = connection.createStatement();
            String sql;

            sql = "SELECT * FROM smartphone WHERE ";

            if (manufacturer != null) {
                sql = sql.concat(" UPPER(manufacturer) LIKE UPPER('" + manufacturer + "%') AND ");
            }
            if (model != null) {
                sql = sql.concat(" UPPER(model) LIKE UPPER('" + model + "%') AND ");
            }
            if (price != null) {
                sql = sql.concat("price=" + price + " AND ");
            }
            if (description != null) {
                sql = sql.concat(" UPPER(description) LIKE UPPER('" + description + "%') AND ");
            }

            if (sql.endsWith("AND ")) {
                sql = sql.substring(0, sql.length() - 4);
            }

            sql = sql.concat(";");


            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()){
                Smartphone smartphone = new Smartphone();
                smartphone.setId(rs.getLong("id"));
                smartphone.setManufacturer(rs.getString("manufacturer"));
                smartphone.setModel(rs.getString("model"));
                smartphone.setPrice(rs.getInt("price"));
                smartphone.setDescription(rs.getString("description"));

                smartphoneList.add(smartphone);

            }

            rs.close();
            statement.close();
            connection.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return smartphoneList;
    }

}
