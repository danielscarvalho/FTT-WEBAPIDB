package ftt.ec.webapi;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ftt.ec.beans.Client;
import ftt.ec.model.ClientDao;

/**
 * Servlet implementation class ClientApi
 */


@WebServlet("/ClientApi")
public class ClientApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			             HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		Client c = new Client();
		
		// Note que getParamtere retorna string, 
		// a conversão é feita na classe Client (seters)
		
		c.setId(request.getParameter("ID"));
		c.setName(request.getParameter("NAME"));
		c.setEmail(request.getParameter("EMAIL"));
		c.setAddress(request.getParameter("ADDRESS"));
		c.setPhone(request.getParameter("PHONE"));
		c.setCellPhone(request.getParameter("CELLPHONE"));
		c.setDob(request.getParameter("DOB"));
		c.setBudget(request.getParameter("BUDGET"));
		c.setLimit(request.getParameter("LIMIT"));
		c.setStatus(request.getParameter("STATUS"));
		
		ClientDao clientDao = new ClientDao();
		
		clientDao.insert(c);

        //TODO: Gerenciar e propagar erro...		
		response.getWriter().append("Cliente Criado...");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, 
			                HttpServletResponse response) throws ServletException, IOException {
		
		Client c = new Client();
		
		// Note que getParamtere retorna string, 
		// a conversão é feita na classe Client (seters)
		
		c.setId(request.getParameter("ID"));
		
		System.out.println("Delete: " + c.getId());
		
		ClientDao clientDao = new ClientDao();
		
		clientDao.delete(c);
		
		//TODO: Implementar processamento de erro apropriado...
		response.getWriter().append("Cliente Apagado...");
		
	}

}
