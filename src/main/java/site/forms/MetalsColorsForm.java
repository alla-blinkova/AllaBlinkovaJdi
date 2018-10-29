package site.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.ComboBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import entities.MetalsColorsData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MetalsColorsForm extends Form<MetalsColorsData> {

    @FindBy(css = "#odds-selector p")
    public RadioButtons odd;

    @FindBy(css = "#even-selector p")
    public RadioButtons even;

    @FindBy(css = "#elements-checklist p")
    public CheckList elements;

    @JDropdown(
            root = @FindBy(css = ".colors"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(css = ".filter-option")
    )
    public Dropdown color;

    public ComboBox metals = new ComboBox(
            By.cssSelector(".metals .caret"),
            By.cssSelector(".metals li span"),
            By.cssSelector(".metals input")
    );

    @JDropdown(
            root = @FindBy(css = "#salad-dropdown"),
            list = @FindBy(tagName = "li")
    )
    public Dropdown vegetables;

    @FindBy(css = "#submit-button")
    public Button submit;

    @Override
    public void submit(MetalsColorsData data) {
        data.parseSummary();
        super.fill(data);
        clearVegetables();
        fillElements(data.getElements());
        fillVegetables(data.getVegetables());
        submit.click();
    }

    private void fillElements(List<String> elements) {
        elements.forEach(x -> this.elements.select(x));
    }

    private void fillVegetables(List<String> vegetables) {
        vegetables.forEach(x -> this.vegetables.select(x));
    }

    private void clearVegetables() {
        vegetables.select("Vegetables");
    }
}
