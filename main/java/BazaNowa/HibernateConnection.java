package BazaNowa;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnection {
    private SessionFactory sessionFactory;

    public HibernateConnection() {
    }

    public void connect()  {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public Session getSessiong() {
        return sessionFactory.openSession();
    }
}
