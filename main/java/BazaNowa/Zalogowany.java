package BazaNowa;

import java.util.ArrayList;
import java.util.List;


public class Zalogowany {

    private static List<Person> zalogowani = new ArrayList<>(1);

    public Zalogowany() {
    }

    public void dodajZalogowanego(Person person) {
        zalogowani.clear();
        zalogowani.add(person);
    }

    public Person getZalogowany() {
       return zalogowani.get(0);
    }
}
