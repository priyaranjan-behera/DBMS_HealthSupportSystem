CREATE OR REPLACE PROCEDURE SSHARM17."AddDiseaseLimit" (
   "observationSpecName"   IN     VARCHAR2,
   "metricName"         IN     VARCHAR2,
   "upperLimit"   IN     VARCHAR2,
   "lowerLimit"         IN     VARCHAR2,
   "diseaseName"           IN     VARCHAR2,
   "limitId"         OUT INTEGER)
AS
BEGIN
	"AddGeneralLimit"("observationSpecName", "metricName", "upperLimit", "lowerLimit", "limitId");
	INSERT INTO LIMITSFORDISEASE VALUES ("diseaseName", "limitId");
	 
END;