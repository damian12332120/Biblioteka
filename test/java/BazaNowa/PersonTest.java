package BazaNowa;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    @Test
    public void shouldAddBook() {
        //given
        Person person = new Person();
        Ksiazka ksiazka = new Ksiazka();
        ksiazka.setAutor("Henryk Sienkiewicz");
        //when
        person.dodajKsiazke(ksiazka);
        //then
        assertEquals(person.getListaKsiazek().size(),1);
    }

    @Test
    public void shouldRemoveBook() {
        //given
        Person person = new Person();
        Ksiazka ksiazka = new Ksiazka();
        ksiazka.setAutor("Henryk Sienkiewicz");
        //when
        person.dodajKsiazke(ksiazka);
        person.usunKsiazke(ksiazka);
        //then
        assertEquals(person.getListaKsiazek().size(),0);
    }
}