CREATE PROCEDURE SSHARM17."UpdatePeopleProc" (p_ssn           IN PEOPLE.SSN%TYPE,
                                           p_FirstName   IN PEOPLE.FIRSTNAME%TYPE,
                                           p_LastName    IN PEOPLE.LASTNAME%TYPE,
                                           p_Address     IN PEOPLE.ADDRESS%TYPE,
                                           p_Password    IN PEOPLE.PASSWORD%TYPE)
AS
BEGIN
   UPDATE PEOPLE 
      SET FIRSTNAME = p_FirstName,LASTNAME = p_LastName,ADDRESS = p_Address,PASSWORD = p_password
    WHERE SSN = p_ssn;
END;