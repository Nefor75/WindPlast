package com.glumy.windplast.connection;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("sale")
    private String sale;

   public String getSale() {
        return sale;
    }

}

