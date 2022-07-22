package com.infra.core.exception;
 
public class CoreException extends Exception {

    private static final long serialVersionUID = 1694697089550403044L;

    private String flagExcep;
    private String customMessag;

    public String getFlagExcep() {
        if (null == flagExcep) {
            return "";
        }
        return flagExcep;
    }

    public void setFlagExcep(String flagExcep) {
        this.flagExcep = flagExcep;
    }

    public String getCustomMessag() {
        return customMessag;
    }

    public void setCustomMessag(String customMessag) {
        this.customMessag = customMessag;
    }

    public CoreException(final String message) {
        super(message);
    }

    public CoreException(final Throwable causa) {
        super(causa);
    }

    public CoreException(final String message, final Throwable causa) {
        super(message, causa);
    }

    public CoreException(final String message, final String flagExcep, final String customMessag) {
        super(message);
        this.flagExcep = flagExcep;
        this.customMessag = customMessag;
    }
}
