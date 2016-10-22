package com.dbms.healthsupport.app;

import java.sql.SQLException;

import com.dbms.healthsupport.dao.PeopleDao;
import com.dbms.healthsupport.domain.People;

public class TestApp {

	public TestApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			People people = new People(new Long(123), "Akshay", "Nayak", "512TartanCircle", "anayakv");
			PeopleDao peopleDao = new PeopleDao();
			peopleDao.insertRow(people);
			System.out.println(peopleDao.getDataById(new Long(123)).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
