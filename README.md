OracleExamples
==============

Simple Oracle Code Examples typically releated to development.

EXAMPLE 1/ : 

Simple VArrays and Java

Install SQL : use and exisiting Oracle user or create a new one. In this schema run the following scripts via sqlplus intarray.sql, simplepackagebody.sql, simplepackageheader.sql

(soe is the schema I've installed this example into and soe is also the password)

i.e.

$ sqlplus soe/soe@//oracle12c2/soe

SQL*Plus: Release 12.1.0.2.0 Production on Sun Jan 4 17:15:43 2015

Copyright (c) 1982, 2012, Oracle.  All rights reserved.


Connected to:
Oracle Database 12c Enterprise Edition Release 12.1.0.2.0 - 64bit Production
With the Partitioning, OLAP, Advanced Analytics and Real Application Testing options

SOE@//oracle12c2/soe > @intarray.sql

Type created.

SOE@//oracle12c2/soe > @simplepackageheader.sql

Package created.

SOE@//oracle12c2/soe > @simplepackagebody.sql

Package body created.

Compile and run Java : Whilst the point of these examples is to show how to achieve cetain simple operations it is possible to compile and run these code examples. First edit "OracleArrays.java" and change the following line to reflect 
Ant is used to achieve this. i.e.

Change 

OracleArrays oracleArrays = new OracleArrays("soe", "soe", "//oracle12c2/soe");

to something like

OracleArrays oracleArrays = new OracleArrays("scott", "tiger", "linuxserver:1521:orcl");

and then simply run ant (this will need to be in your path).

$ ant runOracleArrays
Buildfile: /Users/dgiles/GitHub/OracleExamples/build.xml

init:

compile:
    [javac] Compiling 1 source file to /Users/dgiles/GitHub/OracleExamples/classes

run:
     [java] Jan 04, 2015 6:10:23 PM com.dom.examples.OracleArrays <init>
     [java] INFO: Attepting to connect to the database
     [java] Jan 04, 2015 6:10:24 PM com.dom.examples.OracleArrays <init>
     [java] INFO: Connected to the database
     [java] Jan 04, 2015 6:10:24 PM com.dom.examples.OracleArrays <init>
     [java] INFO: [1, 1, 1]
     [java] Jan 04, 2015 6:10:24 PM com.dom.examples.OracleArrays <init>
     [java] INFO: Got Array

BUILD SUCCESSFUL
Total time: 1 second




