package model;
import java.io.Serializable;

	public class Editorial implements Serializable{
		private Long id;
		private String nombre;
		private String email;
		private String pais;
		private String tipo;
		
		public Editorial (Long id, String nombre, String email, String pais, String tipo) {
			
			super();
			this.id = id;
			this.nombre = nombre;
			this.email = email;
			this.pais = pais;
			this.tipo = tipo;
		}
		public Editorial() {
				this(0L, "", "", "", "");
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPais() {
			return pais;
		}
		public void setPais(String pais) {
			this.pais = pais;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", nombre=" + nombre + ", email=" + email + ", pais=" + pais + ", tipo=" + tipo +"]";
		}
		
		
		
	}


