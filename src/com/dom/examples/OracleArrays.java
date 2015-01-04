package com.dom.examples;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import java.util.Arrays;
import java.util.logging.Logger;

import oracle.jdbc.OracleArray;
import oracle.jdbc.pool.OracleDataSource;


public class OracleArrays {
    private static final Logger logger = Logger.getLogger(OracleArrays.class.getName());
    
    public OracleArrays(String username, String password, String connectString) throws Exception {
        
        OracleDataSource ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:@" + connectString);
        ods.setUser(username);
        ods.setPassword(password);
        logger.info("Attepting to connect to the database");
        try (
            // Connect to Oracle using new auto closure of resources functionality
            Connection conn = ods.getConnection();
            // Create a callable statement to invoke the function in the package
            // We need to give the function a customer_id and we'll get an array back
            CallableStatement cs = conn.prepareCall("{? = call simplepackage.dosomethingsimple(?)}");
             ) {
                logger.info("Connected to the database");
                // Register the array as the item returned from the function
                cs.registerOutParameter(1, Types.ARRAY, "INTARRAY");
                // Set the parameter (cust_id) of the function to be "1"
                cs.setInt(2, 1);
                // Execute the call to the database
                cs.executeUpdate();
                // Get the array returned by the function as an Oracle Array to simplfy binding
                OracleArray results = (OracleArray)cs.getArray(1);
                // Get an int array from the Oracle Array object
                int[] intArray = results.getIntArray();
                // Print the values in the array
                logger.info(Arrays.toString(intArray));
                logger.info("Got Array");
            } catch (SQLException se) {
                se.printStackTrace();   
            }
    }


    public static void main(String[] args) {
        try {
            @SuppressWarnings("unused")
            OracleArrays oracleArrays = new OracleArrays("soe", "soe", "//oracle12c2/soe");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
