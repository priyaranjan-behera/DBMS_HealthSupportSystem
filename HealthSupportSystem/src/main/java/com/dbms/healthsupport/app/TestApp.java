package com.dbms.healthsupport.app;

import java.sql.SQLException;

import com.dbms.healthsupport.dao.PeopleDao;

public class TestApp {

	public TestApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			PeopleDao peopleDao = new PeopleDao();
			peopleDao.createTable();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
