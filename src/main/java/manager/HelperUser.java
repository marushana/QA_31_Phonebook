package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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



    //*[text() = 'LOGIN']
    //input[@placeholder = 'Email']
    //input[@placeholder = 'Password']
    //*[text() = 'Login']
}
