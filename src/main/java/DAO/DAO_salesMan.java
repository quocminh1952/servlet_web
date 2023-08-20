package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import Database.JDBC_Util;
import model.salesMan;

public class DAO_salesMan implements DAO_Interface<salesMan> {
    private ArrayList<salesMan> data_salesMan = new ArrayList<salesMan>();

    public static DAO_salesMan getInstance() {
        return new DAO_salesMan();
    }

    @Override
    public ArrayList<salesMan> selectALL() {

        try {
            // step_1 : create connection:
            Connection connect = JDBC_Util.getConnection();

            // step_2: create SQL query:
            String sql_query = "SELECT * FROM salesMan ";

            PreparedStatement PS = connect.prepareStatement(sql_query);

            ResultSet result = PS.executeQuery();

            // get value by result
            while (result.next()) {
                String SL_Id = result.getString("SL_Id");
                String SL_Name = result.getString("SL_Name");
                Date SL_birthday = result.getDate("SL_birthday");
                String SL_story = result.getString("SL_story");

                salesMan printSalesMan = new salesMan();
                printSalesMan.setSL_Id(SL_Id);
                printSalesMan.setSL_Name(SL_Name);
                printSalesMan.setSL_birthday(SL_birthday);
                printSalesMan.setSL_story(SL_story);
                data_salesMan.add(printSalesMan);

                // Close connection, PreparedStatement, ResultSet;
                connect.close();
                PS.close();
                result.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data_salesMan;
    }

    @Override
    public salesMan selectById(String id) {
        salesMan resultSalesMan = new salesMan();
        try {
            Connection connect = JDBC_Util.getConnection();

            String sql = "SELECT * FROM salesMan WHERE SL_Id = ?";

            PreparedStatement pst = connect.prepareStatement(sql);
            pst.setString(1, id);

            ResultSet result = pst.executeQuery();

            while (result.next()) {
                String SL_Id = result.getString("SL_Id");
                String SL_Name = result.getString("SL_Name");
                Date SL_birthday = result.getDate("SL_birthday");
                String SL_story = result.getString("SL_story");

                resultSalesMan.setSL_Id(SL_Id);
                resultSalesMan.setSL_Name(SL_Name);
                resultSalesMan.setSL_birthday(SL_birthday);
                resultSalesMan.setSL_story(SL_story);

                connect.close();
                pst.close();
                result.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSalesMan;
    }

    @Override
    public boolean addItem(salesMan salesMan) {
        boolean result = false;
        try {
            Connection connect = JDBC_Util.getConnection();

            String sql = "INSERT INTO salesMan VALUE(?,?,?,?)";
            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setString(1, salesMan.getSL_Id());
            pst.setString(2, salesMan.getSL_Name());
            pst.setDate(3, new java.sql.Date(salesMan.getSL_birthday().getTime()));
            pst.setString(4, salesMan.getSL_story());

            if (pst.executeUpdate() != 0) {
                result = true;
            } else {
                result = false;
            }

            connect.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean deleteItem(salesMan salesMan) {
        boolean result = false;
        try {
            Connection connect = JDBC_Util.getConnection();

            String sql = "DELETE FROM salesMan WHERE SL_Id = ?";

            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setString(1, salesMan.getSL_Id());

            if (pst.executeUpdate() != 0) {
                result = true;
            } else {
                result = false;
            }

            connect.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean updateItem(salesMan salesMan) {
        boolean result = false;
        try {
            Connection connect = JDBC_Util.getConnection();

            StringBuilder updateSQL = new StringBuilder("UPDATE salesMan SET ");

            // duyệt các trường hợp các trường dữ liệu muốn giữ nguyên => giá trị update == NULL
            boolean hasUpdate = false;

            if (salesMan.getSL_Name() != null) {
                updateSQL.append(" SL_Name = ?, ");
                hasUpdate = true;
            }

            if (salesMan.getSL_birthday() != null) {
                updateSQL.append(" SL_birthday = ?, ");
                hasUpdate = true;
            }

            if (salesMan.getSL_story() != null) {
                updateSQL.append(" SL_story = ?, ");
                hasUpdate = true;
            }

            if (hasUpdate) {
                updateSQL.setLength(updateSQL.length() - 2);
            }

            updateSQL.append(" WHERE SL_Id = ?");

            PreparedStatement pst = connect.prepareStatement(updateSQL.toString());

            int parameterIndex = 0;

            if (salesMan.getSL_Name() != null) {
                parameterIndex++;
                pst.setString(parameterIndex, salesMan.getSL_Name());
            }

            if (salesMan.getSL_birthday() != null) {
                parameterIndex++;
                pst.setDate(parameterIndex, new java.sql.Date(salesMan.getSL_birthday().getTime()));
            }

            if (salesMan.getSL_story() != null) {
                parameterIndex++;
                pst.setString(parameterIndex, salesMan.getSL_story());
            }

            parameterIndex++;
            pst.setString(parameterIndex, salesMan.getSL_Id());

            if (pst.executeUpdate() > 0) {
                result = true;
            } else {
                result = false;
            }

            connect.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
