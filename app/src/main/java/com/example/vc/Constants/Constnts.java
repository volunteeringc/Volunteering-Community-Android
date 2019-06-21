package com.example.vc.Constants;

public class Constnts {

    private static Constnts constants;

    private Constnts() {
    }

    public static Constnts getInstance() {
        if (constants == null) {
            constants = new Constnts();
        }
        return constants;
    }

    public String auth = " Bearer ";
}
