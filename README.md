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
