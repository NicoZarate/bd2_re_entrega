package bd2.Muber.dto;

import java.util.Date;
import java.util.Set;

import bd2.Muber.model.Conductor;
import bd2.Muber.model.Viaje;
public class ConductorDTO extends UsuarioDTO {
	
	private Date f_licencia;
	private Double promedio;
    private Set<ViajeDTO> viajes;
  
	public ConductorDTO(){

    }
    
    public ConductorDTO(String nombre, String contrasenia , Date f_licencia){
		
		super(nombre, contrasenia);
		this.f_licencia=f_licencia;
			
	}
    
    public ConductorDTO(Conductor c){
    	this.setId_usuario(c.getId_usuario());
		this.setNombre(c.getNombre());
		this.setContrasenia(c.getContrasenia());
		this.setF_ingreso(c.getF_ingreso());
		this.setF_licencia(c.getF_licencia());
		this.setPromedio(c.getPromedio());
    
    }
  

    //getters y setters
    
	

	public Date getF_licencia() {
		return f_licencia;
	}

	public void setF_licencia(Date f_licencia) {
		this.f_licencia = f_licencia;
	}

	
	  public Set<ViajeDTO> getViajes() {
			return viajes;
		}

		public void setViajes(Set<ViajeDTO> viajes) {
			this.viajes = viajes;
		}

		public Double getPromedio() {
			return promedio;
		}

		public void setPromedio(Double promedio) {
			this.promedio = promedio;
		}

	

}
