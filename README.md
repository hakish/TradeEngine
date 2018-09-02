# TradeEngine
This repository contains the sources that mimic the functionality of a stock market trading engine.

### Sample Data
Entity, Buy/Sell, AgreedFx, Currency, InstructionDate, SettlementDate, Units, Price per unit

foo,B,0.50,SGP,01 Jan 2016,02 Jan 2016,200,100.25

#Requirements
Create a report that shows:
* Amount in USD settled incoming everyday
* Amount in USD settled outgoing everyday
* Ranking of entities based on incoming and outgoing amount. Eg: If entity foo instructs the highest amount for a buy instruction, then foo is rank 1 for outgoing

### Running the appication
* The application is implemented in JDK 1.8 as a maven project.
* The application expects the instructions to be in a CSV file (kept under the resources/sample folder).
* There is a client class TradeEngineClient with a main method that can be used to run the program.
* Junits are present which cover the critical tests with respect to the rules.
* The output should be visible in the console.
* The application does not depend on any external libraries except for JUNIT which is also bundled with JDK nowdays.

### Notes on Design
* Wherever applicable design patterns like Factory/Strategy have been used for creation and usage of various business Rules
* SOLID principles of OOAD is adhered to.
* DRY is also another principle which is adhered, with code being reused as much as possible.

### Class diagram
![Alt text](ClassDiagramTradeEngine.png?raw=true "Class Diagram")
