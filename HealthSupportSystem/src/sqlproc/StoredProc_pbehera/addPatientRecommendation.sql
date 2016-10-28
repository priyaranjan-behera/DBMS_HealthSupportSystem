CREATE OR REPLACE PROCEDURE "AddPatientRecommendation" (
   "observationSpecName"   IN     VARCHAR2,
   "frequencyName"         IN     VARCHAR2,
   "threshold"             IN     INTEGER,
   "patientSSN"            IN     VARCHAR2,
   "recommendationId"         OUT INTEGER)
AS
BEGIN
   "AddGeneralRecommendation" ("observationSpecName",
                               "frequencyName",
                               "threshold",
                               "recommendationId");

   INSERT INTO RECOMMENDATIONFORPATIENT (RECOMMENDATIONID, PATIENTSSN)
        VALUES ("recommendationId", "patientSSN");
END;
/
