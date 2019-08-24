package BazaNowa.admin;

import BazaNowa.Ksiazka;
import BazaNowa.Manager;
import BazaNowa.Okna;

import javax.swing.*;

public class DodajKsiazke implements Okna {

    private JButton dodanieKsiazki;
    private JButton powrotDoMenu;
    private JLabel autor;
    private JLabel tytul;
    private JLabel rokWydania;
    private JTextField autorT;
    private JTextField tytulT;
    private JTextField rokWydaniaT;


    public DodajKsiazke() {
        create();
        listeners();
    }

    public void listeners() {
        dodajKsiazkeListener();
        doMenuListener();
    }

    public void create() {
        createFrame();
        createLabel();
        createButton();
        createField();
    }

    public void dodajKsiazkeListener() {
        dodanieKsiazki.addActionListener(r -> {
            if (wprowadzDane() != null) {
                usuwanieElementow();
                wprowadzDoBazy(wprowadzDane());
                DodajKsiazke dodajKsiazke = new DodajKsiazke();
            }
        });
    }

    public void usuwanieElementow() {
        frame.remove(dodanieKsiazki);
        frame.remove(powrotDoMenu);
        frame.remove(autor);
        frame.remove(tytul);
        frame.remove(rokWydania);
        frame.remove(autorT);
        frame.remove(tytulT);
        frame.remove(rokWydaniaT);
    }

    public void wprowadzDoBazy(Ksiazka ksiazka) {
        Manager manager = new Manager();
        manager.addKsiazka(ksiazka);
    }

    public void doMenuListener() {
        powrotDoMenu.addActionListener(d -> {
            usuwanieElementow();
            Administrator administrator = new Administrator();
        });
    }

    public Ksiazka wprowadzDane() {
        Ksiazka ksiazka = new Ksiazka();
        if (!autorT.getText().isEmpty()) {
            ksiazka.setAutor(autorT.getText());
        }
        if (!tytulT.getText().isEmpty()) {
            ksiazka.setTytul(tytulT.getText());
        }
        if (!rokWydaniaT.getText().isEmpty()) {
            ksiazka.setRokWydania(Integer.parseInt(rokWydaniaT.getText()));
        }
        return ksiazka;
    }

    @Override
    public void createFrame() {
        System.out.println("aaa");
        frame.setSize(310, 300);
    }


    public void createLabel() {
        autor = new JLabel("Autor:");
        autor.setBounds(20, 10, 80, 20);
        frame.add(autor);
        tytul = new JLabel("Tytuł:");
        tytul.setBounds(20, 30, 80, 20);
        frame.add(tytul);
        rokWydania = new JLabel("Rok wydania:");
        rokWydania.setBounds(20, 50, 80, 20);
        frame.add(rokWydania);
    }

    public void createField() {
        autorT = new JTextField();
        autorT.setBounds(100, 10, 120, 20);
        frame.add(autorT);
        tytulT = new JTextField();
        tytulT.setBounds(100, 30, 120, 20);
        frame.add(tytulT);
        rokWydaniaT = new JTextField();
        rokWydaniaT.setBounds(100, 50, 120, 20);
        frame.add(rokWydaniaT);
    }

    @Override
    public void createButton() {
        dodanieKsiazki = new JButton("Dodaj Książkę");
        dodanieKsiazki.setBounds(165, 190, 120, 50);
        frame.add(dodanieKsiazki);
        powrotDoMenu = new JButton("Powrót do Menu");
        powrotDoMenu.setBounds(25, 190, 120, 50);
        frame.add(powrotDoMenu);
    }
}