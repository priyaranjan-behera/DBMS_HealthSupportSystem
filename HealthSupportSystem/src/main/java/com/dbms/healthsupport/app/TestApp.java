package com.dbms.healthsupport.app;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.dbms.healthsupport.dao.DiseasesDao;
import com.dbms.healthsupport.dao.FrequencyDao;
import com.dbms.healthsupport.dao.HealthSupporterDao;
import com.dbms.healthsupport.dao.PatientDao;
import com.dbms.healthsupport.dao.PeopleDao;
import com.dbms.healthsupport.dao.SickPatientHasMajorDiseaseDao;
import com.dbms.healthsupport.dao.WellPatientHasMinorDiseaseDao;
import com.dbms.healthsupport.domain.Diseases;
import com.dbms.healthsupport.domain.Frequency;
import com.dbms.healthsupport.domain.HealthSupporter;
import com.dbms.healthsupport.domain.Patient;
import com.dbms.healthsupport.domain.People;
import com.dbms.healthsupport.domain.WellPatient;

public class TestApp {

	public TestApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception{
		//testPeople();
		//testPatient();
		//testDisease();
		//testFrequency();
		//testHealthSupporter();
		//testLimits();
		//testSickPatientHasMajorDisease();
		testWellPatientHasMinorDisease();
	}
	

static void testHealthSupporter() throws Exception
{
	HealthSupporterDao healthSupporterDao = new HealthSupporterDao();
	
	PeopleDao peopleDao = new PeopleDao();
	
	People people = peopleDao.getDataById(new Long(1));
	HealthSupporter healthSupporter = new HealthSupporter(people, new Long("9842158165"));
	
	//healthSupporterDao.insertRow(healthSupporter);
	healthSupporter = healthSupporterDao.getDataById(new Long(1));
	
	System.out.println("Name: "+ healthSupporter.getFirstName() +"Contact Number: " + healthSupporter.getContactNumber());

}
	
static void testFrequency() throws Exception
{
	FrequencyDao frequencyDao = new FrequencyDao();
	
	Frequency frequency = new Frequency("Weekly", 7);
	//frequencyDao.insertRow(frequency);
	
	frequency = new Frequency("Daily", 1);
	//frequencyDao.insertRow(frequency);
	
	System.out.println(frequencyDao.getDataById("Weekly").getFrequencyName());
	System.out.println(frequencyDao.getDataById("Weekly").getDuration());
}


static void testDisease() throws Exception
{
	DiseasesDao diseasesDao = new DiseasesDao();

	Diseases disease = new Diseases("Heart Disease","Heart Disease Description");
	//diseasesDao.insertRow(disease);
	
	disease = new Diseases("HIV","HIV Description");
	//diseasesDao.insertRow(disease);
	
	System.out.println(diseasesDao.getDataById("HIV").toString());
	
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

static void testSickPatientHasMajorDisease() { 
	
	try {
		
		SickPatientHasMajorDiseaseDao sickPatientHasMajorDiseaseDao = new SickPatientHasMajorDiseaseDao();

		PeopleDao peopleDao = new PeopleDao();
		
		People people = peopleDao.getDataById(new Long(1));
		Patient patient = new Patient(people, java.sql.Date.valueOf("1984-05-26"), "Male");
		
		
		Diseases disease = new Diseases("HIV", "SLSLSLLSLSLSLLSLSLLSLSLLSLS");
		
		sickPatientHasMajorDiseaseDao.addDiseaseDiagnoses(patient, disease);
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

static void testWellPatientHasMinorDisease() {
	
     try {
		
    	WellPatientHasMinorDiseaseDao wellPatientHasMinorDiseaseDao = new WellPatientHasMinorDiseaseDao();

 		PeopleDao peopleDao = new PeopleDao();
 		
 		People people = peopleDao.getDataById(new Long(1));
 		Patient patient = new Patient(people, java.sql.Date.valueOf("1984-05-26"), "Male");
 		WellPatient wellPatient = new WellPatient(patient);
 		
 		Diseases disease = new Diseases("SICK", "SLSLSLLSLSLSLLSLSLLSLSLLSLS");
 		
 		wellPatientHasMinorDiseaseDao.addDiseaseDiagnoses(wellPatient, disease);
 		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}

//TODO
//Secondary list to single
//SSN long, String
//Exceptions

}