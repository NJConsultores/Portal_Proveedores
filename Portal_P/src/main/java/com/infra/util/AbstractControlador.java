package com.infra.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class AbstractControlador implements Serializable, MensajesControlador {

	private static final long serialVersionUID = 1L;

	/**
	 * Establece el contexto global para transacciones correctas, siempre debe
	 * usarse si se desea notificar en pantalla una transaccion correcta.
	 *
	 * @param descripcion_adicional
	 *            Utilizado para agregar una descripcion adicional.
	 */
	@Override
	public void transaccionCorrecta(String descripcion_adicional) {
		transaccionCompletada(TRANSACCION_CORRECTA, SEVERITY_FACES_CORRECTO, MENSAJE_GENERICO_EXITO,
				descripcion_adicional);
	}

	/**
	 * Establece el contexto global para transacciones erroneas, siempre debe
	 * usarse si se desea notificar en pantalla una transaccion erronea.
	 *
	 * @param error
	 *            Mensaje de error. Default MENSAJE_GENERICO_ERROR
	 * @param descripcion_error
	 *            Descripcion detallada del error. Default null
	 */
	@Override
	public void transaccionErronea(String error, String descripcion_error) {
		if (error != null) {
			error = MENSAJE_GENERICO_ERROR;
		}
		transaccionCompletada(TRANSACCION_ERRONEA, SEVERITY_FACES_ERROR, error, descripcion_error);
	}

	/**
	 * Agrega un FacesMessage.
	 *
	 * @param error
	 *            indica si el contexto de la validacion es erronea o no.
	 * @param severity_faces
	 *            Nivel de gravedad.
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
	@Override
	public void transaccionCompletada(boolean error, int severity_faces, String resumen, String detalle) {
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		currentInstance.addMessage(null,
				new FacesMessage(
						severity_faces == 1 ? FacesMessage.SEVERITY_INFO
								: severity_faces == 2 ? FacesMessage.SEVERITY_WARN : FacesMessage.SEVERITY_ERROR,
						resumen, detalle));
		if (error) {
			currentInstance.validationFailed();
		}
	}

	/**
	 * Agrega un FacesMessage.
	 *
	 * @param detalle
	 *            Mensaje detallado.
	 */
	@Override
	public void transaccionCompleta(String detalle) {
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		currentInstance.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, detalle, null));
	}

}
