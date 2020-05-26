package com.glumy.windplast.util;


public class Tools {

    public static String[] singlcameral = {"4/16/4", "4i/16/4", "4/16/4i", "4i/16/4i"};
    public static String[] bicameral = {"4/12/4/8/4", "4i/12/4/8/4", "4/12/4/8/4i", "4i/12/4/8/4i"};

    static String getsquareProduct(String width, String height) {
        int digitWidth = Integer.parseInt(width);
        int digitHeight = Integer.parseInt(height);
        double d = 1.0 * (digitWidth * digitHeight) / 1000000;
        double result = Math.round(d * 100.0) / 100.0;

        return result + " м. кв.";
    }
}
