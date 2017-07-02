# IMPORTANTE:

## Agregar al servidor
```sh
	-doble click en el servidor
	-open launch configuration
	-tab arguments
	-en VM Arguments agregar un -Dspring.profiles.active=dev
```

## La carga de la base de datos (la cual compone escenario del t1 etapa 1 , etapa 2 y datos para el top 10) y el escenario de esta etapa están ubicados en:

```sh
    -bd2\src\main\java\bd2\Muber\App.java
```

## También podes y debes agregar más tiempo al server en la ventana TIMEOUTS.

##se agrego una copia de la base de datos grupo12.sql por si se necesita.

##Se utilizo curl para las pruebas, los comandos usados (los ids varian segun fueron cargados en la base de datos):

Agregar un Viaje: 

    curl -X POST -d "origen=MardelPlata&destino=Cordoba&costoTotal=2500&cantidadPasajeros=3&conductorId=1" http://localhost:8080/MuberRESTful/rest/services/viajes/nuevo
		
Agregar pasajero a viaje:


    curl -X PUT -d "viajeId=4&pasajeroId=2" http://localhost:8080/MuberRESTful/rest/services/viajes/agregarPasajero -G

Agregar un calificación: 
   
    curl -X POST -d "viajeId=3&pasajeroId=2&comentario=rapido&puntaje=3" http://localhost:8080/MuberRESTful/rest/services/viajes/calificar
		
Cargar credito :

   curl -X PUT -d "monto=3000&pasajeroId=2" http://localhost:8080/MuberRESTful/rest/services/pasajeros/cargarCredito -G

Finalizar viaje :

  curl -X PUT -d "viajeId=4" http://localhost:8080/MuberRESTful/rest/services/viajes/finalizar -G
