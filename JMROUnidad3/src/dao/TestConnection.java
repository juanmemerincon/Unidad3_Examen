package dao;

import java.util.List;

import model.Editorial;

public class TestConnection {
	public static void main(String[] args) {
		EditorialDAOImpl editorialDAOImpl = new EditorialDAOImpl();
		editorialDAOImpl.createEditorial(new Editorial(6L, "Potero","GSILBN","Vespertino","libro"));
		
		List<Editorial> editoriales = editorialDAOImpl.readAllEditoriales();
		for (Editorial editorial : editoriales) {
			System.out.println(editorial);
			
		}
	}

}
