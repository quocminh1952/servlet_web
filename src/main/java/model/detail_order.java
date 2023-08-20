package model;

import java.util.Objects;

public class detail_order {
	private String DO_Id;
	private order DO_order;
	private product DO_product;
	private double DO_quantity;
	private double DO_Price_Initial;
	private double DO_Price_Sales;
	private double DO_Price_Out;
	private double DO_Price_VAT;
	private double DO_Price_Sum;
	
	public detail_order(String dO_Id, order dO_order, product dO_product, double dO_quantity, double dO_Price_Initial,
			double dO_Price_Sales, double dO_Price_Out, double dO_Price_VAT, double dO_Price_Sum) {
		DO_Id = dO_Id;
		DO_order = dO_order;
		DO_product = dO_product;
		DO_quantity = dO_quantity;
		DO_Price_Initial = dO_Price_Initial;
		DO_Price_Sales = dO_Price_Sales;
		DO_Price_Out = dO_Price_Out;
		DO_Price_VAT = dO_Price_VAT;
		DO_Price_Sum = dO_Price_Sum;
	}

	public detail_order() {
	}

	public String getDO_Id() {
		return DO_Id;
	}

	public void setDO_Id(String dO_Id) {
		DO_Id = dO_Id;
	}

	public order getDO_order() {
		return DO_order;
	}

	public void setDO_order(order dO_order) {
		DO_order = dO_order;
	}

	public product getDO_product() {
		return DO_product;
	}

	public void setDO_product(product dO_product) {
		DO_product = dO_product;
	}

	public double getDO_quantity() {
		return DO_quantity;
	}

	public void setDO_quantity(double dO_quantity) {
		DO_quantity = dO_quantity;
	}

	public double getDO_Price_Initial() {
		return DO_Price_Initial;
	}

	public void setDO_Price_Initial(double dO_Price_Initial) {
		DO_Price_Initial = dO_Price_Initial;
	}

	public double getDO_Price_Sales() {
		return DO_Price_Sales;
	}

	public void setDO_Price_Sales(double dO_Price_Sales) {
		DO_Price_Sales = dO_Price_Sales;
	}

	public double getDO_Price_Out() {
		return DO_Price_Out;
	}

	public void setDO_Price_Out(double dO_Price_Out) {
		DO_Price_Out = dO_Price_Out;
	}

	public double getDO_Price_VAT() {
		return DO_Price_VAT;
	}

	public void setDO_Price_VAT(double dO_Price_VAT) {
		DO_Price_VAT = dO_Price_VAT;
	}

	public double getDO_Price_Sum() {
		return DO_Price_Sum;
	}

	public void setDO_Price_Sum(double dO_Price_Sum) {
		DO_Price_Sum = dO_Price_Sum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(DO_Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		detail_order other = (detail_order) obj;
		return Objects.equals(DO_Id, other.DO_Id);
	}
	
	
	
}
