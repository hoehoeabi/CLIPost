package com.gg;

import lombok.Getter;

@Getter
public class Rq {
    private String actionName;
    private int id;


    public Rq(String cmd) {
        String[] queryStr = cmd.split(" ",2);
        actionName = queryStr[0];

        if(queryStr.length == 2){
            id = Integer.parseInt(queryStr[1]);
        }

    }
}
