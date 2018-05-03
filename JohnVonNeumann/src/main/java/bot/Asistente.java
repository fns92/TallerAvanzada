package bot;

import fecha.Fecha;

public class Asistente {
	
	String nombreAsistente;
	
	public Asistente(String nombreAsistente) {
		super();
		this.nombreAsistente = nombreAsistente;
	}

	public String enviar(String user, String entrada) {
		
		entrada = entrada.toLowerCase();
		entrada = entrada.replace("por favor", "");
		
		try {
			if(entrada.matches(".*hola.*")) {
				return EcoResponse.devolverSaludo(user,nombreAsistente);
			}
			if(entrada.matches(".*gracias.*")) {
				return EcoResponse.devolverAgradecimiento(user);
			}
			if(entrada.matches(".*chau.*")) {
				return EcoResponse.devolverDespedida(user);
			}
			if(entrada.matches(".*clima en.*")) {
				return Weather.temperatura(entrada.split("clima en ")[1].split(",")[0]);
			}
			if(entrada.matches(".*hora es.*")) {
				return Fecha.hora();
			}
			if(entrada.matches(".*(dia es|fecha actual).*")) {
				return Fecha.fechaActual();
			}
			if(entrada.matches(".*dia de la semana.*")) {
				return Fecha.diaDeLaSemana();
			}
		}
		catch (Exception e) {
			return "Error, error (robotina voice).";
		}
		
		return "No entendํ lo que me dijiste "+user+".";
	}


}
