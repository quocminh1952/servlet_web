package DAO;

import java.util.ArrayList;

public interface DAO_Interface<T> {
	
	public ArrayList<T> selectALL();
	
	public T selectById(String id);
	
	public boolean addItem(T item);
	
	public boolean deleteItem(T item);
	
	public boolean updateItem(T item);
}
