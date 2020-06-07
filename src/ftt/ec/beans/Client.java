package ftt.ec.beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public void setId(String id) {
		if (id == null) {
			setId(0);
		} else {
		 setId(Integer.valueOf(id));
		}
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
	public void setDob(String dob) {
		try { //Conversão de data pode dar erro!!!
			setDob(brDateFormat(dob));
		} catch (Exception e) {
			e.printStackTrace();
		} //Função brDateFormat definida abaixo...
	}
	
	public float getBudget() {
		return budget;
	}
	public void setBudget(float budget) {
		this.budget = budget;
	}
	public void setBudget(String budget) {
		if (budget == null) {
			setBudget(0);
		} else {
			setBudget(Float.valueOf(budget));
		} //if
	}
	public float getLimit() {
		return limit;
	}
	public void setLimit(float limit) {
		this.limit = limit;
	}
	public void setLimit(String limit) {
		if (limit == null) {
			setLimit(0);
		} else {
			setLimit(Float.valueOf(limit));
		}
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		if (status == null) {
			this.status="OK";
		} else {
			this.status = status;
		} //if
	}
	public String getEmail() {
		// TODO Auto-generated method stub
		return this.email;
	}
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email = email;
	}
	private Date brDateFormat(String data) throws Exception { 
 		if (data == null || data.equals(""))
 			return null;
 		
         java.sql.Date date = null;
         
         try {
             DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
             date = new java.sql.Date( ((java.util.Date)formatter.parse(data)).getTime() );
         } catch (ParseException e) {            
             throw e;
         }
         return date;
 	}
	
}
