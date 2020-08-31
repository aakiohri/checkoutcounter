package com.shopcounter.service;


import java.util.List;

public interface StoreService<Output, Input> {
    Output create(Input input);

    Output find(int id);

    List<Output> find();
}
