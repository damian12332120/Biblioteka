package BazaNowa;

import javax.swing.*;

public class Rejestracja implements Okna {

    private WalidacjaDanych walidacja;
    private JButton rejestacjaPrzycisk;
    private JButton doMenu;
    private JLabel imie;
    private JLabel nazwisko;
    private JLabel wiek;
    private JLabel nrTelefonu;
    private JLabel email;
    private JLabel haslo;
    private JLabel haslo2;
    private JTextField imieT;
    private JTextField nazwiskoT;
    private JTextField wiekT;
    private JTextField nrTelefonuT;
    private JTextField emailT;
    private JPasswordField hasloP;
    private JPasswordField haslo2P;

    public Rejestracja() {
        walidacja = new WalidacjaDanych();
        create();
        doMenuListener();
        zarejestrujListener();
    }

    public void create() {
        createFrame();
        createButton();
        createLabel();
        createField();
    }

    public boolean rejestrowanieUzytkownika() {
        if (sprawdzenieImienia() && sprawdzenieNazwiska() && sprawdzenieEmail() && sprawdzenieTelefonu() && sprawdzenieHasla()) {
            return true;
        }
        return false;
    }

    public boolean sprawdzenieHasla() {
        if (walidacja.validatePassword(hasloP.getText()) && hasloP.getText().equals(haslo2P.getText())) {
            return true;
        } else {
            JOptionPane.showMessageDialog(frame,"nieprawidłowa wartość: Hasło","Błąd danych",JOptionPane.ERROR_MESSAGE);
            hasloP. setText("");
            return false;
        }
    }

    public boolean sprawdzenieImienia() {
        if (walidacja.validateFirstName(imieT.getText())) {
            return true;
        } else {
            JOptionPane.showMessageDialog(frame,"nieprawidłowa wartość: Imie","Błąd danych",JOptionPane.ERROR_MESSAGE);
            imieT.setText("");
            return false;
        }
    }

    public boolean sprawdzenieNazwiska() {
        if (walidacja.validateLastName(nazwiskoT.getText())) {
            return true;
        } else {
            JOptionPane.showMessageDialog(frame,"nieprawidłowa wartość: Nazwisko","Błąd danych",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean sprawdzenieTelefonu() {
        if (walidacja.validatePhone(nrTelefonuT.getText())) {
            return true;
        } else {
            JOptionPane.showMessageDialog(frame,"nieprawidłowa wartość: nr. telefonu","Błąd danych",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean sprawdzenieEmail() {
        if (walidacja.validateEmail(emailT.getText())) {
            return true;
        } else {
            JOptionPane.showMessageDialog(frame,"nieprawidłowa wartość: Email","Błąd danych",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public Person wprowadzDane() {
        Person person = new Person();
        if (sprawdzenieImienia()) {
            person.setImie(imieT.getText());
        }
        if (sprawdzenieNazwiska()) {
            person.setNazwisko(nazwiskoT.getText());
        }
        if (!wiekT.getText().isEmpty()) {
            person.setWiek(Integer.parseInt(wiekT.getText()));
        }
        if (sprawdzenieTelefonu()) {
            person.setNrTelefonu(Integer.parseInt(nrTelefonuT.getText()));
        }
        if (sprawdzenieEmail()) {
            person.setEmail(emailT.getText());
        }
        if (sprawdzenieHasla()) {
            if (sprawdzenieHasla()) {
                person.setHaslo(hasloP.getText());
            }
        }
        return person;
    }

    public void doMenuListener() {
        doMenu.addActionListener(d -> {
            usuwanieElementow();
            OknoStartu p = new OknoStartu();
        });
    }

    public void zarejestrujListener() {
        rejestacjaPrzycisk.addActionListener(r -> {
            if (rejestrowanieUzytkownika()) {
                usuwanieElementow();
                wprowadzDoBazy(wprowadzDane());
                Logowanie logowanie = new Logowanie();
            }
        });
    }

    public void wprowadzDoBazy(Person person) {
        Manager manager = new Manager();
        manager.addPerson(person);
    }

    @Override
    public void createFrame() {
        System.out.println("aaa");
        frame.setSize(500, 300);
    }

    public void createLabel() {
        imie = new JLabel("Imie:");
        imie.setBounds(20, 10, 80, 20);
        frame.add(imie);
        nazwisko = new JLabel("Nazwisko:");
        nazwisko.setBounds(20, 30, 80, 20);
        frame.add(nazwisko);
        wiek = new JLabel("Wiek:");
        wiek.setBounds(20, 50, 80, 20);
        frame.add(wiek);
        nrTelefonu = new JLabel("Nr. telefonu:");
        nrTelefonu.setBounds(20, 70, 80, 20);
        frame.add(nrTelefonu);
        email = new JLabel("Email:");
        email.setBounds(20, 90, 80, 20);
        frame.add(email);
        haslo = new JLabel("Hasło:");
        haslo.setBounds(20, 110, 80, 20);
        frame.add(haslo);
        haslo2 = new JLabel("Powtórz hasło:");
        haslo2.setBounds(20, 130, 80, 20);
        frame.add(haslo2);
    }

    public void createField() {
        imieT = new JTextField();
        imieT.setBounds(100, 10, 120, 20);
        frame.add(imieT);
        nazwiskoT = new JTextField();
        nazwiskoT.setBounds(100, 30, 120, 20);
        frame.add(nazwiskoT);
        wiekT = new JTextField();
        wiekT.setBounds(100, 50, 120, 20);
        frame.add(wiekT);
        nrTelefonuT = new JTextField();
        nrTelefonuT.setBounds(100, 70, 120, 20);
        frame.add(nrTelefonuT);
        emailT = new JTextField();
        emailT.setBounds(100, 90, 120, 20);
        frame.add(emailT);
        hasloP = new JPasswordField();
        hasloP.setBounds(100, 110, 120, 20);
        frame.add(hasloP);
        haslo2P = new JPasswordField();
        haslo2P.setBounds(100, 130, 120, 20);
        frame.add(haslo2P);
    }

    @Override
    public void createButton() {
        rejestacjaPrzycisk = new JButton("Zarejestruj się");
        rejestacjaPrzycisk.setBounds(310, 190, 150, 50);
        frame.add(rejestacjaPrzycisk);
        doMenu = new JButton("Powrót do Menu");
        doMenu.setBounds(50, 190, 150, 50);
        frame.add(doMenu);
    }

    public void usuwanieElementow() {
        frame.remove(rejestacjaPrzycisk);
        frame.remove(doMenu);
        frame.remove(imie);
        frame.remove(imieT);
        frame.remove(nazwisko);
        frame.remove(nazwiskoT);
        frame.remove(wiek);
        frame.remove(wiekT);
        frame.remove(nrTelefonu);
        frame.remove(nrTelefonuT);
        frame.remove(email);
        frame.remove(emailT);
        frame.remove(haslo);
        frame.remove(haslo2);
        frame.remove(haslo2P);
        frame.remove(hasloP);
    }
}
