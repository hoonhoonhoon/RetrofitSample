package com.example.woowahan.retrofitsample.model;


import java.util.List;

/**
 * Created by jihoon on 2017. 1. 1..
 */

public interface DataModel<T> {

    void set(List<T> datas);

    T get(int position);

    List<T> getAll();

    void add(T item);

    void update(T item);

    void update(int position, T item);

    void delete(T item);

    void delete(int position);
}
