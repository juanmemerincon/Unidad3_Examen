package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EditorialDAOImpl;
import model.Editorial;

/**
 * Servlet implementation class PedidoController1
 */
@WebServlet("/EditorialController1")
public class EditorialController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Editorial editorial;
	private List<Editorial> editoriales;
	private EditorialDAOImpl editorialDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditorialController1() {
    	editorial = new Editorial();
        editoriales = new ArrayList<Editorial>();
        editorialDAO = new EditorialDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
if (request.getParameter("btn_save")!= null) {
			
			editorial.setNombre(request.getParameter("nombre"));
			editorial.setEmail(request.getParameter("email"));
			editorial.setPais(request.getParameter("pais"));
			editorial.setTipo(request.getParameter("tipo"));
				
				
			if(editorial.getId()==0L) {
				editorialDAO.createEditorial(editorial);
				}else {
					editorialDAO.updateEditorial(editorial);
			}
			
			editoriales = editorialDAO.readAllEditoriales();
			request.setAttribute("editoriales", editoriales);
			request.getRequestDispatcher("editorial_list.jsp").forward(request, response);
			
		}else if (request.getParameter("btn_new")!=null) {
			editorial = new Editorial();
			request.getRequestDispatcher("editorial_form.jsp").forward(request, response);
			
		
		}else if(request.getParameter("btn_edit")!=null) {	
			try {
				Long id = Long.parseLong(request.getParameter("id"));
				editorial = editorialDAO.readEditorial(id);
				
			}catch (Exception e) {
				
				editorial = new Editorial();
			}
			request.setAttribute("editorial", editorial);
			
			request.getRequestDispatcher("editorial_form.jsp").forward(request, response);
			
			
			
		}else if(request.getParameter("btn_delete")!=null) {
		
			
			try {
			Long id = Long.parseLong(request.getParameter("id"));
			editorialDAO.deleteEditorial(id);
			editoriales = editorialDAO.readAllEditoriales();
			
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
			request.setAttribute("editoriales", editoriales);
			request.getRequestDispatcher("editorial_list.jsp").forward(request, response);
		}else {
			editoriales = editorialDAO.readAllEditoriales();
			request.setAttribute("editoriales", editoriales);
			request.getRequestDispatcher("editorial_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
