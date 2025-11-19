package tests;

import manager.ApplicationManager;
import manager.HelperUser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("marushana@yandex.ru", "Pokrov1304!");
        app.getHelperUser().submitLogin();

        //Assert

    }

}
