package report;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EditorialDAOImpl;
import dao.EditorialDAO;
import dao.EditorialDAOImpl;
import model.Editorial;
import model.Editorial;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Servlet implementation class PedidoReport
 */
@WebServlet("/EditorialReport")
public class EditorialReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EditorialDAOImpl dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditorialReport() {
        super();
        dao = new EditorialDAOImpl() {
			
			@Override
			public void updateEditorial(Editorial editorial) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Editorial readEditorial(Long id) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public List<Editorial> readAllEditoriales() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void deleteEditorial(Long id) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void createEditorial(Editorial editorial) {
				// TODO Auto-generated method stub
				
			}
		};
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reportPath = "C:\\Users\\Rincon\\newworkspace\\Project16\\src\\report\\Blank_Letter.jrxml";
		try {
			JasperReport report=JasperCompileManager.compileReport(reportPath);
			Map<String, Object> data= new HashMap<String, Object>();
			
			data.put("foto_perfil",this.getServletContext().getRealPath("/")+"images/foto_perfil.jpg");
			
			Class.forName("org.postgresql.Driver");
			Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5433/testdb",
					"postgres", "juanmeme");
			
			JasperPrint print = JasperFillManager.fillReport(report, data,
					connection);
			
			JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
		}catch(JRException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
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
