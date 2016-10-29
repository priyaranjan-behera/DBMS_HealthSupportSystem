CREATE OR REPLACE PROCEDURE "assignSecondarySupporter" (
   "patientSSN"          IN VARCHAR2,
   "hsSSN"               IN VARCHAR2,
   "authorizationDate"   IN DATE)
AS
	secondaryOccurence INTEGER;
BEGIN
  
   SELECT COUNT (*)
     INTO secondaryOccurence
     FROM PATIENTTOHEALTHSUPPORTER p
    WHERE p.PATIENTSSN = "patientSSN" AND p.PRIMARYSECONDARY = 'Secondary';

  
   IF secondaryOccurence > 0 THEN
      RAISE PROGRAM_ERROR;
   END IF;

   INSERT INTO PATIENTTOHEALTHSUPPORTER (HSSSN,
                                         PATIENTSSN,
                                         AUTHORIZATIONDATE,
                                         PRIMARYSECONDARY)
        VALUES ("hsSSN",
                "patientSSN",
                "authorizationDate",
                'Secondary');
END;
/
