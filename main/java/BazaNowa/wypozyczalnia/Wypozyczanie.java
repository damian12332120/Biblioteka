package BazaNowa.wypozyczalnia;

import BazaNowa.Logowanie;
import BazaNowa.Okna;

import javax.swing.*;

public class Wypozyczanie implements Okna {
    private JButton wypozycz;
    private JButton zdaj;
    private JButton sprawdzStan;
    private JButton powrot;


    public Wypozyczanie() {
        create();
        listener();
    }

    public void create(){
        createFrame();
        createButton();
    }

    public void listener(){
        wypozyczListener();
        zdajListener();
        sprawdzStanListener();
        powrotListener();
    }

    public void createFrame() {
        frame.setSize(400, 320);
    }

    public void createButton() {
        wypozycz = new JButton("Wypożycz książkę");
        wypozycz.setBounds(120, 30, 150, 50);
        frame.add(wypozycz);
        zdaj = new JButton("Zdaj książkę");
        zdaj.setBounds(120, 85, 150, 50);
        frame.add(zdaj);
        sprawdzStan = new JButton("Sprawdz stan");
        sprawdzStan.setBounds(120, 140, 150, 50);
        frame.add(sprawdzStan);
        powrot = new JButton(" Powrót");
        powrot.setBounds(120, 195, 150, 50);
        frame.add(powrot);

    }

    public void usuwanieElementow() {
        frame.remove(wypozycz);
        frame.remove(zdaj);
        frame.remove(sprawdzStan);
        frame.remove(powrot);
    }

    public void wypozyczListener() {
        wypozycz.addActionListener(a -> {
            usuwanieElementow();
            Wypozyczalnia wypozyczalnia = new Wypozyczalnia();
        });
    }

    public void zdajListener() {
        zdaj.addActionListener(a -> {
            usuwanieElementow();
            Zdaj zdaj = new Zdaj();
        });
    }

    public void sprawdzStanListener() {
        sprawdzStan.addActionListener(a -> {
            usuwanieElementow();
            SprawdzenieStanu sprawdzenieStanu = new SprawdzenieStanu();
        });
    }

    public void powrotListener() {
        powrot.addActionListener(a -> {
            usuwanieElementow();
            Logowanie logowanie = new Logowanie();
        });
    }
}
