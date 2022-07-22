package com.infra.util;

import java.lang.instrument.Instrumentation;

public class MyBasicProfiler
{
    private static Instrumentation instrumentation;
    private static boolean firstTime;
    
    static {
        MyBasicProfiler.firstTime = true;
    }
    
    public static void premain(final String args, final Instrumentation inst) {
        MyBasicProfiler.instrumentation = inst;
    }
    
    public static Long getSizeInBytes(final Object o) {
        if (o == null) {
            return null;
        }
        return new Long(MyBasicProfiler.instrumentation.getObjectSize(o));
    }
    
    public static String getSize(final Object o) {
        try {
            if (o == null) {
                return "Referencia nula";
            }
            final long size = MyBasicProfiler.instrumentation.getObjectSize(o);
            if (size < 1024L) {
                return String.valueOf(size) + " Kbytes";
            }
            return String.valueOf(size / 1024L) + " Mbytes";
        }
        catch (Throwable e) {
            error(e);
            return "Tama\u00f1o desconocido";
        }
    }
    
    public static String getHeapSize() {
        return String.valueOf(Runtime.getRuntime().totalMemory() / 1024L) + " Kbytes";
    }
    
    public static String getHeapMaxSize() {
        return String.valueOf(Runtime.getRuntime().maxMemory() / 1024L) + " Kbytes";
    }
    
    public static String getHeapFreeSize() {
        return String.valueOf(Runtime.getRuntime().freeMemory() / 1024L) + " Kbytes";
    }
    
    public static String getUsedMemory() {
        Runtime.getRuntime().totalMemory();
        Runtime.getRuntime().freeMemory();
        return String.valueOf((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024L) + " Kbytes";
    }
    
    public static void invokeGarbageCollector() {
        try {
            System.gc();
            Thread.currentThread();
            Thread.sleep(100L);
            System.runFinalization();
            Thread.currentThread();
            Thread.sleep(100L);
        }
        catch (InterruptedException e) {
            error(e);
        }
    }
    
    private static void error(final Throwable e) {
        if (MyBasicProfiler.firstTime) {
            System.err.println("***********************");
            System.err.println("Error al inicializar Agente");
            e.printStackTrace();
            System.err.println("***********************");
            MyBasicProfiler.firstTime = false;
        }
    }
}