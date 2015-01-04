create or replace PACKAGE BODY SIMPLEPACKAGE
AS
  -- Package     : Simple Package Body
  -- Author      : Dominic Giles
FUNCTION DOSOMETHINGSIMPLE(
    cust_id INTEGER)
  RETURN intarray
AS
  -- Function    : Simple function to initialise array set values to cust_id and
  --               return it
  simple_array intarray := intarray();
BEGIN
  simple_array.extend;
  simple_array(1) := cust_id;
  simple_array.extend;
  simple_array(2) := cust_id;
  simple_array.extend;
  simple_array(3) := cust_id;
  RETURN SIMPLE_ARRAY;
END DOSOMETHINGSIMPLE;
END SIMPLEPACKAGE;