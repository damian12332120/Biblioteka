package BazaNowa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private int id;

    private String imie;
    private String nazwisko;
    private int nrTelefonu;
    private int wiek;
    private String email;
    private String haslo;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "wypozyczonaPrzez")
    private List<Ksiazka> listaKsiazek;

    public Person() {
        listaKsiazek = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Ksiazka> getListaKsiazek() {
        return listaKsiazek;
    }

    public void setListaKsiazek(List<Ksiazka> listaKsiazek) {
        this.listaKsiazek = listaKsiazek;
    }

    public String getHaslo() {
        return haslo;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }


    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setNrTelefonu(int nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void dodajKsiazke(Ksiazka ksiazka) {
        listaKsiazek.add(ksiazka);
    }

    public void usunKsiazke(Ksiazka ksiazka){
        listaKsiazek.remove(ksiazka);
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", nrTelefonu=" + nrTelefonu +
                ", wiek=" + wiek +
                ", email='" + email + '\'' +
                ", haslo='" + haslo + '\'' +
                ", listaKsiazek=" + listaKsiazek +
                '}';
    }
}

