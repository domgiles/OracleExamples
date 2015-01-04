CREATE OR REPLACE PACKAGE SIMPLEPACKAGE
AS
  -- Package     : Simple Package Header
  -- Author      : Dominic Giles
  FUNCTION DoSomethingSimple(
      cust_id INTEGER)
    RETURN intarray;
END SIMPLEPACKAGE;