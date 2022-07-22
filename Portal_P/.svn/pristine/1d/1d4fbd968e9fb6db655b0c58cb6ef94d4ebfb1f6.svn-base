package com.infra.factura.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FechaUtil {
	private static final SimpleDateFormat FORMATO = new SimpleDateFormat();
	private static final String DATE_PATTERN_ES = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
	private static final String DATE_PATTERN_EN = "^(?:(?:(?:0?[13578]|1[02])(\\/|-|\\.)31)\\1|(?:(?:0?[1,3-9]|1[0-2])(\\/|-|\\.)(?:29|30)\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:0?2(\\/|-|\\.)29\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:(?:0?[1-9])|(?:1[0-2]))(\\/|-|\\.)(?:0?[1-9]|1\\d|2[0-8])\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

	public static String formato(Date fecha, String patron) {
		FORMATO.applyPattern(patron);
		return FORMATO.format(fecha);
	}

	public static String formatoSimpleEstandar(long fecha) {
		return formatoSimpleEstandar(new Date(fecha));
	}

	public static String formatoEstandar(long fecha) {
		return formatoEstandar(new Date(fecha));
	}

	public static String formatoSimpleEstandar(Date fecha) {
		return formato(fecha, "dd/MM/yyyy");
	}

	public static String formatoEstandar(Date fecha) {
		return formato(fecha, "dd/MM/yyyy HH:mm:ss");
	}

	public static Date parseo(String fecha, String patron) {
		Date resultado = null;

		try {
			FORMATO.applyPattern(patron);
			resultado = FORMATO.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	public static Date parseoSimpleEstandar(String fecha) {
		return parseo(fecha, "dd/MM/yyyy");
	}

	public static Date parseoEstandar(String fecha) {
		return parseo(fecha, "dd/MM/yyyy HH:mm:ss");
	}

	public static String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static boolean esMenor(Calendar cal, Calendar comp) {
		if (cal.compareTo(comp) <= 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 *
	 * @param cal
	 * @param comp
	 * @return
	 */
	public static boolean esMayorIgual(Calendar cal, Calendar comp) {

		if (cal.compareTo(comp) > 0) {
			return true;

		} else {
			return false;
		}

	}

	/**
	 *
	 * @param buscar
	 * @param menor
	 * @param mayor
	 * @return boolean
	 */
	public static boolean esEntre(Calendar buscar, Calendar menor, Calendar mayor) {

		if (esMayorIgual(buscar, menor) && esMenor(buscar, mayor)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Este metodo funciona para encontrar la diferencia en dias entre dos
	 * Calendar
	 * 
	 * @param inicio
	 * @param fin
	 * @return
	 */
	public static long diferenciaDates(Calendar inicio, Calendar fin) {
		long diferenciaMilis = fin.getTimeInMillis() - inicio.getTimeInMillis();
		long diferenciaDias = diferenciaMilis / (1000 * 60 * 60 * 24);
		return diferenciaDias;

	}

	/**
	 * Este metodo es utilizado para saber en dos letras el dia de la
	 * semana<br />
	 * y lo calcula por medio de la clase Calendar jsugando el dia de la semana
	 * 
	 * @return "Lu","Ma","Mi,"Ju","Vi","Sa","Do"
	 * @see Calendar
	 */
	public static String getDiaSemana() {
		String dia = "";
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int diaInt = cal.get(Calendar.DAY_OF_WEEK);
		switch (diaInt) {
		case 1:
			dia = "Do";
			break;
		case 2:
			dia = "Lu";
			break;
		case 3:
			dia = "Ma";
			break;
		case 4:
			dia = "Mi";
			break;
		case 5:
			dia = "Ju";
			break;
		case 6:
			dia = "Vi";
			break;
		case 7:
			dia = "Sa";
			break;

		}
		return dia;
	}

	/**
	 * Este metodo es utilizado para saber en numero el dia de la semana<br />
	 * y lo calcula por medio de la clase Calendar jsugando el dia de la semana
	 * 
	 * @return 1,2,3,4,5,6,7
	 * @see Calendar
	 */
	public static int getDiaSemanaInt() {

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal.get(Calendar.DAY_OF_WEEK) + 1;
	}

	/**
	 * Resta un determidado numero de minutos a una hora especificada en un
	 * Calendar <b>NO SE PODRA RESTAR MAS DE 60MINUTOS</B>
	 * 
	 * @param cal
	 * @param minutosAgregar
	 * @see Calendar
	 */
	public static Calendar restaMinutos(Calendar cal, int mintuosARestar) {
		Calendar calendar = Calendar.getInstance();
		int hora = cal.get(Calendar.HOUR_OF_DAY);
		int minuto = cal.get(Calendar.MINUTE);
		if (minuto - mintuosARestar < 0) {
			int nuevoMinuto = 60 - mintuosARestar;
			calendar.set(0, 0, 0, hora - 1, nuevoMinuto);
		} else {
			calendar.set(0, 0, 0, hora, calendar.get(Calendar.MINUTE) - mintuosARestar);
		}
		return calendar;
	}

	/**
	 * Agrega un determidado numero de minutos a una hora especificada en un
	 * Calendar * <b>NO SE PODRA AGREGAR MAS DE 60MINUTOS</B>
	 * 
	 * @param cal
	 * @param minutosAgregar
	 * @see Calendar
	 */
	public static Calendar agregaMinutos(Calendar cal, int minutosAgregar) {
		Calendar calendar = Calendar.getInstance();
		int hora = cal.get(Calendar.HOUR_OF_DAY);
		int minuto = cal.get(Calendar.MINUTE);
		if (minuto + minutosAgregar >= 60) {
			int nuevoMinuto = minuto - 60;
			nuevoMinuto -= minutosAgregar;
			calendar.set(0, 0, 0, (hora + 1), nuevoMinuto, Calendar.MINUTE);
		} else {
			calendar.set(0, 0, 0, hora, cal.get(Calendar.MINUTE) + minutosAgregar);
		}
		return calendar;
	}

	public static String getFechaCompletaEsp(String separador) {
		Date date = new Date();
		SimpleDateFormat formating = new SimpleDateFormat("yyyy,MM,dd");

		StringBuffer buffer = new StringBuffer();
		StringTokenizer tokens = new StringTokenizer(formating.format(date), ",");
		buffer.append(tokens.nextElement().toString());
		buffer.append(separador);

		switch (Integer.parseInt(tokens.nextElement().toString())) {
		case 1:
			buffer.append("Enero");
			break;
		case 2:
			buffer.append("Febrero");
			break;
		case 3:
			buffer.append("Marzo");
			break;
		case 4:
			buffer.append("Abril");
			break;
		case 5:
			buffer.append("Mayo");
			break;
		case 6:
			buffer.append("Junio");
			break;
		case 7:
			buffer.append("Julio");
			break;
		case 8:
			buffer.append("Agosto");
			break;
		case 9:
			buffer.append("Septiembre");
			break;
		case 10:
			buffer.append("Octubre");
			break;
		case 11:
			buffer.append("Nobiembre");
			break;
		case 12:
			buffer.append("Diciembre");
			break;
		}
		buffer.append(separador);
		buffer.append(tokens.nextElement().toString());
		return buffer.toString().toUpperCase();
	}

	public static boolean isFechaValida(String fecha) {
		boolean fechaValida = false;
		final Matcher matcherEs = Pattern.compile(DATE_PATTERN_ES).matcher(fecha);
		final Matcher matcherEn = Pattern.compile(DATE_PATTERN_EN).matcher(fecha);

		if (matcherEs.matches()) {
			fechaValida = true;
		} else if (matcherEn.matches()) {
			fechaValida = true;
		}

		return fechaValida;
	}

	public static Date parseaFechaNacionalExtranjero(String fecha) {

		final Matcher matcherEs = Pattern.compile(DATE_PATTERN_ES).matcher(fecha);
		final Matcher matcherEn = Pattern.compile(DATE_PATTERN_EN).matcher(fecha);

		if (fecha.contains(".")) {
			fecha = fecha.replace(".", "/");
		}

		if (fecha.contains("-")) {
			fecha = fecha.replace("-", "/");
		}

		Date fechaParseada = null;
		if (matcherEs.matches()) {
			fechaParseada = parseo(fecha, "dd/MM/yyyy");

		} else if (matcherEn.matches()) {
			fechaParseada = parseo(fecha, "MM/dd/yyyy");
		}

		return fechaParseada;
	}

	public static String formatoWS(Date fecha) {
		return formato(fecha, "yyyy-MM-dd");
	}

	public static Date sumarMesesFecha(Date fecha, int numero) {
		Calendar calendario = GregorianCalendar.getInstance();
		int numeroMes = calendario.get(Calendar.MONTH);
		calendario.set(Calendar.MONTH, numeroMes + numero);
		return calendario.getTime();
	}
	
	public static Date sumarDiasFecha(Date fecha, int numero) {
		Calendar calendario = GregorianCalendar.getInstance();
		int numeroDia = calendario.get(Calendar.DAY_OF_MONTH);
		calendario.set(Calendar.DAY_OF_MONTH, numeroDia + numero);
		return calendario.getTime();
	}

}
