package com.canvass.data;
import com.canvass.data.model.*;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
public class HibernateDataStore implements DataStore {
	private SessionFactory sessionFactory;
	private ServiceRegistry serviceRegistry;
    private final Logger logger;

    @Inject
    public HibernateDataStore(Logger logger) {
        this.logger = logger;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        Configuration configuration = new Configuration();
        configuration.setNamingStrategy(new ImprovedNamingStrategy());
        configuration.addAnnotatedClass(Bill.class);
        configuration.addAnnotatedClass(BillVersion.class);
        configuration.addAnnotatedClass(Voter.class);
        configuration.addAnnotatedClass(WebSession.class);
        configuration.addAnnotatedClass(Town.class);
        configuration.addAnnotatedClass(VoteRecord.class);
        configuration.addAnnotatedClass(Account.class);
	    configuration.configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public void save(DataModel model) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(model);
		session.getTransaction().commit();
		session.close();
	}

    public void save(Bill bill, BillVersion billVersion) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        bill.setCurrentVersion(billVersion);
        billVersion.setParentBill(bill);
        session.saveOrUpdate(bill);
        session.saveOrUpdate(billVersion);
        session.getTransaction().commit();
        session.close();
    }

    public List<Bill> loadCurrentBills() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select bill from Bill bill");
        List<Bill> bills = query.list();
        session.close();
        return bills;
    }


    public Session createSession() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }

    public void closeSession(Session session) {
        session.getTransaction().commit();
        session.close();
    }


    public void flush() {
        Session session = sessionFactory.openSession();
        session.flush();
        session.close();
    }


    public Account loadAccount(Session session, String username) {
        Account account = (Account) session
                .createQuery("SELECT a FROM Account AS a WHERE username = :UNAME")
                .setString("UNAME", username)
                .uniqueResult();
        return account;
    }

    public int invalidateWebSessions(Session session, long accountId) {
        String sql = "UPDATE Session SET active = :Active WHERE account_id = :AccountId";
        Query query = session.createSQLQuery(sql)
                .addEntity(WebSession.class)
                .setParameter("Active", false)
                .setParameter("AccountId", accountId);
        int closed = query.executeUpdate();
        return closed;
    }



}
