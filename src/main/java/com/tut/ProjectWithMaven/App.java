package com.tut.ProjectWithMaven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started...!" );
        
        Configuration cfg = new Configuration();
        //Give the configuration file name to configure the connection to db.
        cfg.configure("hibernate.cfg.xml");
        
        //factory will contain the session to the db.
        SessionFactory factory = cfg.buildSessionFactory();
        
        //Create Student object
    	Student st = new Student();
    	st.setId(112);
    	st.setName("Mohammed Sana");
    	st.setCity("Kollapur");
    	System.out.println(st);
    	
    	//Create object of address class
    	Address ad = new Address();
    	ad.setStreet("street1");
    	ad.setCity("Hyd");
    	ad.setOpen(true);
    	ad.setAddedDate(new Date());
    	ad.setX(12.345);
    	
//    	FileInputStream fis = new FileInputStream("src/main/java/Passport photo.jpg");
//    	byte[] data = new byte[fis.available()];
//    	fis.read(data);
//    	ad.setImg(data);
    	
    	//open a new session
    	Session session = factory.openSession();
    	
    	//Begin a new transaction
    	Transaction tx=session.beginTransaction();
    	
    	//Save the object
    	session.save(st);
    	session.save(ad);
    	
    	//Commit or close the transaction
    	tx.commit();
    	
    	//Close the session
    	session.close();
    	System.out.println("Done....!!!");
    }
}
