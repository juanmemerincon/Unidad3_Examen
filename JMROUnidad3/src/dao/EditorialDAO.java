package dao;

import java.util.List;

import model.Editorial;

public interface EditorialDAO {
	
	void createEditorial(Editorial editorial);
	Editorial readEditorial(Long id);
	List<Editorial> readAllEditoriales();
	void updateEditorial(Editorial editorial);
	void deleteEditorial(Long id);
	

}
