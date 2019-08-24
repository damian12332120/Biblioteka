package BazaNowa.admin;

import BazaNowa.Ksiazka;
import BazaNowa.Manager;
import BazaNowa.Okna;
import BazaNowa.WalidacjaDanych;

import javax.swing.*;
import java.util.List;

public class UsunKsiazke implements Okna {
    Manager manager;
    private JLabel ksiazki;
    private JTextArea pole;
    private JTextField nrKsiazki;
    private JButton oddaj;
    private JButton powrotDoMenu;

    public UsunKsiazke() {
        manager = new Manager();
        create();
        wypozyczoneKsiazki();
        zdajKsiazke(wyszukajKsiazki());
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
        oddaj = new JButton("Usuń ksiazkę");
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
        ksiazki = new JLabel("Ksiazki biblioteki");
        ksiazki.setBounds(185, 0, 130, 30);
        frame.add(ksiazki);
    }

    public List<Ksiazka> wyszukajKsiazki() {
        Manager manager = new Manager();
        return manager.getKsiazki();
    }

    public void wypozyczoneKsiazki() {
        List<Ksiazka> listaKsiazekNiewypozyczonych = wyszukajKsiazki();
        StringBuilder sb = new StringBuilder();
        if (listaKsiazekNiewypozyczonych.isEmpty()) {
            pole.setText("Biblioteka nie posiada ksiażek");
        } else {
            for (Ksiazka ksiazka : listaKsiazekNiewypozyczonych) {
                sb.append(ksiazka)
                        .append("\n");
            }
            pole.setText(sb.toString());
        }
    }

    public void zdajKsiazke(List<Ksiazka> ksiazki) {
        oddaj.addActionListener(a -> {
            if (sprawdzenieNrKsiazki()) {
                int id = Integer.parseInt(nrKsiazki.getText());
                for (Ksiazka ksiazka : ksiazki) {
                    if (ksiazka.getId() == id) {
                        usuwanieKsiazki(ksiazka);
                    }
                }
            }
        });
    }

    public boolean sprawdzenieNrKsiazki() {
        WalidacjaDanych walidacjaDanych = new WalidacjaDanych();
        return walidacjaDanych.validateNumber(nrKsiazki.getText());
    }

    public void usuwanieKsiazki(Ksiazka ksiazka) {
        if (ksiazka != null) {
            Manager manager = new Manager();
            manager.removeKsiazka(ksiazka);
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
        frame.remove(pole);
        frame.remove(nrKsiazki);
        frame.remove(oddaj);
        frame.remove(powrotDoMenu);
        frame.remove(ksiazki);
        Administrator administrator = new Administrator();
    }

}