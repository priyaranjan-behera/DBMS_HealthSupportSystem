CREATE OR REPLACE PROCEDURE "AddObservationSpecAndMetric" (
   obsspecname   IN OBSERVATIONSPEC.OBSERVATIONSPECNAME%TYPE,
   obsdesc       IN OBSERVATIONSPEC.DESCRIPTION%TYPE,
   metriclist    IN "Metric")
AS
BEGIN
   INSERT INTO OBSERVATIONSPEC (OBSERVATIONSPECNAME, DESCRIPTION)
        VALUES (obsspecname, obsdesc);

   FOR elem IN 1 .. metriclist.COUNT
   LOOP
      INSERT INTO METRICINOBSSPEC (METRICNAME, OBSERVATIONSPECNAME)
           VALUES (metriclist (elem), obsspecname);
   END LOOP;
END;
/
