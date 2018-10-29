package entities;

import java.util.List;

public class MetalsColorsData {

    private List<String> summary;
    private String odd;
    private String even;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public void parseSummary() {
        this.odd = summary.isEmpty() ? "" : summary.get(0);
        this.even = summary.size() > 1 ? summary.get(1) : "";
    }

    public List<String> getElements() {
        return elements;
    }

    public String getOdd() {
        return odd;
    }

    public String getEven() {
        return even;
    }

    public List<String> getSummary() {
        return summary;
    }

    public String getColor() {
        return color;
    }

    public String getMetal() {
        return metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

}
