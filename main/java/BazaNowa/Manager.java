package BazaNowa;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Manager {

    private HibernateConnection hibernateConnection = new HibernateConnection();
    private Session session;
    private Transaction transaction;
    
    public void session() {
        hibernateConnection.connect();
        session = hibernateConnection.getSessiong();
        transaction = session.beginTransaction();
    }
    
    public void addPerson(Person person) {
        session();
        session.save(person);
        transaction.commit();
        session.close();
    }

    public List<Person> getPersons() {
        session();
        List persons = session.createQuery("From Person").list();
        transaction.commit();
        session.close();
        return persons;
    }

    public List<Ksiazka> getKsiazki(String poCzym, String name) {
        session();
        String hql = String.format("From Ksiazka e Where e.%s = '%s' and e.czyWypozyczona = '0'", poCzym, name);
        List ksiazki = session.createQuery(hql).list();
        transaction.commit();
        session.close();
        return ksiazki;
    }

    public List<Ksiazka> getKsiazki() {
        session();
        String hql = "From Ksiazka e Where e.czyWypozyczona = '0'";
        List ksiazki = session.createQuery(hql).list();
        transaction.commit();
        session.close();
        return ksiazki;

    }

    public void addKsiazka(Ksiazka ksiazka) {
        session();
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
        session();
        session.remove(ksiazka);
        transaction.commit();
        session.close();
    }

    public void doItKsiazka(Person person, Ksiazka ksiazka) {
        session();
        session.update(person);
        session.update(ksiazka);
        transaction.commit();
        session.close();
    }
}
