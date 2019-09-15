package com.denizturkmen.Client;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.denizturkmen.Entity.Employee;
import com.denizturkmen.Model.Adres;
import com.denizturkmen.Util.HibernateUtil;

public class SaveTest {
	public static void main(String[] args) {
			
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			createEmployee(session);
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		
		
	}

	private static void createEmployee(Session session) {
		session.beginTransaction();
		Integer id = (Integer) session.save(getEmployee());
		System.out.println("Employee is created with is::"+id);
		session.getTransaction().commit();
	}

	
	private static Employee getEmployee() {
		
		Employee employee = new Employee();
		employee.setEmployeeName("Deniz Türkmen");
		employee.setEmail("turkmen@hotmail.com");
		employee.setSalary(50000.0);
		employee.setDoj(new Date());
		

		Adres adress1 = new Adres();
		adress1.setCity("Ankara");
		adress1.setState("Eryaman");
		adress1.setStreet("Metrowall");
		adress1.setPincode(5466L);
		
		
		Adres adress2 = new Adres();
		adress2.setCity("Ankara1");
		adress2.setState("Eryaman1");
		adress2.setStreet("Metrowall1");
		adress2.setPincode(5466L);
		
		employee.getAdressList().add(adress1);
		employee.getAdressList().add(adress2);

		
		/*
		 * Adres officalAdress = new Adres(); officalAdress.setCity("İstanbul");
		 * officalAdress.setState("Üsküdar");
		 * officalAdress.setStreet("Bilmem ne Mahllesi"); officalAdress.setPincode(12L);
		 * 
		 * employee.setHomeAdres(homeAdress); employee.setOfficeAdres(officalAdress);
		 */
		
		
		return employee;
	}
	
}
