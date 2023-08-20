package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.JDBC_Util;
import model.client;
import model.product;

public class DAO_client implements DAO_Interface<client>{
	private ArrayList<client> data_Client = new ArrayList<client>();
	
	public static DAO_client getInstance() {
		return new DAO_client();
	}
	
	@Override
	public ArrayList<client> selectALL() {
		
		try{
			//step_1 : create connection:
			Connection connect = JDBC_Util.getConnection();
			
			//step_2: create SQL query:
			String sql_query = "Select * From client ";
			
			PreparedStatement PS = connect.prepareStatement(sql_query);
			
			ResultSet result = PS.executeQuery();
			
			//get value by result
			while(result.next()) {
				String clientId = result.getString("client_Id");
				String clientLogin = result.getString("client_Login");
				String clientPassword =result.getString("client_Password");
				String clientFullName = result.getString("client_FullName");
				String clientGender = result.getString("client_Gender");
				String clientAddress = result.getString("client_Address");
				String clientPhoneNumber = result.getString("client_PhoneNumber");
				String clientEmail = result.getString("client_Email");
				Boolean clientReceiveEmail =  result.getBoolean("client_Receive_Email");
				
				client printClient = new client(clientId,clientLogin,clientPassword,clientFullName,clientGender,clientAddress,clientPhoneNumber,clientEmail,clientReceiveEmail);
				data_Client.add(printClient);
				
				//Close connection ,PrepatedStatement , ResultSet;
				connect.close();
				PS.close();
				result.close();
			}
			
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		return data_Client;
	}
	
	@Override
	public client selectById(String id) {
		client resultClient = new client();
		try {
			Connection connect = JDBC_Util.getConnection();
			
			String sql = "Select * From client"
						+" WHERE clientId = ?";
			
			PreparedStatement pst = connect.prepareStatement(sql);
			pst.setString(1,id);
			
			ResultSet result = pst.executeQuery();
			
			while(result.next()) {
				String clientId = result.getString("client_Id");
				String clientLogin = result.getString("client_Login");
				String clientPassword =result.getString("client_Password");
				String clientFullName = result.getString("client_FullName");
				String clientGender = result.getString("client_Gender");
				String clientAddress = result.getString("client_Address");
				String clientPhoneNumber = result.getString("client_PhoneNumber");
				String clientEmail = result.getString("client_Email");
				boolean clientReceiveEmail =  result.getBoolean("client_Receive_Email");
				
				resultClient = new client(clientId,clientLogin,clientPassword,clientFullName,clientGender,clientAddress,clientPhoneNumber,clientEmail,clientReceiveEmail);
				connect.close();
				pst.close();
				result.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultClient;
	}
	
	@Override
	public boolean addItem(client client){
		boolean result =false;
		try {
			Connection connect = JDBC_Util.getConnection();
			
			String sql = "INSERT INTO client "
						+"VALUE(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = connect.prepareStatement(sql);
			
			pst.setString(1,client.getClient_Id());
			pst.setString(2,client.getClient_Login());
			pst.setString(3,client.getClient_Password());
			pst.setString(4,client.getClient_FullName());
			pst.setString(5,client.getClient_Gender());
			pst.setString(6,client.getClient_Address());
			pst.setString(7,client.getClient_PhoneNumber());
			pst.setString(8,client.getClient_Email());
			pst.setBoolean(9,client.getClient_Receive_Email());
			
			/* use  executeUpdate() to insert/delete/update value in database
			and return the number of row has changed */
			if(pst.executeUpdate() != 0) {
				result = true;
			}else {
				result = false;
			}
			
			connect.close();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public boolean deleteItem(client client){
		boolean result =false;
		try {
			Connection connect = JDBC_Util.getConnection();
			
			String sql = "Delete From client Where client_Id = ? ";
				
			PreparedStatement pst = connect.prepareStatement(sql);
			
			pst.setString(1,client.getClient_Id());
			
			if(pst.executeUpdate() != 0) {
				result = true;
			}else {
				result = false;
			}
			
			connect.close();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public boolean updateItem(client client) {
		boolean result =false;
		try {
			Connection connect = JDBC_Util.getConnection();
			
			StringBuilder updateSQL = new  StringBuilder("UPDATE client SET ");
			
			// duyệt các trường hợp các trường dữ liệu muốn giữ nguyên => giá trị update == NULL
			boolean hasUpdate =false;
			
			if(client.getClient_Login() != null) {
				updateSQL.append(" client_Login = ? ,");
				hasUpdate =true;
			}
			
			if(client.getClient_Password() != null) {
				updateSQL.append(" client_Password = ? ,");
				hasUpdate =true;
			}

			
			if(client.getClient_FullName() != null) {
				updateSQL.append(" client_FullName = ? ,");
				hasUpdate =true;
			}
			
			if(client.getClient_Gender() != null) {
				updateSQL.append(" client_Gender = ? ,");
				hasUpdate =true;
			}

			
			if(client.getClient_Address() != null) {
				updateSQL.append(" client_Address = ? ,");
				hasUpdate =true;
			}

			
			if(client.getClient_PhoneNumber() != null) {
				updateSQL.append(" client_PhoneNumber = ? ,");
				hasUpdate =true;
			}

			
			if(client.getClient_Email() != null) {
				updateSQL.append(" client_Email = ? ,");
				hasUpdate =true;
			}

//			if(client.getClient_Receive_Email() != null) {
//				updateSQL.append(" client_Receive_Email = ? ,");
//				hasUpdate =true;
//			}
			
			if(hasUpdate) {
				updateSQL.setLength(updateSQL.length() - 2);
			}
			
			updateSQL.append(" WHERE client_Id =  ?");
			
			PreparedStatement pst = connect.prepareStatement(updateSQL.toString());
			
			// tạo biến xác định vị trí các tham số truyền vào câu truy vấn SQL
			int parameterIndex = 0;
			
			if(client.getClient_Login() != null) {
				parameterIndex++;
				pst.setString(parameterIndex,client.getClient_Login());
			}
			
			if(client.getClient_Password() != null) {
				parameterIndex++;
				pst.setString(parameterIndex,client.getClient_Password());
			}
			
			if(client.getClient_FullName() != null) {
				parameterIndex++;
				pst.setString(parameterIndex,client.getClient_FullName());
			}
			
			if(client.getClient_Gender() != null) {
				parameterIndex++;
				pst.setString(parameterIndex,client.getClient_FullName());
			}
			
			if(client.getClient_Address() != null) {
				parameterIndex++;
				pst.setString(parameterIndex,client.getClient_Address());
			}
			
			if(client.getClient_PhoneNumber() != null) {
				parameterIndex++;
				pst.setString(parameterIndex,client.getClient_PhoneNumber());
			}
			
			if(client.getClient_Email() != null) {
				parameterIndex++;
				pst.setString(parameterIndex,client.getClient_Email());
			}
			
			
			//if(client.getClient_Receive_Email() != null) {
				parameterIndex++;
				pst.setBoolean(parameterIndex,client.getClient_Receive_Email());
			//}
			
			if(parameterIndex > 0) {
				parameterIndex++;
				pst.setString(parameterIndex,client.getClient_Id());
			}
			
			if(pst.executeUpdate() > 0) {
				result = true;
			}else {
				result = false;
			}
			
			connect.close();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean checkUserExist(String username,String email) {
		boolean Check = false;
		try {
			//step 1: create connection
			Connection connect = JDBC_Util.getConnection();
			//step 2: create sql statment
			String sql = "select * from Client "
						+" where client_Login = ? or client_Email = ? ";
			//step 3: create Preparedstatement
			PreparedStatement pst = connect.prepareStatement(sql);
			pst.setString(1,username);
			pst.setString(2,email);
			
		//kiểm tra username hoặc email đã tồn tại trong csdl?
			ResultSet result = pst.executeQuery();
			//không có bản ghi => next() return false
			
			if(!result.next()) { 
				Check = true;
			}else {
				Check = false;
			}
			connect.close();
			pst.close();
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Check;
	}
	
	
	public client checkLoginUserExist(String account,String password) {
		client loginClient = new client();
		try {
			//step 1: create connection
			Connection connect = JDBC_Util.getConnection();
			//step 2: create sql statment
			String sql = "select * from Client "
						+" where (client_Login = ? or client_Email = ?) and client_Password = ? ";
			//step 3: create Preparedstatement
			PreparedStatement pst = connect.prepareStatement(sql);
			pst.setString(1,account);
			pst.setString(2,account);
			pst.setString(3,password);
			
			//kiểm tra User đã tồn tại trong csdl?
			ResultSet result = pst.executeQuery();
			//không có bản ghi => next() return false
			while(result.next()) {
				String clientId = result.getString("client_Id");
				String clientLogin = result.getString("client_Login");
				String clientPassword =result.getString("client_Password");
				String clientFullName = result.getString("client_FullName");
				String clientGender = result.getString("client_Gender");
				String clientAddress = result.getString("client_Address");
				String clientPhoneNumber = result.getString("client_PhoneNumber");
				String clientEmail = result.getString("client_Email");
				boolean clientReceiveEmail =  result.getBoolean("client_Receive_Email");
				
				loginClient = new client(clientId,clientLogin,clientPassword,clientFullName,clientGender,clientAddress,clientPhoneNumber,clientEmail,clientReceiveEmail);
				connect.close();
				pst.close();
				result.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginClient;
	}
}
