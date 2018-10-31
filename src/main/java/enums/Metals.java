package enums;

import com.google.gson.annotations.SerializedName;

public enum Metals {
    @SerializedName("Gold")
    GOLD("Gold"),
    @SerializedName("Silver")
    SILVER("Silver"),
    @SerializedName("Bronze")
    BRONZE("Bronze"),
    @SerializedName("Selen")
    SELEN("Selen");

    Metals(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public String text;
}
