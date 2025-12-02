package tests;

import models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    @BeforeMethod
    public void preCondition() {
        //if SignOut button present --->logout
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("marushana@yandex.ru").withPassword("Pokrov1304!"));
        }

        //app.getHelperContact().provideContacts();//if contact list less then 3 >>add 3
        }
    }

    @Test
    public void removeFirstContact(){
        //assert size contact list less by one
    }

    @Test
    public void removeAllContacts(){
        //assert no contacts here
    }
}
