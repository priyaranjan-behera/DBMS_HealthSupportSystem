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
			PeopleDao peopleDao = new PeopleDao();
			People people = new People(new Long(323), "Akshay", "Nayak", "512TartanCircle", "anayakv");
			peopleDao.insertRow(people);
			people = new People(new Long(423), "Akshay", "Nayak", "512TartanCircle", "anayakv");
			peopleDao.insertRow(people);
			people = new People(new Long(53), "Akshay", "Nayak", "512TartanCircle", "anayakv");
			peopleDao.insertRow(people);
			System.out.println(peopleDao.getDataById(new Long(123)).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
