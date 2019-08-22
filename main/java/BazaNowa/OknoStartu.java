package BazaNowa;

import javax.swing.*;

public class OknoStartu implements Okna {


    private JButton rejestracja;
    private JButton logowanie;
    private JButton wyjscie;

    public OknoStartu() {
        createFrame();
        createButton();
        rejestracjaListener();
        logowanieListener();
        wyjscieListener();
    }

    public void createFrame() {
        frame.setVisible(true);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
    }

    public void createButton() {
        rejestracja = new JButton("Rejestracja");
        rejestracja.setBounds(120, 30, 150, 50);
        frame.add(rejestracja);
        logowanie = new JButton("Logowanie");
        logowanie.setBounds(120, 85, 150, 50);
        frame.add(logowanie);
        wyjscie = new JButton("Wyjscie");
        wyjscie.setBounds(120, 140, 150, 50);
        frame.add(wyjscie);
    }

    public void usuwanieElementow() {
        frame.remove(rejestracja);
        frame.remove(logowanie);
        frame.remove(wyjscie);
    }

    public void rejestracjaListener() {
        rejestracja.addActionListener(a -> {
            usuwanieElementow();
            Rejestracja rejestracja = new Rejestracja();
        });
    }

    public void logowanieListener() {
        logowanie.addActionListener(a -> {
            usuwanieElementow();
           Logowanie logowanie = new Logowanie();
        });
    }

    public void wyjscieListener() {
        wyjscie.addActionListener(a -> {
            System.exit(1);
        });
    }
}