CREATE PROCEDURE SSHARM17."AddPeopleProc" (p_ssn           IN PEOPLE.SSN%TYPE,
                                           p_FirstName   IN PEOPLE.FIRSTNAME%TYPE,
                                           p_LastName    IN PEOPLE.LASTNAME%TYPE,
                                           p_Address     IN PEOPLE.ADDRESS%TYPE,
                                           p_Password    IN PEOPLE.PASSWORD%TYPE
											)
IS
BEGIN
   INSERT INTO PEOPLE  (SSN,FIRSTNAME, LASTNAME, ADDRESS, PASSWORD)
      VALUES (p_ssn, p_FirstName, p_LastName, p_Address, p_Password);
	COMMIT;
END;

