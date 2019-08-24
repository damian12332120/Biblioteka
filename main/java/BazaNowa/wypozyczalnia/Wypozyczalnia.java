package BazaNowa.wypozyczalnia;

import BazaNowa.*;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

public class Wypozyczalnia implements Okna {

    private JButton wyszukiwaniePoTytule;
    private JButton wyszukiwaniePoAutorze;
    private JButton wyszukiwaniePoRoku;
    private JButton powrotDoMenu;
    private JTextArea pole;
    private JTextField idKsiazki;
    private JButton wypozycz;
    private List<Ksiazka> ksiazki;


    public Wypozyczalnia() {
        create();
        listeners();
    }

    public void wyszukiwanie(List<Ksiazka> ksiazki) {
        StringBuilder sb = new StringBuilder();
        if (!ksiazki.isEmpty()) {
            for (Ksiazka ksiazka : ksiazki) {
                sb.append(ksiazka)
                        .append("\n");
            }
        } else {
            sb.append("Nie ma dostępnych książek spełniających Twoje wymagania");
        }

        pole.setText(sb.toString());
    }

    public void wypozyczenieListener() {
        wypozycz.addActionListener(a -> {
            Ksiazka ksiazka;
            if (sprawdzenieNrKsiazki()) {
                int id = Integer.parseInt(idKsiazki.getText().trim());
                Zalogowany zalogowany = new Zalogowany();
                Person person = zalogowany.getZalogowany();
                ksiazka = wyszukiwanieKsiazki(id);
                wypozyczenie(person, ksiazka);
            }
        });
    }

    public boolean sprawdzenieNrKsiazki() {
        WalidacjaDanych walidacjaDanych = new WalidacjaDanych();
        return walidacjaDanych.validateNumber(idKsiazki.getText());
    }

    public Ksiazka wyszukiwanieKsiazki(int id) {
        List<Ksiazka> wypozyczenia = ksiazki
                .stream()
                .filter(b -> b.getId() == id).collect(Collectors.toList());
        return wypozyczenia.get(0);
    }

    public void wypozyczenie(Person person, Ksiazka ksiazka) {
        person.dodajKsiazke(ksiazka);
        if (person.getListaKsiazek().contains(ksiazka)) {
            ksiazka.setCzyWypozyczona(true);
            Manager manager = new Manager();
            manager.addKsiazka(person, ksiazka);
            usuwanieElementow();
        } else {
            usuwanieElementow();
        }
    }

    public void listeners() {
        poTytuleListener();
        poAutorzeListener();
        poRokuListener();
        wypozyczenieListener();
        powrotListener();
    }

    public void create() {
        createFrame();
        createButton();
        createField();
    }

    @Override
    public void createFrame() {
        frame.setSize(600, 500);
    }

    @Override
    public void createButton() {
        wyszukiwaniePoTytule = new JButton("Wyszukiwanie po tytule");
        wyszukiwaniePoTytule.setBounds(20, 10, 180, 40);
        frame.add(wyszukiwaniePoTytule);
        wyszukiwaniePoAutorze = new JButton("Wyszukiwanie po autorze");
        wyszukiwaniePoAutorze.setBounds(200, 10, 180, 40);
        frame.add(wyszukiwaniePoAutorze);
        wyszukiwaniePoRoku = new JButton("Wyszukiwanie po roku");
        wyszukiwaniePoRoku.setBounds(380, 10, 180, 40);
        frame.add(wyszukiwaniePoRoku);
        wypozycz = new JButton("Wypożycz ksiażkę");
        wypozycz.setBounds(380, 350, 180, 40);
        frame.add(wypozycz);
        powrotDoMenu = new JButton("Powrót");
        powrotDoMenu.setBounds(20, 350, 100, 40);
        frame.add(powrotDoMenu);
    }

    public void createField() {
        pole = new JTextArea();
        pole.setBounds(20, 50, 540, 300);
        frame.add(pole);
        idKsiazki = new JTextField();
        idKsiazki.setBounds(340, 350, 40, 40);
        frame.add(idKsiazki);

    }

    public void poTytuleListener() {
        wyszukiwaniePoTytule.addActionListener(a -> {
            String nazwa = pole.getText();
            Manager manager = new Manager();
            ksiazki = manager.getKsiazki("tytul", nazwa);
            wyszukiwanie(ksiazki);
        });
    }

    public void poAutorzeListener() {
        wyszukiwaniePoAutorze.addActionListener(a -> {
            String nazwa = pole.getText();
            Manager manager = new Manager();
            ksiazki = manager.getKsiazki("autor", nazwa);
            wyszukiwanie(ksiazki);
        });
    }

    public void poRokuListener() {
        wyszukiwaniePoRoku.addActionListener(a -> {
            String nazwa = pole.getText();
            Manager manager = new Manager();
            ksiazki = manager.getKsiazki("rokWydania", nazwa);
            wyszukiwanie(ksiazki);
        });
    }


    public void powrotListener() {
        powrotDoMenu.addActionListener(a -> {
            usuwanieElementow();
            Wypozyczanie w = new Wypozyczanie();
        });
    }

    private void usuwanieElementow() {
        frame.remove(wyszukiwaniePoTytule);
        frame.remove(wyszukiwaniePoAutorze);
        frame.remove(wyszukiwaniePoRoku);
        frame.remove(powrotDoMenu);
        frame.remove(pole);
        frame.remove(idKsiazki);
        frame.remove(wypozycz);
        Wypozyczanie w = new Wypozyczanie();
    }
}
