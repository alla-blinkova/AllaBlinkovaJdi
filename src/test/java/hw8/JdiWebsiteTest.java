package hw8;

import entities.MetalsColorsData;
import entities.User;
import org.testng.annotations.*;
import site.JdiSite;

import java.io.FileNotFoundException;

import static utils.MetalsColorsUtils.parseJson;

public class JdiWebsiteTest extends JdiWebsiteTestInit {

    @DataProvider()
    public Object[][] metalsColorsProvider() throws FileNotFoundException {

        return new Object[][]{
                {parseJson(1)},
                {parseJson(2)},
                {parseJson(3)},
                {parseJson(4)},
                {parseJson(5)}
        };
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        //1 Login on JDI site as User
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

}
