package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContacts {
    @DataProvider
    public Iterator<Object[]> example(){
        List<Object[]> list = new ArrayList<>();
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactSuccess(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder().name("Marina").lastName("Siachin").phone("0538535553").email("marusha@list.ru").address("Haifa, Alexander Yannay, 28, 2").description("hdkhkhk mom").build()});
        list.add(new Object[]{Contact.builder().name("Rita").lastName("Dolly").phone("0538535523").email("marusha@list.ru").address("Haifa, Alexander Yannay, 28, 2").description("hdkhkhk mom").build()});

        return list.iterator();
    }
}
