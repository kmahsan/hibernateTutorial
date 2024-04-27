package com.tut.ProjectWithMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {
	public static void main(String[] args) {
        Configuration cfg = new Configuration();
        //Give the configuration file name to configure the connection to db.
        cfg.configure("hibernate.cfg.xml");
        
        //factory will contain the session to the db.
        SessionFactory factory = cfg.buildSessionFactory();
        
        Student student1 = new Student();
        
        student1.setId(1234);
        student1.setName("Ahsan");
        student1.setCity("Hyd");
        
        Certificate certificate = new Certificate();
        certificate.setCourse("Spring Boot");
        certificate.setDuration("2 months");
        student1.setCerti(certificate);
        
        Student student2 = new Student();
        
        student2.setId(5678);
        student2.setName("Sana");
        student2.setCity("KLPR");
        
        Certificate certificate1 = new Certificate();
        certificate1.setCourse("SQL");
        certificate1.setDuration("1.2 months");
        student2.setCerti(certificate1);
        
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        
        s.save(student1);
        s.save(student2);
        
        tx.commit();
        s.close();
        factory.close();
	}
}
