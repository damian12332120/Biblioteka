package BazaNowa.admin;

import BazaNowa.*;
import BazaNowa.wypozyczalnia.Wypozyczanie;

import javax.swing.*;
import java.util.List;

public class SprawdzWypozyczenia implements Okna {


    private JLabel wypozyczenia;
    private JTextArea pole;
    private JButton powrotDoMenu;

    public SprawdzWypozyczenia() {
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
        wypozyczenia = new JLabel("Stan wypożyczeń");
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
        Manager manager = new Manager();
        List<Person> listaWypozyczajacychKsiazki = manager.getPersons();
        pole.setText(wypiszKsiazki(listaWypozyczajacychKsiazki));

    }

    public String wypiszKsiazki(List<Person> listaWypozyczajacych) {
        StringBuilder sb = new StringBuilder();
        if (!listaWypozyczajacych.isEmpty()) {
            for (Person person : listaWypozyczajacych) {
                sb.append("Książki użytkownika ")
                .append(person.getId()+" "+person.getImie()+" "+person.getNazwisko()+" ")
                        .append("\n");
                for (Ksiazka ksiazka : person.getListaKsiazek()) {
                    sb.append(ksiazka)
                            .append("\n");
                }
                return sb.toString();

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
