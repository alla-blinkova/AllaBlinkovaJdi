package utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import entities.MetalsColorsData;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class MetalsColorsUtils {

    public static MetalsColorsData parseJson(int dataNum) throws FileNotFoundException {

        JsonReader reader = new JsonReader(new FileReader("src\\test\\resources\\JDI_ex8_metalsColorsDataSet.json"));
        JsonObject jsonObject = new JsonParser().parse(reader).getAsJsonObject();

        Gson gson = new Gson();
        return gson.fromJson(jsonObject.get("data_" + dataNum), MetalsColorsData.class);
    }
}
