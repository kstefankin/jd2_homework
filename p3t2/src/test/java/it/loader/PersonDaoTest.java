package it.loader;

import it.pojos.Person;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PersonDaoTest {

    static SessionFactory sessionFactory;
    PersonDao personDao;

    @BeforeClass
    public static void init() {
        StandardServiceRegistry reg =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.loader.cfg-test.xml")
                        .build();
        sessionFactory = new MetadataSources(reg)
                .buildMetadata()
                .buildSessionFactory();
    }

    @Before
    public void setUp() throws Exception {
        personDao = new PersonDao(sessionFactory);
    }

    @After
    public void tearDown() throws Exception {
        personDao = null;
    }




    @org.junit.Test
    public void savePerson() {
        //Given
        Person person = new Person();
       // person.setId(15);
        person.setName("Tolik");
        person.setAge(34);
        person.setSurname("Ivanov");

        //When
        Serializable id = personDao.savePerson(person);

        //Then
        assertEquals(1, id); // id=кол-во запусков теста

        assertEquals("Tolik", personDao.findPerson(1).getName()); // test PersonDao.find

        List<Person> list = personDao.getAllPersons();               // test PersonDao.delete
        personDao.deletePerson(list.get(0));
        list=personDao.getAllPersons();
        assertEquals(0, list.size());



    }


        // Перенес проверку в один метод т.к. по одному проходили, а при запуска классом не всегда.
//    @org.junit.Test
  //  public void findPerson() {

    //    assertEquals("Tolik", personDao.findPerson(1).getName());

   // }

  //  @org.junit.Test
  //  public void deletePerson() {

    //    List<Person> list = personDao.getAllPersons();
     //   personDao.deletePerson(list.get(0));
     //   list=personDao.getAllPersons();
    //    assertEquals(0, list.size());

    // }
}
