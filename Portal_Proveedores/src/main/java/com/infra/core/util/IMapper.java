package com.infra.core.util;

import java.io.Serializable;
import java.util.List;


public interface IMapper<T> extends Serializable {
    public T getById(T obj);
    public List<T> getAll();
    public void insert(T obj);
    public void update(T obj);
    public void delete(T obj);
    public  int getNextSequenceValue();
}

