package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction tr = null;
		try(Session ses=HibernateUtil.getSesFactory().openSession()){
			tr =ses.beginTransaction();
			Employee e=new Employee();
			e.setName("Jothika");
			e.setEmail("jothika@gmail.com");
			Address a=new Address("Chettinad Tech","Trichy road","Karur","TN",639113);
			e.setAddress(a);
			ses.persist(e);
			a.setEmp(e);
			/*Query<Employee> qry=ses.createQuery("from Employee",Employee.class);
			List<Employee> li=qry.list();
			for(Employee e:li) {
				System.out.println(e.getEmpId()+"\t"+e.getName()+"\t"+e.getEmail());
				Address ad=e.getAddress();
				System.out.println("Address is : "+ad.getLine1()+ad.getLine2()+ad.getCity()+ad.getState());
			}*/
			tr.commit();
			ses.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}