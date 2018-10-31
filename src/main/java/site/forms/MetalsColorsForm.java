package site.forms;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.ComboBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import entities.MetalsColorsData;
import enums.Colors;
import enums.Elements;
import enums.Metals;
import enums.Vegetables;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static enums.Vegetables.*;

public class MetalsColorsForm extends Form<MetalsColorsData> {

    @FindBy(css = "#odds-selector p")
    public RadioButtons odd;

    @FindBy(css = "#even-selector p")
    public RadioButtons even;

    @FindBy(css = "#elements-checklist p")
    public CheckList<Elements> elements;

    @JDropdown(
            root = @FindBy(css = ".colors"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(css = ".filter-option")
    )
    public Dropdown<Colors> color;

    public ComboBox<Metals> metals = new ComboBox<>(
            By.cssSelector(".metals .caret"),
            By.cssSelector(".metals li span"),
            By.cssSelector(".metals input")
    );

    @JDropdown(
            root = @FindBy(css = "#salad-dropdown"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(tagName = "button")
    )
    public Dropdown<Vegetables> vegetables;

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

    private void fillElements(List<Elements> elements) {
        elements.forEach(x -> {
            if (x != null) {
                this.elements.select(x);
            }
        });
    }

    private void fillVegetables(List<Vegetables> vegetables) {
        vegetables.forEach(x -> {
            if (x != null) {
                this.vegetables.select(x);
            }
        });
    }

    private void clearVegetables() {
        vegetables.select(VEGETABLES);
    }
}
