package hw8;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import entities.MetalsColorsData;
import entities.User;
import org.testng.annotations.*;
import site.JdiSite;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JdiWebsiteTest extends TestNGBase {

    //выносить в init
    @SuppressWarnings("unchecked")
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        WebSite.init(JdiSite.class);
    }

    @DataProvider
    public Object[][] metalsColorsProvider() throws FileNotFoundException {

        return new Object[][]{
                {parseJson(1)},
                {parseJson(2)},
                {parseJson(3)},
                {parseJson(4)},
                {parseJson(5)},
                {parseJson(6)}
        };
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        JdiSite.homePage.open();
        JdiSite.login(User.PETER);
    }

    @Test(dataProvider = "metalsColorsProvider")
    public void metalColorsTest(MetalsColorsData metalsColorsData) {

        //2 Open Metals & Colors page by Header menu
        JdiSite.homePage.headerMenu.clickOn("METALS & COLORS");

        //3 Fill form Metals & Colors by data
        //4 Submit form Metals & Colors
        JdiSite.metalsColorsPage.metalsColorsForm.submit(metalsColorsData);

        //5 Result sections should contains data  below:
        JdiSite.metalsColorsPage.checkResults(metalsColorsData);

    }

    //выносить в utils
    private MetalsColorsData parseJson(int dataNum) throws FileNotFoundException {

        JsonReader reader = new JsonReader(new FileReader("src\\test\\resources\\JDI_ex8_metalsColorsDataSet.json"));
        JsonObject jsonObject = new JsonParser().parse(reader).getAsJsonObject();

        Gson gson = new Gson();
        return gson.fromJson(jsonObject.get("data_" + dataNum), MetalsColorsData.class);
    }

}
