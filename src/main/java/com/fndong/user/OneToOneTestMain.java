package com.fndong.user;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fndong.user.HibernateUtil;

public class OneToOneTestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
 
        
        // 1) Save the record to two tables which using one to one
        UserDetails userDetail = new UserDetails();
        userDetail.setPoscode("57000");
        userDetail.setAddress("Kuala Lumpur, Malaysia");

        // 2) set the User Object the values.
        User user = new User();
        user.setEmail("fndong@gmail.com");
        user.setName("Fndong");
        user.setPassword("password");
        
        
        user.setUserDetails(userDetail);
        userDetail.setUser(user);
         
        session.save(user);
        /* 
         // 3. View the Record from one to one
        List<User> users = session.createQuery("from User").list();
        for (User userview : users) {
        	System.out.println(" User ID :  " + userview.getUserId());
        	System.out.println(" Email :  " + userview.getEmail());
        	System.out.println(" Name :  " + userview.getName());
        }*/
 
        session.getTransaction().commit();
        session.close();
	}

}
