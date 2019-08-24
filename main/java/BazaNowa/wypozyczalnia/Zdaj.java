package BazaNowa.wypozyczalnia;

import BazaNowa.*;
import BazaNowa.wypozyczalnia.Wypozyczanie;

import javax.swing.*;

public class Zdaj implements Okna {
    private JLabel wypozyczenia;
    private JTextArea pole;
    private JTextField nrKsiazki;
    private JButton oddaj;
    private JButton powrotDoMenu;

    public Zdaj() {
        create();
        wypozyczoneKsiazki();
        zdajKsiazke();
        powrotListener();
    }

    public void create() {
        createFrame();
        createButton();
        createField();
        createLabel();
    }

    @Override
    public void createFrame() {
        frame.setSize(500, 300);
    }

    @Override
    public void createButton() {
        oddaj = new JButton("Zdaj ksiazkę");
        oddaj.setBounds(320, 200, 120, 40);
        frame.add(oddaj);
        powrotDoMenu = new JButton("Powrót");
        powrotDoMenu.setBounds(50, 200, 120, 40);
        frame.add(powrotDoMenu);
    }

    public void createField() {
        pole = new JTextArea();
        pole.setBounds(20, 30, 460, 160);
        frame.add(pole);
        nrKsiazki = new JTextField();
        nrKsiazki.setBounds(280, 200, 40, 40);
        frame.add(nrKsiazki);
    }

    public void createLabel() {
        wypozyczenia = new JLabel("Twoje wypożyczenia");
        wypozyczenia.setBounds(185, 0, 130, 30);
        frame.add(wypozyczenia);
    }

    public void wypozyczoneKsiazki() {
        Zalogowany zalogowany = new Zalogowany();
        Person person = zalogowany.getZalogowany();
        StringBuilder sb = new StringBuilder();
        if (person.getListaKsiazek().isEmpty()) {
            pole.setText("Nie masz wypożyczonych książek");
        } else {
            for (Ksiazka ksiazka : person.getListaKsiazek()) {
                sb.append(ksiazka)
                        .append("\n");
            }
            pole.setText(sb.toString());
        }
    }

    public void zdajKsiazke() {
        oddaj.addActionListener(a -> {
            Ksiazka ksiazka;
            if (sprawdzenieNrKsiazki()) {
                int id = Integer.parseInt(nrKsiazki.getText());
                Zalogowany zalogowany = new Zalogowany();
                Person person = zalogowany.getZalogowany();
                ksiazka = pobranieKsiazki(person, id);
                oddanieKsiazki(person, ksiazka);
            }
        });
    }

    public boolean sprawdzenieNrKsiazki() {
        WalidacjaDanych walidacjaDanych = new WalidacjaDanych();
        return walidacjaDanych.validateNumber(nrKsiazki.getText());
    }

    public Ksiazka pobranieKsiazki(Person person, int id) {
        if (!person.getListaKsiazek().isEmpty()) {
            for (Ksiazka ksiazka : person.getListaKsiazek()) {
                if (ksiazka.getId() == id) {
                    return ksiazka;
                }
            }
        }
        return null;
    }

    public void oddanieKsiazki(Person person, Ksiazka ksiazka) {
        if (ksiazka != null) {
            person.usunKsiazke(ksiazka);
            ksiazka.setCzyWypozyczona(false);
            Manager manager = new Manager();
            manager.removeKsiazka(person, ksiazka);
            usuwanieElementow();
        } else {
            wypozyczoneKsiazki();
        }
    }

    public void powrotListener() {
        powrotDoMenu.addActionListener(a -> {
            usuwanieElementow();

        });
    }

    public void usuwanieElementow() {
        frame.remove(wypozyczenia);
        frame.remove(pole);
        frame.remove(nrKsiazki);
        frame.remove(oddaj);
        frame.remove(powrotDoMenu);
        Wypozyczanie w = new Wypozyczanie();
    }

}
