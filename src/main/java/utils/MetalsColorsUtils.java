package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import entities.MetalsColorsData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class MetalsColorsUtils {

    public static Map<String, MetalsColorsData> parseJson() throws FileNotFoundException {

        JsonReader reader = new JsonReader(new FileReader("src\\test\\resources\\JDI_ex8_metalsColorsDataSet.json"));
        Type metalsColorsMapType = new TypeToken<Map<String, MetalsColorsData>>() {
        }.getType();
        return new Gson().fromJson(reader, metalsColorsMapType);
    }
}
