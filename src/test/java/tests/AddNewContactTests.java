package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContactTests extends TestBase{

    @BeforeClass
    public void preCondition() {
        //if SignOut button present --->logout
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("marushana@yandex.ru").withPassword("Pokrov1304!"));
        }
    }

    @Test
    public void addNewContactSuccessAllFields(){
        int i = new Random().nextInt(1000)+1000;
        Contact contact1 = Contact.builder().name("Marina"+i).lastName("Siachin").phone("0538535553"+i).email("marusha"+i+"@list.ru").address("Haifa, Alexander Yannay, 28, 2").description("hdkhkhk mom").build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact1);
        app.getHelperContact().pause(12000);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperContact().isNewContactDisplayed(contact1));
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact1.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact1.getPhone()));

    }

    @Test
    public void addNewContactSuccessReqFields(){
        int i = new Random().nextInt(1000)+1000;
        Contact contact1 = Contact.builder().name("Marina"+i).lastName("Siachin").phone("0538535553"+i).email("marusha"+i+"@list.ru").address("Haifa, Alexander Yannay, 28, 2").build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact1);
        app.getHelperContact().pause(12000);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperContact().isNewContactDisplayed(contact1));
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact1.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact1.getPhone()));

    }

    @Test
    public void addNewContactWrongName(){
        Contact contact1 = Contact.builder().name("").lastName("Siachin").phone("0538535553").email("marusha@list.ru").address("Haifa, Alexander Yannay, 28, 2").description("Wrong Name").build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact1);
        app.getHelperContact().pause(12000);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperContact().isAddNewContactStillDisplayed());
    }

    @Test
    public void addNewContactWrongLastName(){
        Contact contact1 = Contact.builder().name("Marina").lastName("").phone("0538535553").email("marusha@list.ru").address("Haifa, Alexander Yannay, 28, 2").description("Wrong Last Name").build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact1);
        app.getHelperContact().pause(12000);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperContact().isAddNewContactStillDisplayed());

    }
    @Test
    public void addNewContactWrongEmail(){
        Contact contact1 = Contact.builder().name("Marina").lastName("Siachin").phone("0538535553").email("marushalist.ru").address("Haifa, Alexander Yannay, 28, 2").description("Email").build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact1);
        app.getHelperContact().pause(12000);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperContact().isAddNewContactStillDisplayed());
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Email not valid:"));

    }

    @Test
    public void addNewContactWrongPhone(){
        Contact contact1 = Contact.builder().name("Marina").lastName("Siachin").phone("").email("marusha@list.ru").address("Haifa, Alexander Yannay, 28, 2").description("Wrong Phone").build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact1);
        app.getHelperContact().pause(12000);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperContact().isAddNewContactStillDisplayed());
        Assert.assertTrue(app.getHelperUser().isAlertPresent(" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));
    }

    @Test
    public void addNewContactWrongAddress(){
        Contact contact1 = Contact.builder().name("Marina").lastName("Siachin").phone("0538535523").email("marusha@list.ru").address("").description("Wrong Address").build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact1);
        app.getHelperContact().pause(12000);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperContact().isAddNewContactStillDisplayed());


    }
}
