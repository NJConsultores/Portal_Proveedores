package com.infra.util;

public interface MensajesControlador {

	/**
	 * Opcion para establecer el contexto de faces como correcto.
	 */
	int SEVERITY_FACES_CORRECTO = 1;
	/**
	 * Opcion para establecer el contexto de faces como correcto pero con
	 * posibles errores u observaciones.
	 */
	int SEVERITY_FACES_WARNING = 2;
	/**
	 * Opcion para establecer el contexto de faces como erroneo.
	 */
	int SEVERITY_FACES_ERROR = 3;
	/**
	 * Mensaje generico que define una transaccion correcta.
	 */
	String MENSAJE_GENERICO_EXITO = "Transacci\u00f3n aplicada y salvada.";
	/**
	 * Valor predefinido para indicar al contexto de faces que una transaccion
	 * fue correcta.
	 */
	public static boolean TRANSACCION_CORRECTA = false;
	/**
	 * Valor predefinido para indicar al contexto de faces que una transaccion
	 * fue erronea.
	 */
	public static boolean TRANSACCION_ERRONEA = true;
	/**
	 * Mensaje generico que define una transaccion erronea.
	 */
	String MENSAJE_GENERICO_ERROR = "";

	/**
	 * Establece el contexto global para transacciones correctas, siempre debe
	 * usarse si se desea notificar en pantalla una transaccion correcta.
	 *
	 * @param descripcion_adicional
	 *            Utilizado para agregar una descripcion adicional.
	 */
	void transaccionCorrecta(String descripcion_adicional);

	/**
	 * Establece el contexto global para transacciones erroneas, siempre debe
	 * usarse si se desea notificar en pantalla una transaccion erronea.
	 *
	 * @param error
	 *            Mensaje de error. Default MENSAJE_GENERICO_ERROR
	 * @param descripcion_error
	 *            Descripcion detallada del error. Default null
	 */
	void transaccionErronea(String error, String descripcion_error);

	/**
	 * Agrega un FacesMessage.
	 *
	 * @param error
	 *            indica si el contexto de la validacion es erronea o no.
	 * @param severity_faces
	 *            Nivle de gravedad.
	 *            <ul>
	 *            <li>1 - CORRECTO</li>
	 *            <li>2 - WARNING</li>
	 *            <li>3 - ERROR</li>
	 *            </ul>
	 * @param resumen
	 *            Resumen del mensaje.
	 * @param detalle
	 *            Mensaje detallado.
	 */
	public void transaccionCompletada(boolean error, int severity_faces, String resumen, String detalle);

	/**
	 * Agrega un FacesMessage.
	 *
	 * @param detalle
	 *            Resumen del mensaje.
	 */
	public void transaccionCompleta(String detalle);

}
