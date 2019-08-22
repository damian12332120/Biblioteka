package BazaNowa;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZalogowanyTest {

    @Test
    public void shouldAddZalogowany() {
        //given
        Zalogowany zalogowany = new Zalogowany();
        Person person = new Person();
        //when
        zalogowany.dodajZalogowanego(person);
        Person person1 = zalogowany.getZalogowany();
        //then
        assertEquals(person, person1);
    }

    @Test
    public void shouldGetZalogowany() {
        //given
        Zalogowany zalogowany = new Zalogowany();
        Person person = new Person();
        //when
        zalogowany.dodajZalogowanego(person);
        person = zalogowany.getZalogowany();
        //then
        assertEquals(zalogowany.getZalogowany(), person);
    }
}