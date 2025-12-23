package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        //if SignOut button present --->logout
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            logger.info("Before method finished logout");
        }
    }

    @DataProvider
    public Iterator<Object[]> loginData(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"marushana@yandex.ru","Pokrov1304!"});
        list.add(new Object[]{"sonya@gmail.com","Ss12345$"});
        list.add(new Object[]{"marushana@yandex.ru","Pokrov1304!"});
        list.add(new Object[]{"marushana@yandex.ru","Pokrov1304!"});
        list.add(new Object[]{"marushana@yandex.ru","Pokrov1304!"});
        return list.iterator();
    }

    @Test(dataProvider = "loginData")
    public void loginSuccess(String email, String password) {
        logger.info("Start test with name 'Login Success'");
        logger.info("Test data --->> email: "+email+", password: "+password);
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitLogin();

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is element button 'Sign Out' present");
    }

    @Test
    public void loginSuccessModel() {
        logger.info("Test data --->> email: 'marushana@yandex.ru' & password: 'Pokrov1304!'");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("marushana@yandex.ru", "Pokrov1304!");
        app.getHelperUser().submitLogin();

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is element button 'Sign Out' present");
    }

    @Test
    public void loginWrongEmail(){
        logger.info("Test data --->> email: 'marushanayandex.ru' & password: 'Pokrov1304!'");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("marushanayandex.com", "Pokrov1304!");
        app.getHelperUser().submitLogin();
        //Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with text 'Wrong email or password'");


    }

    @Test
    public void loginWrongPassword(){
        logger.info("Test data --->> email: 'marushana@yandex.ru' & password: 'pokrov1304'");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("marushana@yandex.ru", "pokrov1304");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with text 'Wrong email or password'");
    }

    @Test
    public void loginUnregisteredUser(){
        logger.info("Test data --->> email: 'ushana@yandex.ru' & password: 'pokrov1304'");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("ushana@yandex.ru", "pokrov1304");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with text 'Wrong email or password'");
    }
}
