package com.dxc.dao;
import java.util.List;

import com.dxc.model.employee;

public interface EmployeeDao {
	public int saveemployee(String name,int age,int salary);
	public List<employee> getAllemployee();
	public void updateEmployee(int id,int salary);
	public void deleteEmployee(int id);

}
