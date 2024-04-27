package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {
	public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Emp e1 = new Emp();
        Emp e2 = new Emp();
        
        e1.setEid(11);
        e1.setEname("Ahsan");
        
        e2.setEid(22);
        e2.setEname("Sana");
        
        Project p1 = new Project();
        Project p2 = new Project();
	
        p1.setPid(74839);
        p1.setProjectName("Lib management System");
        
        p2.setPid(45678);
        p2.setProjectName("ChatBot");
        
        List<Emp> l1 = new ArrayList<Emp>();
        l1.add(e1);
        l1.add(e2);
        
        List<Project> l2 = new ArrayList<Project>();
        l2.add(p1);
        l2.add(p2);
        
        e1.setProjects(l2);
        p2.setEmps(l1);
        
        e2.setProjects(l2);
        p1.setEmps(l1);
        
        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        
        s.save(e1);
        s.save(e2);
        s.save(p1);
        s.save(p2);
        
        tx.commit();
        s.close();
        factory.close();
        
	}
}
