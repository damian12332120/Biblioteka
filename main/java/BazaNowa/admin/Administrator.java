package BazaNowa.admin;

import BazaNowa.Logowanie;
import BazaNowa.Okna;

import javax.swing.*;

public class Administrator implements Okna {

    private JButton dodajKsiazke;
    private JButton usunKsiazke;
    private JButton sprawdzWypozyczenie;
    private JButton powrotDoMenu;

    public Administrator() {
        create();
        listeners();
    }

    public void create() {
        createFrame();
        createButton();
    }

    public void listeners() {
        dodajKsiazkeListener();
        sprawdzWypozyczenieListener();
        powrotDoMenuListener();
        usunKsiazkeListener();
    }

    public void createFrame() {
       frame.setSize(400, 300);
    }

    @Override
    public void createButton() {
        dodajKsiazke = new JButton("Dodaj ksiażkę");
        dodajKsiazke.setBounds(120, 30, 170, 50);
        frame.add(dodajKsiazke);
        usunKsiazke = new JButton("Usun ksiażkę");
        usunKsiazke.setBounds(120,85,170,50);
        frame.add(usunKsiazke);
        sprawdzWypozyczenie = new JButton("Sprawdz wypożyczenia");
        sprawdzWypozyczenie.setBounds(120, 140, 170, 50);
        frame.add(sprawdzWypozyczenie);
        powrotDoMenu = new JButton("Powrót do menu");
        powrotDoMenu.setBounds(120, 195, 170, 50);
        frame.add(powrotDoMenu);
    }


    public void dodajKsiazkeListener() {
        dodajKsiazke.addActionListener(a -> {
            usuwanieElementow();
            DodajKsiazke dodajKsiazke = new DodajKsiazke();
        });
    }

    public void usunKsiazkeListener(){
        usunKsiazke.addActionListener( a->{
            usuwanieElementow();
            UsunKsiazke usunKsiazke = new UsunKsiazke();
        });
    }


    public void sprawdzWypozyczenieListener() {
        sprawdzWypozyczenie.addActionListener(a -> {
            usuwanieElementow();
            SprawdzWypozyczenia sw = new SprawdzWypozyczenia();
        });
    }

    public void powrotDoMenuListener() {
        powrotDoMenu.addActionListener(a -> {
            usuwanieElementow();
            Logowanie logowanie = new Logowanie();
        });
    }

    public void usuwanieElementow() {
        frame.remove(dodajKsiazke);
        frame.remove(usunKsiazke);
        frame.remove(sprawdzWypozyczenie);
        frame.remove(powrotDoMenu);
    }
}