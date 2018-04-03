package cn.catherine.by_rxjava.ui.aty;

import cn.catherine.by_rxjava.model.Person;
import cn.catherine.by_rxjava.model.PersonJava;

/**
 * Created by catherine on 2018/3/23.
 */

public class TestJ {
    public static void main(String[] args) {
        get();
        PersonJava personJava=new PersonJava();
        System.out.println(personJava);
    }

    static void get()  {
        Person person = null;
        try {
            person = Person.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(person);
    }

}
