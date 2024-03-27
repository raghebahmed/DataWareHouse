# DataWareHouse

ProgressSoft ClusteredData Warehouse task.

The task asked to create an API that requests several fields:
(Deal Id, From Currency, To Currency,  timestamp, Deal Amount ). 
Validate rows structure.
The system should not import the same request twice/ I have a problem while doing this (correlation ID).
No rollback allowed, every row imported should be saved in DB.

----------------

I used:
JAVA 17
Springboot
JPA H2 for DB.
Maven.
Error handling.
Log4j for logging.

----------------

There are 5 Classes:
ClusteredDataWarehouseApplication (Main).
Controller (the API and the functions).
Repository (for extending JpaRepository).
Order (JPA)
ResponsePojo ( for JSON's request structure) 



