package com.trainings.model.dao;

import com.trainings.model.entity.Role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class roleMap {
    Map<Role, ArrayList<String>> asd = new HashMap<>();


    public roleMap(){
        asd.put(Role.USER, new ArrayList<>() );
    }

}
