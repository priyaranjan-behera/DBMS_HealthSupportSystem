CREATE PROCEDURE SSHARM17."AddPatientProc" (p_gender IN PATIENT.GENDER%TYPE,
										p_dob IN PATIENT.DOB%TYPE,
										p_ssn IN PATIENT.PATIENTSSN%TYPE)

AS
BEGIN
   INSERT INTO PATIENT (DOB, GENDER,PATIENTSSN)   
  		VALUES (p_gender, p_dob, p_ssn);
		COMMIT;
END;