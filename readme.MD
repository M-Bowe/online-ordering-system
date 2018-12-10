# Online Ordering System
Fall 2018 - Project 2

### Overview:

The system consists of three main components:  a command line order
entry module, a central processing module and a data storage module.

 - The order entry module handles all communication with the user
 - The data storage module handles all communication with the underlying file system.  
 - The central processing system coordinates the activities across
   the system taking requests from the order entry module and
   interacting with the data storage layer to fulfill the request.

## Architecture
A key component of understanding and extending the **Online Ordering System**
is its architecture.  Management expects each team to fully document
the architecture and how they plan to extend it.  Components to consider in
developing the architecture documentation are the key drivers, the
_Architectually Significant Requirements_ the team is addressing, the
architecture itself, and how the chosen architecture addresses the drivers.  

## Development
The **Online Ordering System** was developed using the Java language.  The
developers used IntelliJ IDEA, Atom, and VSCode as their principle
development tools.  Development work was done in both Ubuntu and Windows 10.
However, the customer has explicitly asked that the final product run on Windows 10.

### Coding Style
The management team _fired_ the last set of architects and developers because they
could not agree on architectural direction or coding styles and conventions.  This
inability has led to a slightly brittle system that is at risk of falling behind
its primary competitor, that South American company, Amazon.   

The management team strongly believes that consistency in coding will yield a better
result and a better final grade.

### Dependencies
 - Java 8 : Refactoring work done over the life of the ordering system has
 resulted in dependencies on newer versions of Java.  Currently, streams
 and lambda expressions are used.  

    The customer is open to upgrading to newer Java versions if the architecture
    team identifies functionality that would enhance functionality of the
    system or readability of the resulting code.
 - Lombok Library: Lombok annotations are used in places to auto-generate getters and
 setters.  
 - JUnit Library:  Included but never used.
 - MySQL: Used in order to connect the system to an external MySQL database
 
### Building
The development team choose Maven as their build tool.  Maven 3.1.0 and 3.3.9
have both been successfully used.  

With Maven installed, running **mvn package -D maven.test.skip=true** from the root install directory
should successfully build the program.  It is expected that every build will also
execute the test lifecycle ensuring that unit tests all still pass.

### Testing
The development team pushed developing unit tests to the
 end of their development cycle.  As is often the case, this was a poor
 decision.  Time was never allocated and no tests were written.

Unfortunately due to a lack of bandwidth for the development cycle, the team was unable
to develop any solutions for testing. A bid will surely be presented for next development
cycle to establish a proper test plan, as the need for proper testing will only grow.  

## Running the Online Ordering System
Prior to running the Online Ordering System for the first time, it is necessary to
create and initialize the database. Install MySQL on the machine and execute the 
"db_init.sql" file included in the package. This will establish tables for products,
categories, and transactions, as well as create some data points to use.

Once the database has been created, a user is free to run the program. An executable
jar file has been included in the package and can be run using the cmd or bash command
"java -jar onlineorderingsystem.jar" Additionally, if the user chooses to build the
program themselves, maven can be used by executing the cmd or bash command 
"mvn package -D maven.test.skip=true" This will create a file called run.bat which
can be executed by entering the cmd or bash command "./run.bat" Note that the
preferred method of execution is the included jar file.


