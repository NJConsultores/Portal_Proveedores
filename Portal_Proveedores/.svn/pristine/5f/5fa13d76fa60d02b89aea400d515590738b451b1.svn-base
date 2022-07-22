/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.infra.core.util.jsf;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author rlagunas
 */
public class MsgUtil implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void addMsgError(String resumen, String detalle){
        addMsgGenerico(resumen, detalle, FacesMessage.SEVERITY_ERROR);
    }
    
    public static void addMsgInfo(String resumen, String detalle){
        addMsgGenerico(resumen, detalle, FacesMessage.SEVERITY_INFO);
    }
    
     public static void addMsgWarning(String resumen, String detalle){
        addMsgGenerico(resumen, detalle, FacesMessage.SEVERITY_WARN);
    }
    
    private static void addMsgGenerico(String resumen, String detalle, FacesMessage.Severity severity){
        FacesContext c = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage();
        fm.setDetail(detalle);
        fm.setSummary(resumen);
        fm.setSeverity(severity);
        
        c.addMessage(null, fm);
    }
    
}
