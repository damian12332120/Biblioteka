package BazaNowa;

import javax.swing.*;

public class Wypozyczanie implements Okna{
    private JButton wypozycz;
    private JButton zdaj;
    private JButton sprawdzStan;


    public Wypozyczanie() {
        createFrame();
        createButton();
        wypozyczListener();
        zdajListener();
        sprawdzStanListener();
    }

    public void createFrame() {
        frame.setSize(400, 300);
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
    }

    public void usuwanieElementow() {
        frame.remove(wypozycz);
        frame.remove(zdaj);
        frame.remove(sprawdzStan);
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
}
