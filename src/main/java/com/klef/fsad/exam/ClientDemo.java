package com.klef.fsad.exam;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;

public class ClientDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        // INSERT DATA
        Transaction tx = session.beginTransaction();

        Booking b1 = new Booking("Sanjay", "2026-05-01", "Confirmed", 1500);
        Booking b2 = new Booking("Ravi", "2026-05-02", "Pending", 2000);

        session.save(b1);
        session.save(b2);

        tx.commit();

        // HQL QUERY (View All Records)
        Query<Booking> q = session.createQuery("from Booking", Booking.class);
        List<Booking> list = q.list();

        System.out.println("Booking Records:");
        for(Booking b : list)
            System.out.println(b);

        session.close();
    }
}