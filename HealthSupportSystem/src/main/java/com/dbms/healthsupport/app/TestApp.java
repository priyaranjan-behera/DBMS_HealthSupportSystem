package com.dbms.healthsupport.app;

import java.util.ArrayList;
import java.util.List;

import com.dbms.healthsupport.dao.DiseasesDao;
import com.dbms.healthsupport.dao.FrequencyDao;
import com.dbms.healthsupport.dao.HealthSupporterDao;
import com.dbms.healthsupport.dao.ObservationSpecDao;

import com.dbms.healthsupport.dao.HealthSupporterDetailsDao;
import com.dbms.healthsupport.dao.LimitsDao;
import com.dbms.healthsupport.dao.ObservationDao;
import com.dbms.healthsupport.dao.PatientDao;
import com.dbms.healthsupport.dao.PeopleDao;
import com.dbms.healthsupport.dao.RecommendationDao;
import com.dbms.healthsupport.dao.SickPatientHasMajorDiseaseDao;
import com.dbms.healthsupport.dao.WellPatientHasMinorDiseaseDao;
import com.dbms.healthsupport.domain.Diseases;
import com.dbms.healthsupport.domain.Frequency;
import com.dbms.healthsupport.domain.HealthSupporter;
import com.dbms.healthsupport.domain.HealthSupporterDetails;
import com.dbms.healthsupport.domain.Limits;
import com.dbms.healthsupport.domain.Observation;
import com.dbms.healthsupport.domain.ObservationMetricDetails;
import com.dbms.healthsupport.domain.ObservationSpec;
import com.dbms.healthsupport.domain.Patient;
import com.dbms.healthsupport.domain.People;
import com.dbms.healthsupport.domain.Recommendation;
import com.dbms.healthsupport.domain.WellPatient;

public class TestApp {

