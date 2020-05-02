package com.glumy.windplast.util;


public class Tools {

    public static String[] glasses = {"4/16/4", "4/8/4/12/4", "4/10/4/10/4"};
    public static int[] windowsill = {100, 150, 200, 250, 300, 350, 400, 450, 500};
    public static int[] weathering = {50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210, 220, 230, 240, 250, 260, 270, 280, 290, 300};

    static String getsquareProduct(String s, String s1) {
        int width = Integer.parseInt(s);
        int height = Integer.parseInt(s1);
        double d = 1.0 * (width * height) / 1000000;
        double result = Math.round(d * 100.0) / 100.0;

        return result + " m*2";
    }
}
