CREATE PROCEDURE SSHARM17."UpdatePatientProc" (p_gender IN PATIENT.GENDER%TYPE,
										p_dob IN PATIENT.DOB%TYPE,
										p_ssn IN PATIENT.PATIENTSSN%TYPE,p_firstname IN PEOPLE.FIRSTNAME%TYPE, p_lastname IN PEOPLE.LASTNAME%TYPE, p_address IN PEOPLE.ADDRESS%TYPE, p_password IN PEOPLE.PASSWORD%TYPE)
AS
BEGIN
   UPDATE PATIENT  SET GENDER = p_gender,DOB = p_dob WHERE PATIENTSSN = p_ssn;   
   "UpdatePeopleProc"(p_ssn, p_firstname, p_lastname, p_address, p_password);
   COMMIT;
END;