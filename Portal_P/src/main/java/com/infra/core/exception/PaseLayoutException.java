/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infra.core.exception;

/**
 * Exception cuando se encuentra error al parsear un archivo
 * @author rlagunas
 */
public class PaseLayoutException extends Exception {

    /**
     * Creates a new instance of <code>PaseLayoutException</code> without detail
     * message.
     */
    public PaseLayoutException() {
    }

    /**
     * Constructs an instance of <code>PaseLayoutException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PaseLayoutException(String msg) {
        super(msg);
    }
}
