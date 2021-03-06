package bd2.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.google.gson.Gson;


import bd2.Muber.model.*;
import bd2.Muber.services.*;
import bd2.Muber.dto.*;
import java.util.List;
@ControllerAdvice
@RequestMapping("/services")
@ResponseBody
@EnableWebMvc
public class MuberRestController {

	//lista de pasajeros
	@RequestMapping(value = "/pasajeros", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
	public String listarPasajeros() {
		
		List<PasajeroDTO> pasajeros = ServiceLocator.getPasajerosService().getPasajeros();
		Map<Long, String> aMap = new HashMap<Long, String>();
        for (PasajeroDTO elem : pasajeros) {
			aMap.put(elem.getId_usuario(), elem.getNombre());
		}
		
		return new Gson().toJson(aMap);
		
	}
	
	//listar todos los conductores
		@RequestMapping(value = "/conductores", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
		public String listarConductores() {
			List<ConductorDTO> conductores = ServiceLocator.getConductoresService().getConductores();
			Map<Long, String> aMap = new HashMap<Long, String>();
			for (ConductorDTO elem : conductores) {
				aMap.put(elem.getId_usuario(), elem.getNombre());
			}
		  return new Gson().toJson(aMap);
		}
		
		
		//listar todos los datos del conductor
		@RequestMapping(value = "/conductores/detalle/{conductorId}", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
		public String infoConductor(@PathVariable("conductorId") Long id_conductor) {
			try{ 
				if(id_conductor == null){
			    	return "no puso id";
			    }
				ConductorDTO c = ServiceLocator.getConductoresService().buscarConductor(id_conductor);
				return new Gson().toJson(this.mostrarInformacion(c) );
			 } catch(NullPointerException e)
            {
                return "no hay conductor con ese id";
            } 
		}
		
		//listar todos los viajes abiertos
		@RequestMapping(value = "/viajes/abiertos", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
		public String listarViajesAbiertos() {
			try{ 
			    List<ViajeDTO> viajes = ServiceLocator.getViajesService().getViajesAbiertos();
				Map<Long, Object> aMap = new HashMap<Long, Object>();
		        for (ViajeDTO elem : viajes) {
				    	aMap.put(elem.getId_viaje() , this.viajeInfo(elem));
				}
				
				return new Gson().toJson(aMap);
			 } catch(NullPointerException e)
            {
                return "no hay viajes abiertos";
            } 
		}
				
		//crear un viaje
				
//curl -X POST -d "origen=MardelPlata&destino=Cordoba&costoTotal=2500&cantidadPasajeros=3&conductorId=1" http://localhost:8080/MuberRESTful/rest/services/viajes/nuevo
		
		@RequestMapping(value = "/viajes/nuevo", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
		public Long crearViaje(
				@RequestParam("origen") String  origen,
				@RequestParam("destino") String  destino,
				@RequestParam("conductorId") Long  conductorId,
				@RequestParam("costoTotal") Float  costoTotal,
				@RequestParam("cantidadPasajeros") Integer  cantidadPasajeros){
			   if(origen == ""|| destino == "" || conductorId == null || costoTotal == null || cantidadPasajeros == null){
			    	return new Long(-1);
			    }
			   try{ 
			        ConductorDTO conductor = ServiceLocator.getConductoresService().buscarConductor(conductorId);
			        Long id = ServiceLocator.getViajesService().cargarViaje(origen, destino, cantidadPasajeros, costoTotal, conductorId);
			        if(id != null){
				       return id ;
			        }
			        return new Long(-1);
			   } catch(NullPointerException e)
	            {
				   return new Long(-1);
	            } 
			
			
	    }
		//curl -X PUT -d "viajeId=4" http://localhost:8080/MuberRESTful/rest/services/viajes/finalizar -G
		
		
		@RequestMapping(value = "/viajes/finalizar", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
		public String finalizarViaje(@RequestParam("viajeId") Long idViaje){
				if(idViaje == null){
			    	return "No puso el viajeId en la petici�n";
			    }	    
			      return ServiceLocator.getViajesService().finalizarViaje(idViaje);
					
			    }
		
		//cargar credito a un pasajero
				
		//curl -X PUT -d "monto=3000&pasajeroId=2" http://localhost:8080/MuberRESTful/rest/services/pasajeros/cargarCredito -G
				
				
		@RequestMapping(value = "/pasajeros/cargarCredito", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
		public String agregarCredito(
				@RequestParam("monto") Long monto,
				@RequestParam("pasajeroId") Long idPasajero){
			    if(idPasajero == null || monto == null ){
		           	return "No introdujo algun dato";
		        }	
				  return ServiceLocator.getPasajerosService().agregarCredito(idPasajero,monto);
					
				}
		
		//agregar pasajero a un viaje	
		
		//curl -X PUT -d "viajeId=4&pasajeroId=2" http://localhost:8080/MuberRESTful/rest/services/viajes/agregarPasajero -G
				
		@RequestMapping(value = "/viajes/agregarPasajero", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
		public String agregarPasajeroAViaje(
						@RequestParam("viajeId") Long idViaje,
						@RequestParam("pasajeroId") Long idPasajero) {
						if(idPasajero == null || idViaje == null ){
				           	return "No introdujo algun dato";
				        }
						
					   	return ServiceLocator.getPasajerosService().agregarPasajeroAViaje(idViaje,idPasajero);
									

			    }
		
		// crear una calificacion de parte de un pasajero 	

		//curl -X POST -d "viajeId=3&pasajeroId=2&comentario=rapido&puntaje=3" http://localhost:8080/MuberRESTful/rest/services/viajes/calificar
		
		@RequestMapping(value = "/viajes/calificar", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
		public String agregarCalificacion(
			@RequestParam("viajeId") Long id_viaje,
			@RequestParam("pasajeroId") Long id_pasajero,
         	@RequestParam("puntaje") Integer puntaje,
            @RequestParam("comentario") String comentario){
			if(id_pasajero == null || id_viaje == null || puntaje == null || comentario == ""){
	           	return "No introdujo algun dato";
	        }
			return ServiceLocator.getPasajerosService().calificarViaje(id_viaje, id_pasajero, puntaje, comentario);						

	    }
			
								
		@RequestMapping(value = "/conductores/top10", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
		public String conductoresTop10(){
			List<ConductorDTO> conductores = ServiceLocator.getConductoresService().top10();
			Map<String, Object> aMap = new HashMap<String, Object>();
			int puesto=1;
	        for (ConductorDTO elem : conductores) {
	        	if(elem.getPromedio()!= 0.0){
			    	aMap.put( "numero "+puesto ,infoTop10(elem));
			    	puesto++;
	        	}
			}
			return new Gson().toJson(aMap);
		}
		
		@RequestMapping(value = "/carga", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
		public String carga1(){
			
		     ServiceLocator.getPasajerosService().cargarBase();
		     return "carga con exito";
		}
		
		
		
		//metodos
		protected Map<String, Object> mostrarInformacion(ConductorDTO c){
			Map<String, Object> info = new HashMap<String, Object>();
			Map<String, Object> listaDeViajes = new HashMap<String, Object>();
			info.put("Nombre", c.getNombre());
			info.put("Clave", c.getContrasenia());
			info.put("Fecha de licencia", c.getF_licencia());
			info.put("Fecha de ingreso", c.getF_ingreso());
			
		    info.put("Calificacion promedio", c.getPromedio());
		    Collection <ViajeDTO> viajes= c.getViajes();
			for (ViajeDTO elem : viajes) {
				listaDeViajes.put("viaje "+ elem.getId_viaje(), this.viajeInfo(elem));
			}
			info.put("Lista de viajes", listaDeViajes);
			
			return info;	
			}
		
		
		protected Map<String, Object> infoTop10(ConductorDTO c){
			Map<String, Object> info = new HashMap<String, Object>();
			info.put("Nombre", c.getNombre());
			info.put("Calificacion promedio", c.getPromedio());
			return info;	
			}	
		
		
		protected Map<String, Object> viajeInfo(ViajeDTO v){
			Map<String, Object> mapViaje = new HashMap<String, Object>();
			mapViaje.put("max pasajero", v.getMax_pasajeros());
			mapViaje.put("origen", v.getOrigen());
			mapViaje.put("destino", v.getDestino());
			mapViaje.put("costo", v.getCosto());
			return mapViaje;	
			}
		
}

