package com.infotech.client;

import java.util.List;

import org.hibernate.Session;

import com.infotech.entities.Department;
import com.infotech.util.HibernateUtil;

public class HibernateSelectAndSubselectFetchModeTest {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			List<Department> departments = session.createQuery("From Department", Department.class)
					.getResultList();
			System.out.println("Fetched Departments size:" + departments.size());

			for (Department department : departments) {
				System.out.println("Department ID:"+department.getId());
				System.out.println("Employees count:" + department.getEmployees().size());
			}
		}
	}
}
