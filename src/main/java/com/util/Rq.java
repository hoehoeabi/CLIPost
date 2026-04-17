package com.util;

public class Rq {
    String action;
    int id;

    public Rq(String cmd){
        String[] cmdBits = cmd.split(" ");
        action = cmdBits[0];
        String str_id = cmdBits.length > 1 ? cmdBits[1] : "";
        try{
            id = str_id.isEmpty() ? 0 : Integer.parseInt(str_id);
        }catch(NumberFormatException e){
            id = 0;
        }
    }

    public String getAction() {
        return action;
    }

    public int getId() {
        return id;
    }
}
