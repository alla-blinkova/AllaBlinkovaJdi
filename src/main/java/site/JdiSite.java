package site;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import entities.User;
import site.pages.HomePage;
import site.pages.MetalsColorsPage;

public class JdiSite extends WebSite {

    @JPage(url = "/index.html")
    public static HomePage homePage;

    @JPage(url = "/metals-colors.html")
    public static MetalsColorsPage metalsColorsPage;

    public static void login(User user) {
        homePage.login(user);
    }
}
