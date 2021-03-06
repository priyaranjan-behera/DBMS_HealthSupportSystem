CREATE OR REPLACE PROCEDURE "AssignDiseaseToPatient" (
   p_ssn    IN PATIENT.PATIENTSSN%TYPE,
   d_name   IN DISEASES.DISEASENAME%TYPE)
AS
BEGIN
   DECLARE
      any_rows_found   INTEGER;
   BEGIN
      

      DELETE FROM WELLPATIENT
            WHERE PATIENTSSN = p_ssn;

      SELECT COUNT (*)
        INTO any_rows_found
        FROM SICKPATIENT
       WHERE PATIENTSSN = p_ssn;

      IF any_rows_found <= 0
      THEN
         INSERT INTO SICKPATIENT
              VALUES (p_ssn);
      END IF;
	  
	  INSERT INTO SICKHASMAJORDISEASE (PATIENTSSN, DISEASENAME)
           VALUES (p_ssn, d_name);
   END;

   COMMIT;
END;
/
