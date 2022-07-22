package com.infra.core.util;

import java.util.Random;

/**
 *
 * @author Reyna Lagunas Aranda <reyna.lagunas.aranda@gmail.com>
 */
public class GeneradorPasswordUtil {

    public static String generarPassword() {
        int longuitud = 8;

        return getCadenaAlfanumAleatoria(longuitud);
    }

    static String getCadenaAlfanumAleatoria(int longitud) {
        StringBuilder cadenaAleatoria = new StringBuilder();
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < longitud) {
            char c = (char) r.nextInt(255);
            if (c >= 'A' && c <= 'Z') {
                cadenaAleatoria.append(c);
                if (i <= longitud - 2) {
                    int numero = (int) (Math.random() * 9);
                    cadenaAleatoria.append(numero);
                    i++;
                }
                i++;
            }
        }
        return cadenaAleatoria.toString();
    }
}
