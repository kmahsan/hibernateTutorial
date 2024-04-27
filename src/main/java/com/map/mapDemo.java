package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class mapDemo {
	public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Question question = new Question();
        question.setQuestionId(12);
        question.setQuestion("What is java");
        
        Answer answer = new Answer();
        answer.setAnswerId(99);
        answer.setAnswer("Java is a Programming Language");
        answer.setQuestion(question);
        
        Answer answer1 = new Answer();
        answer1.setAnswerId(100);
        answer1.setAnswer("Java is used to create softwares.");
        answer1.setQuestion(question);
        
        Answer answer2 = new Answer();
        answer2.setAnswerId(101);
        answer2.setAnswer("Java has many frameworks.");
        answer2.setQuestion(question);
        
		/*
		 * List<Answer> list = new ArrayList<Answer>();
		 * 
		 * list.add(answer); list.add(answer1); list.add(answer2);
		 * 
		 * question.setAnswers(list);
		 */
        

        Session session = factory.openSession();
    	
    	Transaction tx=session.beginTransaction();
    	
    	session.save(question);
    	session.save(answer);
    	session.save(answer1);
    	session.save(answer2);
    	
    	tx.commit();
    	
		/*
		 * //Fetching..... Question Qnew = (Question)session.get(Question.class, 12);
		 * System.out.println(Qnew.getQuestion());
		 * System.out.println(Qnew.getAnswer().getAnswer());
		 */
    	
    	session.close();
    	factory.close();
        
        
	}
}