	public TestApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		 //testPeople();
		// testPatient();
		// testDisease();
		// testFrequency();
		//testHealthSupporter();
		//testObservationSpec();
		//testObservation();
		// testObservationSpec();
		testObservation();
		// testSickPatientHasMajorDisease();
		// testWellPatientHasMinorDisease();
		//testAllocateHSToPatient();
		//testPersonalizedLimits();
		// testRecommendation();
		// testLimit();
		//testUpdatePeople();
		//testUpdateHealthSupporter();
		//testUpdatePatient();
		//testAssignDiseaseToPatient();
		testAssignPrimaryHealthSupporter();
		// testUpdatePatient();
	}

	static void testAssignDiseaseToPatient() throws Exception {
		
		PatientDao patientDao = new PatientDao();
		DiseasesDao diseasesDao = new DiseasesDao();
		
		Patient patient = patientDao.getDataById("P3");
		Diseases diseases = diseasesDao.getDataById("HIV");
		
		patientDao.AssignDiseaseToPatient(patient, diseases);
	}
	
	static void testAssignPrimaryHealthSupporter() throws Exception {
		
		PatientDao patientDao = new PatientDao();
		HealthSupporterDetails healthSupporterDetails = new HealthSupporterDetails("P4","P3", java.sql.Date.valueOf("2016-10-20"));
		
		patientDao.AssignPrimaryHealthSupporter(healthSupporterDetails);
		
	}
	static void testObservation() throws Exception {
		ObservationDao observationDao = new ObservationDao();
		ObservationSpecDao observationSpecDao = new ObservationSpecDao();
		ObservationSpec observationSpec = observationSpecDao.getDataById("Blood Pressure");

		List<ObservationMetricDetails> metricDetails = new ArrayList<ObservationMetricDetails>();

		for (String metric : observationSpec.getMetrics()) {
			metricDetails.add(new ObservationMetricDetails(metric, "110"));
		}

		Observation observation = new Observation(1, java.sql.Date.valueOf("2016-10-20"),
				java.sql.Date.valueOf("2016-10-21"), "P2", observationSpec.getObservationName(), metricDetails);

		observation = observationDao.insertObservation(observation);
		
		System.out.println("Observation Record Time:" + observation.getObservationTime().toString());
		for(ObservationMetricDetails metricDetail: observation.getMetricDetails())
		{
			System.out.println("Metric: " + metricDetail.getMetricName() + " Value: " + metricDetail.getMetricValue());
		}

	}

	static void testDisease() throws Exception {
		DiseasesDao diseasesDao = new DiseasesDao();

		Diseases disease = new Diseases("Heart Disease", "Heart Disease Description");
		// diseasesDao.insertRow(disease);

		disease = new Diseases("HIV", "HIV Description");
		// diseasesDao.insertRow(disease);

		System.out.println(diseasesDao.getDataById("HIV").toString());

	}

	static void testFrequency() throws Exception {
		FrequencyDao frequencyDao = new FrequencyDao();

		Frequency frequency = new Frequency("Weekly", 7);
		// frequencyDao.insertRow(frequency);

		frequency = new Frequency("Daily", 1);
		// frequencyDao.insertRow(frequency);

		System.out.println(frequencyDao.getDataById("Weekly").getFrequencyName());
		System.out.println(frequencyDao.getDataById("Weekly").getDuration());
	}

	static void testObservationSpec() throws Exception {
		ObservationSpecDao observationSpecDao = new ObservationSpecDao();
		List<String> metrics = new ArrayList<String>();

		metrics.add("sys");
		metrics.add("dia");

		ObservationSpec observationSpec = new ObservationSpec("Blood Pres", "Blood Pres Desc", metrics);

		observationSpecDao.insertData(observationSpec);

		//observationSpec = observationSpecDao.getDataById("Blood Pressure");

		//System.out.println("Observation Spec: " + observationSpec.getObservationName());

	}

	static void testHealthSupporter() throws Exception {
		HealthSupporterDao healthSupporterDao = new HealthSupporterDao();

		PeopleDao peopleDao = new PeopleDao();

		People people = peopleDao.getDataById("6");
		HealthSupporter healthSupporter = new HealthSupporter(people, new Long("984215"));
		healthSupporterDao.updateRow(healthSupporter);
		 //healthSupporterDao.insertRow(healthSupporter);
		//healthSupporter = healthSupporterDao.getDataById(new Long(1));

		//System.out.println(
			//	"Name: " + healthSupporter.getFirstName() + "Contact Number: " + healthSupporter.getContactNumber());

		//testUpdatePeople();
		//testUpdateHealthSupporter();
	}

	static void testUpdatePeople() throws Exception {

		PeopleDao peopleDao = new PeopleDao();

		People people = peopleDao.getDataById("6");
		people.setAddress("avent ferry");
		people.setFirstName("viv");
		people.setLastName("E");
		people.setPassword("password");

		peopleDao.updatePeopleRow(people);

	}

	static void testUpdateHealthSupporter() throws Exception {
		HealthSupporterDao healthsupporterDao = new HealthSupporterDao();
		HealthSupporter healthsupporter = healthsupporterDao.getDataById("6");
		healthsupporter.setContactNumber(new Long(1435));
		healthsupporter.setAddress("ferry");
		healthsupporter.setFirstName("ram");
		healthsupporter.setLastName("shyam");
		healthsupporter.setPassword("pass");

		healthsupporterDao.updateRow(healthsupporter);
	}
	
	static void testUpdatePatient() throws Exception {
		
		PatientDao patientDao = new PatientDao();
		Patient patient = patientDao.getDataById("6");
		patient.setGender("female");
		patient.setDob(java.sql.Date.valueOf("1999-01-01"));
		patient.setAddress("ferry");
		patient.setFirstName("ram");
		patient.setLastName("shyam");
		patient.setPassword("pass");
		
		patientDao.updateRow(patient);
		
	}
	static void testPatient() throws Exception {

		// TODO Auto-generated method stub
		PatientDao patientDao = new PatientDao();
		PeopleDao peopleDao = new PeopleDao();

		People people = peopleDao.getDataById("6");
		Patient patient = new Patient(people, java.sql.Date.valueOf("1984-05-26"), "Male");
		//patientDao.insertRow(patient);

		System.out.println(patientDao.getDataById("6").getFirstName());
		/*
		people = peopleDao.getDataById("2");
		patient = new Patient(people, java.sql.Date.valueOf("1989-04-19"), "Male");
		// patientDao.insertRow(patient);

		people = peopleDao.getDataById("3");
		patient = new Patient(people, java.sql.Date.valueOf("1990-12-25"), "Female");
		// patientDao.insertRow(patient);

		people = peopleDao.getDataById("4");
		patient = new Patient(people, java.sql.Date.valueOf("1992-06-15"), "Female");
		// patientDao.insertRow(patient);

		System.out.println(patientDao.getDataById("1").toString());
		*/
	}

	static void testPeople() {
		try {
			PeopleDao peopleDao = new PeopleDao();
			People people = new People("7", "Sheldon", "Cooper", "2500 Sacramento", "password");
			peopleDao.insertRow(people);
			people = new People("2", "Leonard", "Hofstader", "2500 Sacramento", "password");
			// peopleDao.insertRow(people);
			people = new People("3", "Penny", "Hofstader", "2500 Sacramento", "password");
			// peopleDao.insertRow(people);
			people = new People("4", "Ammy", "Farrahfowler", "2500 Sacramento", "password");
			// peopleDao.insertRow(people);
			//System.out.println(peopleDao.getDataById(new Long(1)).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void testSickPatientHasMajorDisease() {

		try {

			SickPatientHasMajorDiseaseDao sickPatientHasMajorDiseaseDao = new SickPatientHasMajorDiseaseDao();

			PeopleDao peopleDao = new PeopleDao();

			People people = peopleDao.getDataById("1");
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

			People people = peopleDao.getDataById("1");
			Patient patient = new Patient(people, java.sql.Date.valueOf("1984-05-26"), "Male");
			WellPatient wellPatient = new WellPatient(patient);

			Diseases disease = new Diseases("Heart Disease", "SLSLSLLSLSLSLLSLSLLSLSLLSLS");

			wellPatientHasMinorDiseaseDao.addDiseaseDiagnoses(wellPatient, disease);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void testAllocateHSToPatient() {
		try {
			HealthSupporterDetailsDao hsddao = new HealthSupporterDetailsDao();
			hsddao.assignHS("2", "1", java.sql.Date.valueOf("1984-05-26"), true);
			hsddao.assignHS("1", "1", java.sql.Date.valueOf("1984-05-26"), true);
			hsddao.assignHS("2", "3", java.sql.Date.valueOf("1984-05-26"), false);
			hsddao.removePrimaryHS("2", "1");
			// hsddao.removePrimaryHS(1, 5);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void testPersonalizedLimits() {
		
		try {
			Limits limits = new Limits(11212, "1", "10", "2", "3");

			PeopleDao peopleDao = new PeopleDao();
			People people = peopleDao.getDataById("1");
			
			LimitsDao limitDao = new LimitsDao();
			limitDao.personalizedLimit(limits, people);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	static void testLimit() throws Exception {
		 ObservationSpecDao observationSpecDao = new ObservationSpecDao();
		 LimitsDao limitsDao = new LimitsDao();
		 		
		 ObservationSpec observationSpec = observationSpecDao.getDataById("Blood Pressure");
		 
		 		
		 for(String metric: observationSpec.getMetrics())
		 {
		 Limits limits = new Limits(0, "120", "180", metric,observationSpec.getObservationName());
		 Limits newLimit = limitsDao.insertGeneralLimit(limits);
		 System.out.println("Created New General Limit: " + newLimit.getLimitID());
		 }
		 
		 for(String metric: observationSpec.getMetrics())
		 {
		 Limits limits = new Limits(0, "120", "180", metric,observationSpec.getObservationName());
		 Diseases diseases = new DiseasesDao().getDataById("HIV");
		 Limits newLimit = limitsDao.insertDiseaseLimit(limits, diseases);
		 System.out.println("Created New General Limit: " + newLimit.getLimitID());
		 }
		 
		 for(String metric: observationSpec.getMetrics())
		 {
		 Limits limits = new Limits(0, "120", "180", metric,observationSpec.getObservationName());
		 Patient patient = new PatientDao().getDataById("P2");
		 Limits newLimit = limitsDao.insertPatientLimit(limits, patient);
		 System.out.println("Created New General Limit: " + newLimit.getLimitID());
		 }
		
		}
	
	static void testRecommendation() throws Exception {
	    RecommendationDao recommendationDao = new RecommendationDao();
		
    	Recommendation recommendation = new Recommendation(1, "Weekly", 2, "Blood Pressure");
    	recommendationDao.insertGeneralRecommendation(recommendation);
    	Diseases diseases = new DiseasesDao().getDataById("HIV");
    	System.out.println("Disease Name: " + diseases.getDisName());
    	recommendationDao.insertDiseaseRecommendation(recommendation,diseases);
    	Patient patient = new PatientDao().getDataById("P2");
    	System.out.println("PatientSSN: " + patient.getSsn());
    	recommendationDao.insertPatientRecommendation(recommendation, patient);
  
 
	}


}
