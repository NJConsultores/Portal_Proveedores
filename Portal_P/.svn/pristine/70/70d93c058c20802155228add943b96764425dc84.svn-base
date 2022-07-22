package com.infra.core.persistence;

import java.io.Serializable;
import java.util.List;


public interface IMapper<T> extends Serializable {
    public T buscarPorId(T obj);
    public List<T> buscarTodos();
    public void registrar(T obj);
    public void actualizar(T obj);
    public void actualizarEn(T obj);
    public void eliminar(T obj);
    public  int getNextSequenceValue();
}

