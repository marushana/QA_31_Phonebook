package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        //if SignOut button present --->logout
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginSuccess() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("marushana@yandex.ru", "Pokrov1304!");
        app.getHelperUser().submitLogin();

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("marushana@yandex.ru", "Pokrov1304!");
        app.getHelperUser().submitLogin();

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test
    public void loginWrongEmail(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("marushanayandex.com", "Pokrov1304!");
        app.getHelperUser().submitLogin();
        //Assert.assertFalse(app.getHelperUser().isLogged());

    }

    @Test
    public void loginWrongPassword(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("marushana@yandex.ru", "pokrov1304");
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());
    }

    @Test
    public void loginUnregisteredUser(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("ushana@yandex.ru", "pokrov1304");
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());
    }
}
