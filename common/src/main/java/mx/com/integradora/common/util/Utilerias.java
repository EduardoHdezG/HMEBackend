package mx.com.integradora.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import mx.com.integradora.common.constants.Constantes;

public class Utilerias {
	
	/** 
	 * Utileria de ejemplo
	 * @param Date date
	 * @return: String - fecha con formato "dd-MM-yyyy"
	 */
	public static String obtenerFechaConFormato(Date date) {
		String fechaFormat = null;
		SimpleDateFormat dateFormat;
		
		if (date != null) {
			dateFormat = new SimpleDateFormat(Constantes.FORMAT_dd_MM_yyyy);
			fechaFormat = dateFormat.format(date);
		}
		return fechaFormat;
	}
	
}
