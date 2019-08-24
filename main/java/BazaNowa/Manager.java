package BazaNowa;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Manager {

    private HibernateConnection hibernateConnection = new HibernateConnection();


    public void addPerson(Person person) {
        hibernateConnection.connect();
        Session session = hibernateConnection.getSessiong();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
    }

    public List<Person> getPersons() {
        hibernateConnection.connect();
        Session session = hibernateConnection.getSessiong();
        Transaction transaction = session.beginTransaction();
        List persons = session.createQuery("From Person").list();
        transaction.commit();
        session.close();
        return persons;
    }

    public List<Ksiazka> getKsiazki(String poCzym, String name) {
        hibernateConnection.connect();
        Session session = hibernateConnection.getSessiong();
        Transaction transaction = session.beginTransaction();
        String hql = String.format("From Ksiazka e Where e.%s = '%s' and e.czyWypozyczona = '0'", poCzym, name);
        List ksiazki = session.createQuery(hql).list();
        transaction.commit();
        session.close();
        return ksiazki;
    }

    public List<Ksiazka> getKsiazki() {
        hibernateConnection.connect();
        Session session = hibernateConnection.getSessiong();
        Transaction transaction = session.beginTransaction();
        String hql = "From Ksiazka e Where e.czyWypozyczona = '0'";
        List ksiazki = session.createQuery(hql).list();
        transaction.commit();
        session.close();
        return ksiazki;

    }

    public void addKsiazka(Ksiazka ksiazka) {
        hibernateConnection.connect();
        Session session = hibernateConnection.getSessiong();
        Transaction transaction = session.beginTransaction();
        session.save(ksiazka);
        transaction.commit();
        session.close();
    }


    public void addKsiazka(Person person, Ksiazka ksiazka) {
        doItKsiazka(person, ksiazka);
    }

    public void removeKsiazka(Person person, Ksiazka ksiazka) {
        doItKsiazka(person, ksiazka);
    }

    public void removeKsiazka(Ksiazka ksiazka) {
        hibernateConnection.connect();
        Session session = hibernateConnection.getSessiong();
        Transaction transaction = session.beginTransaction();
        session.remove(ksiazka);
        transaction.commit();
        session.close();
    }

    public void doItKsiazka(Person person, Ksiazka ksiazka) {
        hibernateConnection.connect();
        Session session = hibernateConnection.getSessiong();
        Transaction transaction = session.beginTransaction();
        session.update(person);
        session.update(ksiazka);
        transaction.commit();
        session.close();
    }
}
