package com.dxc.dao;

import java.util.List;

import org.hibernate.Session;

import com.dxc.model.employee;
import com.dxc.util.HibernateUtil;


public class EmployeeDaoImp implements EmployeeDao{

	public int saveemployee(String name, int age, int salary) {
		// TODO Auto-generated method stub
		employee emp = new employee();
		emp.setName(name);
		emp.setAge(age);
		emp.setSalary(salary);
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		int id = (Integer)session.save(emp);
		session.getTransaction().commit();
		session.close();
		return id;
	}
	
	public List<employee> getAllemployee() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<employee> emps = (List<employee>)session.createQuery("FROM employee e ORDER BY e.name ASC").list();
		
		session.getTransaction().commit();
		session.close();
		
		return emps;
	}

	public void updateEmployee(int id,int salary) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		employee emp = (employee) session.get(employee.class,id);
		emp.setSalary(salary);
		//session.update(student);//no need to call update manually as it will be updated automatically on transaction close
		session.getTransaction().commit();
		session.close();
		
	}

	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		employee emp = (employee)session.get(employee.class,id);
		session.delete(emp);
		session.getTransaction().commit();
		session.close();
		
	}

	
	

}
