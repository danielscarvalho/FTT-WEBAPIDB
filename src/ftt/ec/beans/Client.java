package ftt.ec.beans;

import java.util.Date;

//JavaBean
//POJO

public class Client {
	
	private int Id;
	private String name;
	private String email;
	private String address;
	private String phone;
	private String cellPhone;
	private Date Dob; //Date of Birth
	private float budget;
	private float limit;
	private String status;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public Date getDob() {
		return Dob;
	}
	public void setDob(Date dob) {
		Dob = dob;
	}
	public float getBudget() {
		return budget;
	}
	public void setBudget(float budget) {
		this.budget = budget;
	}
	public float getLimit() {
		return limit;
	}
	public void setLimit(float limit) {
		this.limit = limit;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		// TODO Auto-generated method stub
		return this.email;
	}
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email = email;
	}
	
	
}
