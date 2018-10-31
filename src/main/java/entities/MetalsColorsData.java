package entities;

import enums.Colors;
import enums.Elements;
import enums.Metals;
import enums.Vegetables;

import java.util.List;

public class MetalsColorsData {

    private List<Integer> summary;
    private Integer odd;
    private Integer even;
    private List<Elements> elements;
    private Colors color;
    private Metals metals;
    private List<Vegetables> vegetables;

    public void parseSummary() {
        this.odd = summary.get(0);
        this.even = summary.get(1);
    }

    public List<Elements> getElements() {
        return elements;
    }

    public Integer getOdd() {
        return odd;
    }

    public Integer getEven() {
        return even;
    }

    public Colors getColor() {
        return color;
    }

    public Metals getMetal() {
        return metals;
    }

    public List<Vegetables> getVegetables() {
        return vegetables;
    }

}
