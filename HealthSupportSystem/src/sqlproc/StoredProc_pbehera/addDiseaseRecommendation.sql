CREATE OR REPLACE PROCEDURE SSHARM17."AddDiseaseRecommendation" (
   "observationSpecName"   IN     VARCHAR2,
   "frequencyName"         IN     VARCHAR2,
   "threshold"             IN     INTEGER,
   "diseaseName"           IN     VARCHAR2,
   "recommendationId"         OUT INTEGER)
AS
BEGIN
   "AddGeneralRecommendation"("observationSpecName", "frequencyName", "threshold", "recommendationId");
	INSERT INTO RECOMMENDATIONFORDISEASE VALUES ("diseaseName", "recommendationId");
END;