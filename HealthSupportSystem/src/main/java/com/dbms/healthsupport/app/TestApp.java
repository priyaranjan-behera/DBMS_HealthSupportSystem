package com.dbms.healthsupport.app;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.dbms.healthsupport.dao.PatientDao;
import com.dbms.healthsupport.dao.PeopleDao;
import com.dbms.healthsupport.domain.Patient;
import com.dbms.healthsupport.domain.People;

public class TestApp {

	public TestApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception{
		//testPeople();
		testPatient();
			}


static void testPatient() throws Exception
{

	// TODO Auto-generated method stub
	PatientDao patientDao = new PatientDao();
	PeopleDao peopleDao = new PeopleDao();
	
	People people = peopleDao.getDataById(new Long(1));
	Patient patient = new Patient(people, java.sql.Date.valueOf("1984-05-26"), "Male");
	//patientDao.insertRow(patient);

	people = peopleDao.getDataById(new Long(2));
	patient = new Patient(people, java.sql.Date.valueOf("1989-04-19"), "Male");
	//patientDao.insertRow(patient);

	people = peopleDao.getDataById(new Long(3));
	patient = new Patient(people, java.sql.Date.valueOf("1990-12-25"), "Female");
	//patientDao.insertRow(patient);
	
	people = peopleDao.getDataById(new Long(4));
	patient = new Patient(people, java.sql.Date.valueOf("1992-06-15"), "Female");
	//patientDao.insertRow(patient);
	
	System.out.println(patientDao.getDataById(new Long(1)).toString());
	
}

static void testPeople()
{
	try {
		PeopleDao peopleDao = new PeopleDao();
		People people = new People(new Long(1), "Sheldon", "Cooper", "2500 Sacramento", "password");
		//peopleDao.insertRow(people);
		people = new People(new Long(2), "Leonard", "Hofstader", "2500 Sacramento", "password");
		//peopleDao.insertRow(people);
		people = new People(new Long(3), "Penny", "Hofstader", "2500 Sacramento", "password");
		//peopleDao.insertRow(people);
		people = new People(new Long(4), "Ammy", "Farrahfowler", "2500 Sacramento", "password");
		peopleDao.insertRow(people);
		System.out.println(peopleDao.getDataById(new Long(1)).toString());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


}