package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.JDBC_Util;
import model.product;

public class DAO_product implements DAO_Interface<product> {
    private ArrayList<product> data_product = new ArrayList<product>();

    public static DAO_product getInstance() {
        return new DAO_product();
    }

    @Override
    public ArrayList<product> selectALL() {

        try {
            // Step 1: Create connection
            Connection connect = JDBC_Util.getConnection();

            // Step 2: Create SQL query
            String sql_query = "SELECT * FROM product ";

            PreparedStatement PS = connect.prepareStatement(sql_query);

            ResultSet result = PS.executeQuery();

            // Get value by result
            while (result.next()) {
                String product_Id = result.getString("product_Id");
                String product_Name = result.getString("product_Name");
                String product_SL_Id = result.getString("product_SL_Id");
                int product_Year = result.getInt("product_Year");
                double product_price_In = result.getDouble("product_price_In");
                double product_price_Initial = result.getDouble("product_price_Initial");
                double product_price_out = result.getDouble("product_price_out");
                int product_quantity = result.getInt("product_quantity");
                String product_Story = result.getString("product_Story");

                product printProduct = new product();
                printProduct.setProduct_Id(product_Id);
                printProduct.setProduct_Name(product_Name);
                printProduct.setProduct_SL_Id(product_SL_Id);
                printProduct.setProduct_Year(product_Year);
                printProduct.setProduct_price_In(product_price_In);
                printProduct.setProduct_price_Initial(product_price_Initial);
                printProduct.setProduct_price_out(product_price_out);
                printProduct.setProduct_quantity(product_quantity);
                printProduct.setProduct_Story(product_Story);

                data_product.add(printProduct);

                // Close connection, PreparedStatement, ResultSet
                connect.close();
                PS.close();
                result.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data_product;
    }

    @Override
    public product selectById(String id) {
        product resultProduct = new product();
        try {
            Connection connect = JDBC_Util.getConnection();

            String sql = "SELECT * FROM product WHERE product_Id = ?";

            PreparedStatement pst = connect.prepareStatement(sql);
            pst.setString(1, id);

            ResultSet result = pst.executeQuery();

            while (result.next()) {
                String product_Id = result.getString("product_Id");
                String product_Name = result.getString("product_Name");
                String product_SL_Id = result.getString("product_SL_Id");
                int product_Year = result.getInt("product_Year");
                double product_price_In = result.getDouble("product_price_In");
                double product_price_Initial = result.getDouble("product_price_Initial");
                double product_price_out = result.getDouble("product_price_out");
                int product_quantity = result.getInt("product_quantity");
                String product_Story = result.getString("product_Story");

                resultProduct.setProduct_Id(product_Id);
                resultProduct.setProduct_Name(product_Name);
                resultProduct.setProduct_SL_Id(product_SL_Id);
                resultProduct.setProduct_Year(product_Year);
                resultProduct.setProduct_price_In(product_price_In);
                resultProduct.setProduct_price_Initial(product_price_Initial);
                resultProduct.setProduct_price_out(product_price_out);
                resultProduct.setProduct_quantity(product_quantity);
                resultProduct.setProduct_Story(product_Story);

                connect.close();
                pst.close();
                result.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultProduct;
    }

    @Override
    public boolean addItem(product product) {
        boolean result = false;
        try {
            Connection connect = JDBC_Util.getConnection();

            String sql = "INSERT INTO product VALUE(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setString(1, product.getProduct_Id());
            pst.setString(2, product.getProduct_Name());
            pst.setString(3, product.getProduct_SL_Id());
            pst.setInt(4, product.getProduct_Year());
            pst.setDouble(5, product.getProduct_price_In());
            pst.setDouble(6, product.getProduct_price_Initial());
            pst.setDouble(7, product.getProduct_price_out());
            pst.setInt(8, product.getProduct_quantity());
            pst.setString(9, product.getProduct_Story());

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
    public boolean deleteItem(product product) {
        boolean result = false;
        try {
            Connection connect = JDBC_Util.getConnection();

            String sql = "DELETE FROM product WHERE product_Id = ?";

            PreparedStatement pst = connect.prepareStatement(sql);

            pst.setString(1, product.getProduct_Id());

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
    public boolean updateItem(product product) {
        boolean result = false;
        try {
            Connection connect = JDBC_Util.getConnection();

            StringBuilder updateSQL = new StringBuilder("UPDATE product SET ");

            // Duyệt các trường hợp các trường dữ liệu muốn giữ nguyên => giá trị update == NULL
            boolean hasUpdate = false;

            if (product.getProduct_Name() != null) {
                updateSQL.append(" product_Name = ?, ");
                hasUpdate = true;
            }

            if (product.getProduct_SL_Id() != null) {
                updateSQL.append(" product_SL_Id = ?, ");
                hasUpdate = true;
            }

            if (product.getProduct_Year() != 0) {
                updateSQL.append(" product_Year = ?, ");
                hasUpdate = true;
            }

            if (product.getProduct_price_In() != 0) {
                updateSQL.append(" product_price_In = ?, ");
                hasUpdate = true;
            }

            if (product.getProduct_price_Initial() != 0) {
                updateSQL.append(" product_price_Initial = ?, ");
                hasUpdate = true;
            }

            if (product.getProduct_price_out() != 0) {
                updateSQL.append(" product_price_out = ?, ");
                hasUpdate = true;
            }

            if (product.getProduct_quantity() != 0) {
                updateSQL.append(" product_quantity = ?, ");
                hasUpdate = true;
            }

            if (product.getProduct_Story() != null) {
                updateSQL.append(" product_Story = ?, ");
                hasUpdate = true;
            }

            if (hasUpdate) {
                updateSQL.setLength(updateSQL.length() - 2);
            }

            updateSQL.append(" WHERE product_Id = ?");

            PreparedStatement pst = connect.prepareStatement(updateSQL.toString());

            int parameterIndex = 0;

            if (product.getProduct_Name() != null) {
                parameterIndex++;
                pst.setString(parameterIndex, product.getProduct_Name());
            }

            if (product.getProduct_SL_Id() != null) {
                parameterIndex++;
                pst.setString(parameterIndex, product.getProduct_SL_Id());
            }

            if (product.getProduct_Year() != 0) {
                parameterIndex++;
                pst.setInt(parameterIndex, product.getProduct_Year());
            }

            if (product.getProduct_price_In() != 0) {
                parameterIndex++;
                pst.setDouble(parameterIndex, product.getProduct_price_In());
            }

            if (product.getProduct_price_Initial() != 0) {
                parameterIndex++;
                pst.setDouble(parameterIndex, product.getProduct_price_Initial());
            }

            if (product.getProduct_price_out() != 0) {
                parameterIndex++;
                pst.setDouble(parameterIndex, product.getProduct_price_out());
            }

            if (product.getProduct_quantity() != 0) {
                parameterIndex++;
                pst.setInt(parameterIndex, product.getProduct_quantity());
            }

            if (product.getProduct_Story() != null) {
                parameterIndex++;
                pst.setString(parameterIndex, product.getProduct_Story());
            }

            parameterIndex++;
            pst.setString(parameterIndex, product.getProduct_Id());

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
