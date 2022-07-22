
package com.infra.core.util;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Reyna Lagunas Aranda <reyna.lagunas.aranda@gmail.com>
 */
public class ValidatorUtil {
    public static final boolean isEmpty(String s){
        return (s == null  || s.trim().isEmpty());
    }
    
    public static final boolean isEmpty(List<? extends Object> lista){
        return (lista == null  || lista.isEmpty());
    }
    
    public static final boolean isEmpty(HashMap<? extends Object, ? extends Object> lista){
        return (lista == null  || lista.isEmpty());
    }
    
    public static final boolean isNull(Object s){
        return (s == null );
    }
    
    public static boolean validaCorreo(String elCorreo) {
		Pattern pattern;
		Matcher matcher;
		pattern = Pattern.compile(CoreConstantes.EMAIL_PATTERN);
		matcher = pattern.matcher(elCorreo);
		if (!matcher.matches()) {
			return false;
		}
		return true;
	}

}
