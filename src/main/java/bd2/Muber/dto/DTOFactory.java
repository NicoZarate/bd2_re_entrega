package bd2.Muber.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import bd2.Muber.model.*;

public class DTOFactory{
	
	public List <PasajeroDTO> crearPasajerosDTO(List <Pasajero> pasajeros){
		
		List <PasajeroDTO> pasajerosdto = new ArrayList<PasajeroDTO>();
		
		for(Pasajero p: pasajeros){
			pasajerosdto.add(new PasajeroDTO(p));
		}
		
		return pasajerosdto;
	}

	public List<ViajeDTO> crearViajesDTO(List<Viaje> viajes) {
		
		List <ViajeDTO> viajesdto = new ArrayList<ViajeDTO>();
		
		for(Viaje v: viajes){
			viajesdto.add(new ViajeDTO(v));
		}
		
		return viajesdto;
	}

	public List<ConductorDTO> crearConductoresDTO(List<Conductor> conductores) {
		List <ConductorDTO> conductoresdto = new ArrayList<ConductorDTO>();
		
		for(Conductor c: conductores){
			conductoresdto.add(new ConductorDTO(c));
		}
		
		return conductoresdto;
	}
	
	public ConductorDTO crearConductorDTO(Conductor c){
		
		Set<Viaje> viajes = c.getViajes();
        Set<ViajeDTO> viajesdto = new HashSet<ViajeDTO>();
		
		for(Viaje v: viajes){
			viajesdto.add(new ViajeDTO(v));
		}
		ConductorDTO conductordto = new ConductorDTO(c);
		conductordto.setViajes(viajesdto);
		conductordto.setPromedio(c.calificacionPromedio());
		return conductordto;
	}
	
    public PasajeroDTO crearPasajeroDTO(Pasajero p){
		
		return new PasajeroDTO(p);
	}
	
    public ViajeDTO crearViajeDTO(Viaje v){
		
		return new ViajeDTO(v);
	}
}