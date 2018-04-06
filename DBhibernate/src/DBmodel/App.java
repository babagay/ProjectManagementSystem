package DBmodel;

import main.java.ProjectManagement.DevelopersEntity;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

import static javax.persistence.PersistenceContextType.EXTENDED;

public class App {

    @PersistenceContext(unitName="crm") Session session1;
    @PersistenceContext (unitName="crm2", type=EXTENDED) Session extendedpc;
    @PersistenceUnit (unitName="crm") SessionFactory factory;

    private SessionFactory sessionFactory;

    public App()
    {
        try {
           // bootstrap();
           // boot();
            boot5();
        } catch ( Throwable e ) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        App app = new App();



//        Session session = app.sessionFactory.openSession();
//
//        session.beginTransaction();
//
//        String HQL = "from DevelopersEntity d where d.name like 'Alex%' ";
//        List<DevelopersEntity> result = session.createQuery( HQL, DevelopersEntity.class ).list();
//
//        session.getTransaction().commit();
//
//        session.close();
//
//        System.out.println(result);
    }

    /**
     * v5
     */
    Session boot5()
    {

        if ( sessionFactory == null ) {
            final Configuration configuration = new Configuration();
            //            configuration.addAnnotatedClass( User.class );
            //            configuration.addAnnotatedClass( Tool.class );
            //            configuration.addAnnotatedClass( Skill.class );

            sessionFactory = configuration.buildSessionFactory( new StandardServiceRegistryBuilder().build() );
        }
        return sessionFactory.openSession();

    }


    /**
     * v4
     */
    void boot4()
    {
        SessionFactory fa = new Configuration().configure().buildSessionFactory();

    }

    /**
     * v3
     */
    void boot()
    {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Check database version
        String sql = "select version()";

        String result = (String) session.createNativeQuery(sql).getSingleResult();
        System.out.println(result);

        session.getTransaction().commit();
        session.close();


        HibernateUtil.shutdown();
    }

    /**
     * bootstrap v1
     */
    void bootstrap()
    {
        final BootstrapServiceRegistry bootstrapServiceRegistry =
                new BootstrapServiceRegistryBuilder()
                        .enableAutoClose()
                        .applyIntegrator( MetadataExtractorIntegrator.INSTANCE )
                        .build();

        final StandardServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder(bootstrapServiceRegistry)
                        // .applySettings(properties())
                        .configure()
                        .build();
    }

    /**
     * bootstrap v2
     */
    protected void setUp()
    throws Exception
    {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        } catch ( Exception e ) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }
}