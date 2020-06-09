package ftt.ec.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ftt.ec.beans.Client;
import ftt.ec.model.DbUtil;

// https://github.com/danielscarvalho/FTT-PEOPLE-WEB-DB/blob/master/src/br/edu/cefsa/ftt/ec/dao/PeopleDao.java

/*
 * TODO 1. DONE - Criar tabela no banco de dados MySQL
 * TODO 2. DONE - Criar JavaBean para cada tabela do banco de dados MySQL
 * TODO 3. DONE - Criar a conex�o com o Banco de Dados (connection) DbUtil
 * TODO 4. DONE - Criar a interface Dao - Design Pattern - SQL para objetos vice-versa
 * TODO 5. DONE - Criar o Dao para a tabela "Client"
 * TODO 6. Criar WEB API CRUD para a tabela "Client"
 * TODO 7. DONE - Criar pasta libs e importar driver JDBC para banco de dados (.jar)
 * TODO 8. DONE - Importar .jar do JDBC no Java Build Path
 * 
 * Para N1 2B LP3 - Criar 5 tabelas...
 * Testar com Postman
 * Equipe de 1, 2 ou 3 alunos
 * 
 * 
 */

public class ClientDao implements Dao<Client> {
	
	private Connection connection;
	
	//Constructor
	public ClientDao() {
		this.connection = DbUtil.getConnection();
	}

	@Override
	public void insert(Client client) {

		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO FTT.CLIENT (NAME, EMAIL, ADDRESS, PHONE, CELL_PHONE, DOB, BUDGETS, LIMITS, STATUS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            // Parameters start with 1
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getEmail());
            preparedStatement.setString(3, client.getAddress());
            preparedStatement.setString(4, client.getPhone());
            preparedStatement.setString(5, client.getCellPhone());
            //Data do Java tem timezone, o BD n�o tem!!!
              // java.sql.Date -> Não tem timezone
              // java.util.Date -> Tem timezone
            preparedStatement.setDate(6, (java.sql.Date) client.getDob());
            preparedStatement.setFloat(7, client.getBudget());
            preparedStatement.setFloat(8, client.getLimit());
            preparedStatement.setString(9, client.getStatus());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
	}

	@Override
	public void update(Client client) {
		
		try {
			//Java 13 - text block -  """   """
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE FTT.CLIENTS SET NAME=?, " 
                    		                           + "EMAIL=?, "
                    		                           + "ADRESS=?, "
                    		                           + "PHONE=?, "
                    		                           + "CELL_PHONE=?, "
                    		                           + "DOB=?, " 
                    		                           + "BUDGET=?, " 
                    		                           + "LIMIT=?, " 
                    		                           + "STATUS=?, " 
                                                + "WHERE ID=?");
            
            // Parameters start with 1
            // preparedStatement previne SQL Injection...
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getEmail());
            preparedStatement.setString(3, client.getAddress());
            preparedStatement.setString(4, client.getPhone());
            preparedStatement.setString(5, client.getCellPhone());           
            preparedStatement.setDate(6, (java.sql.Date)client.getDob());
            preparedStatement.setFloat(7, client.getBudget());
            preparedStatement.setFloat(8, client.getLimit());
            preparedStatement.setString(9, client.getStatus());

            preparedStatement.setInt(10, client.getId());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	} //update

	@Override
	public void delete(Client client) {

		try {
            
        	PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM FTT.CLIENT WHERE ID=?");
            
            // Parameters start with 1
            preparedStatement.setInt(1, client.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        		e.printStackTrace();
        } //try
		
	} //delete 

	@Override
	public Client find(Client client) {
		
		Client c = new Client();
        
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM FTT.CLIENT WHERE ID=?");
            
            preparedStatement.setLong(1, client.getId());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                c.setId(rs.getInt("ID"));
                c.setName(rs.getString("NAME"));
                c.setEmail(rs.getString("EMAIL"));
                c.setAddress(rs.getString("ADDRESS"));
                c.setPhone(rs.getString("PHONE"));
                c.setCellPhone(rs.getString("CELL_PHONE"));               
                c.setDob(rs.getDate("DOB"));
                c.setBudget(rs.getFloat("BUDGET"));
                c.setLimit(rs.getFloat("LIMIT"));
                c.setStatus(rs.getString("STATUS"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } //try

        return c;
		
	} //find

	@Override
	public ArrayList<Client> findAll(Client client) {
		//Ajustar para enviar os dados de forma paginada, usar fun��o SQL "LIMIT" do MySQL
		
		ArrayList<Client> cList = new ArrayList<Client>();
        
        try {
        	
            Statement statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery("SELECT * FROM FTT.CLIENT");
            
            while (rs.next()) {
                
            	Client c = new Client();
                
            	c.setId(rs.getInt("ID"));
                c.setName(rs.getString("NAME"));
                c.setEmail(rs.getString("EMAIL"));
                c.setAddress(rs.getString("ADDRESS"));
                c.setPhone(rs.getString("PHONE"));
                c.setCellPhone(rs.getString("CELL_PHONE"));
           
                c.setDob(rs.getDate("DOB"));
                c.setBudget(rs.getFloat("BUDGET"));
                c.setLimit(rs.getFloat("LIMIT"));
                c.setStatus(rs.getString("STATUS"));

                cList.add(c);
                
            } //while
            
        } catch (SQLException e) {
            e.printStackTrace();
        } //try

        return cList;
		
	} //findAll
	
	public int count() {
		
		int count = -1;
		
		try {
			
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT COUNT(1) QTD FROM FTT.CLIENT");
            
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                count = rs.getInt("QTD");
                
            } //if
            
        } catch (SQLException e) {
            e.printStackTrace();
        } //try

		return count;
		
	} //count
	
	public int maxId() {
		
		int maxId = -1;
		
		try {
			
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT MAX(ID) MAX_ID FROM CLIENT");
            
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                maxId = rs.getInt("MAX_ID");
                
            } //if
            
        } catch (SQLException e) {
            e.printStackTrace();
        } //try

		return maxId;
		
	} //maxId

} //ClientDao
