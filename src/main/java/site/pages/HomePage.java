package site.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import entities.User;
import org.openqa.selenium.support.FindBy;
import site.forms.LoginForm;

public class HomePage extends WebPage {

    @FindBy(css = ".profile-photo")
    public Button profile;

    @FindBy(css = ".uui-navigation.m-l8 > li > a")
    public Menu headerMenu;

    public LoginForm loginForm;

    public void login(User user) {
        profile.click();
        loginForm.login(user);
    }

}
