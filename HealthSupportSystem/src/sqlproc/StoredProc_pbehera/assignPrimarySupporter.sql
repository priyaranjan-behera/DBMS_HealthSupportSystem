CREATE OR REPLACE PROCEDURE SSHARM17."assignPrimarySupporter" (
   "patientSSN"          IN VARCHAR2,
   "hsSSN"               IN VARCHAR2,
   "authorizationDate"   IN DATE)
AS
	primaryOccurence INTEGER;
BEGIN

   SELECT COUNT (*)
     INTO primaryOccurence
     FROM PATIENTTOHEALTHSUPPORTER p
    WHERE p.PATIENTSSN = "patientSSN" AND p.PRIMARYSECONDARY = 'Primary';
	
	
   IF primaryOccurence > 0 THEN
      RAISE PROGRAM_ERROR;
   END IF;

   INSERT INTO PATIENTTOHEALTHSUPPORTER (HSSSN,
                                         PATIENTSSN,
                                         AUTHORIZATIONDATE,
                                         PRIMARYSECONDARY)
        VALUES ("hsSSN",
                "patientSSN",
                "authorizationDate",
                'Primary');
END;