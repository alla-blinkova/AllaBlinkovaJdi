package enums;

import com.google.gson.annotations.SerializedName;

public enum Colors {
    @SerializedName("Red")
    RED("Red"),
    @SerializedName("Green")
    GREEN("Green"),
    @SerializedName("Blue")
    BLUE("Blue"),
    @SerializedName("Yellow")
    YELLOW("Yellow");

    Colors(String text) {
        this.text = text;
    }

    public String text;
}
