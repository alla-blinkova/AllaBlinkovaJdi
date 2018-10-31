package enums;

import com.google.gson.annotations.SerializedName;

public enum Elements {
    @SerializedName("Water")
    WATER("Water"),
    @SerializedName("Earth")
    EARTH("Earth"),
    @SerializedName("Wind")
    WIND("Wind"),
    @SerializedName("Fire")
    FIRE("Fire");

    Elements(String text) {
        this.text = text;
    }

    public String text;
}
