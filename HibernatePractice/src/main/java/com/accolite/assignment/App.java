package com.accolite.assignment;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        //Employee object 1
    	Employee employee1 = new Employee();
    	employee1.setId(1);
    	employee1.setName("Nishant");
        
        //Laptop object 1
    	Laptop laptop1 = new Laptop();
    	laptop1.setId(1000);
    	laptop1.setBrandName("DELL");
    	laptop1.setPrice("54000");
    	
    	
        //new expense
    	Expenses expenses1 = new Expenses();
    	expenses1.setId(500);
    	expenses1.setType("Household");
    	expenses1.setCost(5420);
        

        //another expense
    	Expenses expenses2 = new Expenses();
    	expenses2.setId(501);
    	expenses2.setType("LoanInterest");
    	expenses2.setCost(4800);
        
        //assign laptop to employee
    	employee1.setLaptop(laptop1);
        
        //assign expense to employee
    	List<Expenses> list = new ArrayList<Expenses>();
    	list.add(expenses1);
    	list.add(expenses2);
    	
    	employee1.setExpenses(list);
        
        Configuration com = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(Expenses.class);
        SessionFactory sf = com.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tran = session.beginTransaction();
        session.save(employee1);
        session.save(laptop1);
        session.save(expenses1);
        session.save(expenses2);
        tran.commit();
        session.close();
    }
}