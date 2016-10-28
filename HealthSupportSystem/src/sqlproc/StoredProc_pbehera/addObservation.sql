CREATE OR REPLACE PROCEDURE "AddObservation" (
   "observationTime"       IN     DATE,
   "recordedTime"          IN     DATE,
   "patientSSN"            IN     VARCHAR2,
   "observationSpecName"   IN     VARCHAR2,
   "metricDetails"         IN     "ObservationMetrics",
   "observationId"            OUT INTEGER)
AS
   total   INTEGER;
BEGIN
   "observationId" := OBSERVATION_SEQ.NEXTVAL;

   INSERT INTO OBSERVATION (OBSERVATIONID,
                            OBSERVATIONTIME,
                            RECORDEDTIME,
                            PATIENTSSN)
        VALUES ("observationId",
                "observationTime",
                "recordedTime",
                "patientSSN");

   total := "metricDetails".COUNT;

   FOR i IN 1 .. total
   LOOP
      INSERT INTO OBSERVATIONDETAILS (OBSERVATIONID,
                                      METRICNAME,
                                      OBSERVATIONSPECNAME,
                                      OBSERVATIONVALUE)
           VALUES ("observationId",
                   "metricDetails" (i).metricName,
                   "observationSpecName",
                   "metricDetails" (i).metricName);
   END LOOP;
END;
