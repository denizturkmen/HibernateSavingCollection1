package com.denizturkmen.Client;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.denizturkmen.Entity.Employee;
import com.denizturkmen.Util.HibernateUtil;

public class FetchClientData {
	public static void main(String[] args) {
		Employee employee = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			employee = session.get(Employee.class, 2);
			System.out.println(employee);
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		
		if(employee != null) {
			employee.getAdressList().forEach(System.out::println);
		}
		else {
			System.out.println("Böyle Employee Yok");
		}
		
	
		
		//fetch type lazy ihtiyacı olduğunda çağrıırr
		//eager nesne yüklendiğin ilişki olduığu gelir
	}

}
