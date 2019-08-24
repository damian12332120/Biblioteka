package BazaNowa.wypozyczalnia;

import BazaNowa.Ksiazka;
import BazaNowa.Okna;
import BazaNowa.Person;
import BazaNowa.Zalogowany;
import BazaNowa.wypozyczalnia.Wypozyczanie;

import javax.swing.*;

public class SprawdzenieStanu implements Okna {

    private JLabel wypozyczenia;
    private JTextArea pole;
    private JButton powrotDoMenu;

    public SprawdzenieStanu() {
        create();
        operacje();
    }

    public void create() {
        createFrame();
        createButton();
        createField();
        createLabel();
        powrotListener();
    }


    public void operacje() {
        wypozyczoneKsiazki();
    }

    @Override
    public void createFrame() {
        frame.setSize(500, 300);
    }

    @Override
    public void createButton() {
        powrotDoMenu = new JButton("Powrót");
        powrotDoMenu.setBounds(360, 200, 120, 40);
        frame.add(powrotDoMenu);

    }

    public void createField() {
        pole = new JTextArea();
        pole.setBounds(20, 30, 460, 160);
        frame.add(pole);
    }

    public void createLabel() {
        wypozyczenia = new JLabel("Twoje wypożyczenia");
        wypozyczenia.setBounds(185, 0, 130, 30);
        frame.add(wypozyczenia);
    }


    public void powrotListener() {
        powrotDoMenu.addActionListener(a -> {
            usuwanieElementow();
            Wypozyczanie w = new Wypozyczanie();
        });
    }

    public void wypozyczoneKsiazki() {
        Zalogowany zalogowany = new Zalogowany();
        Person person = zalogowany.getZalogowany();
        pole.setText(wypiszKsiazki(person));

    }

    public String wypiszKsiazki(Person person) {
        StringBuilder sb = new StringBuilder();
        if (!person.getListaKsiazek().isEmpty()) {
            for (Ksiazka ksiazka : person.getListaKsiazek()) {
                sb.append(ksiazka)
                        .append("\n");
            }
            return sb.toString();
        } else {
            return "Nie masz wypożyczonych książek";
        }
    }

    private void usuwanieElementow() {
        frame.remove(wypozyczenia);
        frame.remove(pole);
        frame.remove(powrotDoMenu);
    }


}
