CREATE OR REPLACE PROCEDURE "deletePrimarySupporter" (
   "patientSSN"   IN VARCHAR2,
   "hsSSN"        IN VARCHAR2)
AS
	sickOccurence INTEGER;
	secondaryOccurence INTEGER;
BEGIN
	
	SELECT count(*)
	  INTO sickOccurence
	  FROM SICKPATIENT s
	 WHERE s.PATIENTSSN="patientSSN";
	
   SELECT COUNT(*) INTO secondaryOccurence
         FROM PATIENTTOHEALTHSUPPORTER p
        WHERE     p.PATIENTSSN = "patientSSN"
              AND p.PRIMARYSECONDARY = 'Secondary';


   IF sickOccurence > 0
   THEN
      IF secondaryOccurence = 0
      THEN
         RAISE PROGRAM_ERROR;
      END IF;
   END IF;

   DELETE FROM PATIENTTOHEALTHSUPPORTER
         WHERE PATIENTSSN = "patientSSN" AND PRIMARYSECONDARY = 'Primary';


   IF secondaryOccurence > 0
   THEN
      UPDATE PATIENTTOHEALTHSUPPORTER
         SET PRIMARYSECONDARY = 'Primary'
       WHERE PATIENTSSN = "patientSSN" AND PRIMARYSECONDARY = 'Secondary';
   END IF;
END;
/
