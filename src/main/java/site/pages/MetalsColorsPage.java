package site.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.TextArea;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import entities.MetalsColorsData;
import org.openqa.selenium.support.FindBy;
import site.forms.MetalsColorsForm;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;

public class MetalsColorsPage extends WebPage {

    public MetalsColorsForm metalsColorsForm = new MetalsColorsForm();

    @FindBy(css = ".results")
    public TextArea results;

    public void checkResults(MetalsColorsData metalsColorsData) {
        checkLine("Summary: " + (metalsColorsData.getOdd() + metalsColorsData.getEven()));
        checkLine("Elements: " + String.join(", ", metalsColorsData.getElements()
                .stream()
                .map(x -> x.text)
                .collect(Collectors.toList()))
        );
        checkLine("Color: " + metalsColorsData.getColor().text);
        checkLine("Metal: " + metalsColorsData.getMetal().text);
        checkLine("Vegetables: " + String.join(", ", metalsColorsData.getVegetables()
                .stream()
                .map(x -> x.text)
                .collect(Collectors.toList()))
        );
    }

    private void checkLine(String line) {
        assertTrue(Arrays.asList(results.getLines()).contains(line));
    }

}
