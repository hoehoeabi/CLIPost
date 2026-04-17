package com;

public class Rq {
    String cmd;
    int id;
    String action;

    Rq(String rawCmd) {
        String[] parts = rawCmd.split(" ");
        this.cmd = parts[0];
        if (parts.length > 1) {
            this.id = Integer.parseInt(parts[1]);
        }
    }
}
