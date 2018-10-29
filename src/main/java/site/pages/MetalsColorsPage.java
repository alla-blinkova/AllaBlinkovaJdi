package site.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.TextArea;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import entities.MetalsColorsData;
import org.openqa.selenium.support.FindBy;
import site.forms.MetalsColorsForm;

import java.util.Arrays;

import static org.testng.Assert.assertTrue;

public class MetalsColorsPage extends WebPage {

    public MetalsColorsForm metalsColorsForm = new MetalsColorsForm();

    @FindBy(css = ".results")
    public TextArea results;

    public void checkResults(MetalsColorsData metalsColorsData) {
        if(!metalsColorsData.getSummary().isEmpty()) {
            checkLine("Summary: " + (Integer.parseInt(metalsColorsData.getOdd()) + Integer.parseInt(metalsColorsData.getEven())));
        } else {
            checkLine("Summary: 3");
        }

        if (!metalsColorsData.getElements().isEmpty()) {
            checkLine("Elements: " + String.join(", ", metalsColorsData.getElements()));
        }

        if (!metalsColorsData.getColor().isEmpty()) {
            checkLine("Color: " + metalsColorsData.getColor());
        } else {
            checkLine("Color: Colors");
        }

        if (!metalsColorsData.getMetal().isEmpty()) {
            checkLine("Metal: " + metalsColorsData.getMetal());
        } else {
            checkLine("Metal: Metals");
        }

        if (!metalsColorsData.getVegetables().isEmpty()) {
            checkLine("Vegetables: " + String.join(", ", metalsColorsData.getVegetables()));
        }
    }

    private void checkLine(String line) {
        assertTrue(Arrays.asList(results.getLines()).contains(line));
    }

}
