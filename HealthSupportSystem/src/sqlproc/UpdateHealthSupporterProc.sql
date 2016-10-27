CREATE PROCEDURE SSHARM17."UpdateHealthSupporterProc" (p_ssn IN HEALTHSUPPORTER.SSN%TYPE,
hs_contactnumber IN HEALTHSUPPORTER.CONTACTNUMBER%TYPE, p_firstname IN PEOPLE.FIRSTNAME%TYPE, p_lastname IN PEOPLE.LASTNAME%TYPE, p_address IN PEOPLE.ADDRESS%TYPE, p_password IN PEOPLE.PASSWORD%TYPE)
AS
BEGIN
   UPDATE HEALTHSUPPORTER SET CONTACTNUMBER = p_ssn WHERE SSN = p_ssn;   
   "UpdatePeopleProc"(p_ssn, p_firstname, p_lastname, p_address, p_password);
   COMMIT;
END;