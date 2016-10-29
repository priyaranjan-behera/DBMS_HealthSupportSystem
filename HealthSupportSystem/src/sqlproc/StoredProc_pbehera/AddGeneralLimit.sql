CREATE OR REPLACE PROCEDURE SSHARM17."AddGeneralLimit" (
   "observationSpecName"   IN     VARCHAR2,
   "metricName"         IN     VARCHAR2,
   "upperLimit"   IN     VARCHAR2,
   "lowerLimit"         IN     VARCHAR2,
   "limitId"         OUT INTEGER)
AS
BEGIN
	"limitId" := LIMITS_SEQ.NEXTVAL;
	
	INSERT INTO LIMITS  (LIMITID, LOWERLIMIT, UPPERLIMIT, METRICNAME, OBSERVATIONSPECNAME)
	   VALUES ("limitId", "lowerLimit", "upperLimit", "metricName", "observationSpecName"); 
END;