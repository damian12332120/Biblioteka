package BazaNowa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ksiazka {
    @Id
    @GeneratedValue
    private long id;
    private String tytul;
    private String autor;
    private int rokWydania;
    private boolean czyWypozyczona;

    public boolean isCzyWypozyczona() {
        return czyWypozyczona;
    }

    public void setCzyWypozyczona(boolean czyWypozyczona) {
        this.czyWypozyczona = czyWypozyczona;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        autor = autor;
    }

    public int getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(int rokWydania) {
        this.rokWydania = rokWydania;
    }

    @Override
    public String toString() {
        return "Ksiazka{" +
                "id=" + id +
                ", tytul='" + tytul + '\'' +
                ", Autor='" + autor + '\'' +
                ", rokWydania=" + rokWydania +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
