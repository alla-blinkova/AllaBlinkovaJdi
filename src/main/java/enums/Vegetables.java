package enums;

import com.google.gson.annotations.SerializedName;

public enum Vegetables {
    @SerializedName("Cucumber")
    CUCUMBER("Cucumber"),
    @SerializedName("Tomato")
    TOMATO("Tomato"),
    @SerializedName("Vegetables")
    VEGETABLES("Vegetables"),
    @SerializedName("Onion")
    ONION("Onion");

    Vegetables(String text) {
        this.text = text;
    }

    public String text;
}
