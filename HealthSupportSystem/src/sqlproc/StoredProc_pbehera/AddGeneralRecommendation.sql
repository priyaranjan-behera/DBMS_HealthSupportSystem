CREATE OR REPLACE PROCEDURE SSHARM17."AddGeneralRecommendation" (
   "observationSpecName"   IN     VARCHAR2,
   "frequencyName"         IN     VARCHAR2,
   "threshold"             IN     INTEGER DEFAULT 1,
   "recommendationId"         OUT INTEGER)
AS
BEGIN
	"recommendationId" := RECOMMENDATION_SEQ.NEXTVAL;
	INSERT INTO RECOMMENDATION  (RECOMMENDATIONID, FREQUENCYNAME, OBSERVATIONSPECNAME, THRESHOLD)
	   VALUES ("recommendationId", "frequencyName", "observationSpecName", "threshold"); 
END;