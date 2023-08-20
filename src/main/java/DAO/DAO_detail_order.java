package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import Database.JDBC_Util;
import model.client;
import model.order;

public class DAO_detail_order implements DAO_Interface<order> {
    private ArrayList<order> data_order = new ArrayList<order>();

    public static DAO_detail_order getInstance() {
        return new DAO_detail_order();
    }

    @Override
    public ArrayList<order> selectALL() {

        try {
            // Step 1: Create connection
            Connection connect = JDBC_Util.getConnection();

            // Step 2: Create SQL query
            String sql_query = "SELECT * FROM order_table ";

            PreparedStatement PS = connect.prepareStatement(sql_query);

            ResultSet result = PS.executeQuery();

            // Get value by result
            while (result.next()) {
                String order_Id = result.getString("order_Id");
                // Assuming there's a DAO_client class to fetch client data by client ID
                String client_Id = result.getString("order_Client_Id");
                client order_Client = DAO_client.getInstance().selectById(client_Id);
                String order_Client_Address = result.getString("order_Client_Address");
                String order_Status = result.getString("order_Status");
                String order_COD = result.getString("order_COD");
                Date order_Date = result.getDate("order_Date");
                Date order_Ship = result.getDate("order_Ship");

                order printOrder = new order();
                printOrder.setOrder_Id(order_Id);
                printOrder.setOrder_Client(order_Client);
                printOrder.setOrder_Client_Address(order_Client_Address);
                printOrder.setOrder_Status(order_Status);
                printOrder.setOrder_COD(order_COD);
                printOrder.setOrder_Date(order_Date);
                printOrder.setOrder_Ship(order_Ship);

                data_order.add(printOrder);

                // Close connection, PreparedStatement, ResultSet
                connect.close();
                PS.close();
                result.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data_order;
    }

    @Override
    public order selectById(String id) {
        order resultOrder = new order();
        try {
            Connection connect = JDBC_Util.getConnection();

            String sql = "SELECT * FROM order_table WHERE order_Id = ?";

            PreparedStatement pst = connect.prepareStatement(sql);
            pst.setString(1, id);

            ResultSet result = pst.executeQuery();

            while (result.next()) {
                String order_Id = result.getString("order_Id");
                String client_Id = result.getString("order_Client_Id");
                client order_Client = DAO_client.getInstance().selectById(client_Id);
                String order_Client_Address = result.getString("order_Client_Address");
                String order_Status = result.getString("order_Status");
                String order_COD = result.getString("order_COD");
                Date order_Date = result.getDate("order_Date");
                Date order_Ship = result.getDate("order_Ship");

                resultOrder.setOrder_Id(order_Id);
                resultOrder.setOrder_Client(order_Client);
                resultOrder.setOrder_Client_Address(order_Client_Address);
                resultOrder.setOrder_Status(order_Status);
                resultOrder.setOrder_COD(order_COD);
                resultOrder.setOrder_Date(order_Date);
                resultOrder.setOrder_Ship(order_Ship);

                connect.close();
                pst.close();
                result.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultOrder;
    }

    @Override
    public boolean addItem(order order) {
        boolean result = false;
        try {
            Connection connect = JDBC_Util.getConnection();

            String sql = "INSERT INTO order_table VALUE(?,?,?,?,?,?,?)";
            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setString(1, order.getOrder_Id());
            pst.setString(2, order.getOrder_Client().getClient_Id());
            pst.setString(3, order.getOrder_Client_Address());
            pst.setString(4, order.getOrder_Status());
            pst.setString(5, order.getOrder_COD());
            pst.setDate(6, new java.sql.Date(order.getOrder_Date().getTime()));
            pst.setDate(7, new java.sql.Date(order.getOrder_Ship().getTime()));

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
    public boolean deleteItem(order order) {
        boolean result = false;
        try {
            Connection connect = JDBC_Util.getConnection();

            String sql = "DELETE FROM order_table WHERE order_Id = ?";

            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setString(1, order.getOrder_Id());

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
    public boolean updateItem(order order) {
        boolean result = false;
        try {
            Connection connect = JDBC_Util.getConnection();

            StringBuilder updateSQL = new StringBuilder("UPDATE order_table SET ");

            // Duyệt các trường hợp các trường dữ liệu muốn giữ nguyên => giá trị update == NULL
            boolean hasUpdate = false;

            if (order.getOrder_Client_Address() != null) {
                updateSQL.append(" order_Client_Address = ?, ");
                hasUpdate = true;
            }

            if (order.getOrder_Status() != null) {
                updateSQL.append(" order_Status = ?, ");
                hasUpdate = true;
            }

            if (order.getOrder_COD() != null) {
                updateSQL.append(" order_COD = ?, ");
                hasUpdate = true;
            }

            if (order.getOrder_Date() != null) {
                updateSQL.append(" order_Date = ?, ");
                hasUpdate = true;
            }

            if (order.getOrder_Ship() != null) {
                updateSQL.append(" order_Ship = ?, ");
                hasUpdate = true;
            }

            if (hasUpdate) {
                updateSQL.setLength(updateSQL.length() - 2);
            }

            updateSQL.append(" WHERE order_Id = ?");

            PreparedStatement pst = connect.prepareStatement(updateSQL.toString());

            int parameterIndex = 0;

            if (order.getOrder_Client_Address() != null) {
                parameterIndex++;
                pst.setString(parameterIndex, order.getOrder_Client_Address());
            }

            if (order.getOrder_Status() != null) {
                parameterIndex++;
                pst.setString(parameterIndex, order.getOrder_Status());
            }

            if (order.getOrder_COD() != null) {
                parameterIndex++;
                pst.setString(parameterIndex, order.getOrder_COD());
            }

            if (order.getOrder_Date() != null) {
                parameterIndex++;
                pst.setDate(parameterIndex, new java.sql.Date(order.getOrder_Date().getTime()));
            }

            if (order.getOrder_Ship() != null) {
                parameterIndex++;
                pst.setDate(parameterIndex, new java.sql.Date(order.getOrder_Ship().getTime()));
            }

            parameterIndex++;
            pst.setString(parameterIndex, order.getOrder_Id());

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
