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
            try{
                id = Integer.parseInt(queryStr[1]);
            }catch (NumberFormatException e){
                id = -1; //기본값 -1로 설정하여 id 입력하지 않은 경우를 판단한다.
            }

        }

    }
}
