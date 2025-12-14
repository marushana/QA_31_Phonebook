package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm(){
//        WebElement loginTab = wd.findElement(By.xpath("//*[text() = 'LOGIN']"));
//        loginTab.click();
        click(By.xpath("//*[text() = 'LOGIN']"));

    }

    public void fillLoginRegistrationForm(String email, String password){
        type(By.xpath("//input[@placeholder = 'Email']"), email);
        type(By.xpath("//input[@placeholder = 'Password']"), password);
//        WebElement inputEmail = wd.findElement(By.xpath("//input[@placeholder = 'Email']"));
//        inputEmail.click();
//        inputEmail.clear();
//        inputEmail.sendKeys(login);

//
//        WebElement inputPassword = wd.findElement(By.xpath("//input[@placeholder = 'Password']"));
//        inputPassword.click();
//        inputPassword.clear();
//        inputPassword.sendKeys(password);
    }

    public void fillLoginRegistrationForm(User user){
        type(By.xpath("//input[@placeholder = 'Email']"), user.getEmail());
        type(By.xpath("//input[@placeholder = 'Password']"), user.getPassword());
//        WebElement inputEmail = wd.findElement(By.xpath("//input[@placeholder = 'Email']"));
//        inputEmail.click();
//        inputEmail.clear();
//        inputEmail.sendKeys(login);

//
//        WebElement inputPassword = wd.findElement(By.xpath("//input[@placeholder = 'Password']"));
//        inputPassword.click();
//        inputPassword.clear();
//        inputPassword.sendKeys(password);
    }
//    public void inputEmail(){
//        WebElement inputEmail = wd.findElement(By.xpath("//input[@placeholder = 'Email']"));
//        inputEmail.sendKeys("marushana@yandex.ru");
//    }
//
//    public void inputPassword(){
//        WebElement inputPassword = wd.findElement(By.xpath("//input[@placeholder = 'Password']"));
//        inputPassword.sendKeys("Pokrov1304!");
//    }

    public void submitLogin(){
//        WebElement btnLogin = wd.findElement(By.xpath("//*[text() = 'Login']"));
//        btnLogin.click();
          click(By.xpath("//*[text() = 'Login']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text() = 'Sign Out']"));

    }

    public void logout() {
        click(By.xpath("//button[text() = 'Sign Out']"));
    }

    public boolean isAlertPresent(String message) {
        Alert alert = new WebDriverWait(wd, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent());

        if (alert != null&alert.getText().contains(message)){
            alert.accept();//click ok
//            alert.dismiss();//click cancel
//            alert.sendKeys("hello");//type into alert
            return true;
        }
        return false;
    }

    public void submitRegistration() {
        click(By.xpath("//button[text() = 'Registration']"));
    }

    public void login(User user) {
        openLoginRegistrationForm();
        fillLoginRegistrationForm(user);
        submitLogin();
    }
}
