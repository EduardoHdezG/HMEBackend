package mx.com.integradora.model.exception;

/**
 * clase IntegradoraException. Esta excepcion maneja los eventos de fallo de toda la aplicacion. 
 * 
 * Nota: Puede agregar otros elementos de detalle, pero debe usar al menos los dos elementos: 
 *			- code:   codigo de error 
 *		 	- error:  descripcion del error
 */
public class IntegradoraException extends Exception {

	private static final long serialVersionUID = 1L;

	private String code;
	private String error;

	public IntegradoraException() {
		super();
	}

	public IntegradoraException(String code, String error) {
		super();
		this.code = code;
		this.error = error;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
