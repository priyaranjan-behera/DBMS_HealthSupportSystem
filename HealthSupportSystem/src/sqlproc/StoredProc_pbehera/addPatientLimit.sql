CREATE OR REPLACE PROCEDURE SSHARM17."AddPatientLimit" (
   "observationSpecName"   IN     VARCHAR2,
   "metricName"         IN     VARCHAR2,
   "upperLimit"   IN     VARCHAR2,
   "lowerLimit"         IN     VARCHAR2,
   "patientSSN"           IN     VARCHAR2,
   "limitId"         OUT INTEGER)
AS
BEGIN
	"AddGeneralLimit"("observationSpecName", "metricName", "upperLimit", "lowerLimit", "limitId");
	INSERT INTO LIMITSFORPATIENT VALUES ("limitId", "patientSSN");
END;