package BazaNowa;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Logowanie implements Okna {

    private JButton powrotDoMenu;
    private JButton zaloguj;
    private JLabel login;
    private JLabel haslo;
    private JTextField loginT;
    private JPasswordField hasloT;

    public Logowanie() {
        create();
        doMenuListener();
        logowanieListener();
    }


    public List<String> pobieranieDanych() {
        List<String> dane = new ArrayList<>();
        dane.add(0, loginT.getText());
        dane.add(1, hasloT.getText());
        return dane;
    }

    public void logowanieListener() {
        zaloguj.addActionListener(a -> {
                    if (!pobieranieUzytkownika().isEmpty()) {
                        usuwanieElementow();
                        Zalogowany z = new Zalogowany();
                        z.dodajZalogowanego(pobieranieUzytkownika().get(0));
                        Wypozyczanie wypozyczanie = new Wypozyczanie();
                    }else{
                        JOptionPane.showMessageDialog(frame,"Niewłaściwe dane","Błąd danych",JOptionPane.ERROR_MESSAGE);
                    }
                }
        );
    }

    public List<Person> pobieranieUzytkownika() {
        List<String> dane = pobieranieDanych();
        Manager manager = new Manager();
        return manager.getPersons()
                .stream()
                .filter(c -> c.getNazwisko().equals(dane.get(0)))
                .filter(b -> b.getHaslo().equals(dane.get(1)))
                .collect(Collectors.toList());
    }


    public void create() {
        createFrame();
        createButton();
        createField();
    }

    @Override
    public void createFrame() {
        System.out.println("bbb");
        frame.setSize(350, 300);
    }

    @Override
    public void createButton() {
        zaloguj = new JButton("Zaloguj się");
        zaloguj.setBounds(200, 190, 130, 50);
        frame.add(zaloguj);
        powrotDoMenu = new JButton("Powrót do Menu");
        powrotDoMenu.setBounds(10, 190, 130, 50);
        frame.add(powrotDoMenu);
    }

    public void createField() {
        login = new JLabel("Nazwisko:");
        login.setBounds(20, 10, 80, 20);
        frame.add(login);
        haslo = new JLabel("Hasło");
        haslo.setBounds(20, 30, 80, 20);
        frame.add(haslo);
        loginT = new JTextField();
        loginT.setBounds(100, 10, 120, 20);
        frame.add(loginT);
        hasloT = new JPasswordField();
        hasloT.setBounds(100, 30, 120, 20);
        frame.add(hasloT);
    }

    public void doMenuListener() {
        powrotDoMenu.addActionListener(d -> {
            usuwanieElementow();
            OknoStartu p = new OknoStartu();
        });
    }


    public void usuwanieElementow() {
        frame.remove(powrotDoMenu);
        frame.remove(zaloguj);
        frame.remove(login);
        frame.remove(haslo);
        frame.remove(loginT);
        frame.remove(hasloT);
    }
}
