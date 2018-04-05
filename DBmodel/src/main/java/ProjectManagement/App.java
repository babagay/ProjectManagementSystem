package main.java.ProjectManagement;


import main.java.ProjectManagement.Util.HibernateUtil;
import org.hibernate.Cache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

//import static main.java.ProjectManagement.Util.HibernateUtil.getSessionFactory;


/**
 * @author imssbora
 */
public class App {

    static SessionFactory sessionFactory;

    public static void main(String[] args)
    throws Exception
    {

        App app = new App();

        app.setUp();

        //App.sessionFactory.openSession();


// https://docs.jboss.org/hibernate/orm/5.2/quickstart/html_single/#_the_hibernate_modules_artifacts
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.save( new Event( "Our very first event!", new Date() ) );
//        session.save( new Event( "A follow up event", new Date() ) );
//        session.getTransaction().commit();
//        session.close();





        /**
        // 1
        Session session = getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.save( new Object() );
        // tr.commit
        session.close();

        // 2 HQL
        Session session = getSessionFactory().openSession();
        String hql = "from Cat c HWERE c.name like '%vasya%'";
        session.createQuery( hql, ...class ).list();
        session.close();

        // 3 Criteria

        // 4 SQL
        session.createNativeQuery(  )
                */


//        Session session = getSessionFactory().openSession();
//        session.beginTransaction();
//
//        // Check database version
//        String sql = "select version()";
//
//        String result = (String) session.createNativeQuery(sql).getSingleResult();
//        System.out.println(result);
//
//        session.getTransaction().commit();
//        session.close();
//
//
//        HibernateUtil.shutdown();
    }

    protected void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }
}