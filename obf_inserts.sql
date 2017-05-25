insert into Portfolio (portCode,totalFee,commissions,weightedRisk,totalReturnVal,totalPortVal) value 
('PT002',150.00,241.16,0.2480,12057.80, 55875.44);

insert into Portfolio (portCode,totalFee,commissions,weightedRisk,totalReturnVal,totalPortVal) value  
('PA100',100.00,1.27,0.5755,63.73,425.12);

insert into Portfolio (portCode,totalFee,commissions,weightedRisk,totalReturnVal,totalPortVal) value
('P34AS',234,345,234,345,2345); 

insert into Portfolio (portCode,totalFee,commissions,weightedRisk,totalReturnVal,totalPortVal) value 
('PF343',2234,35,234,63,2342);

insert into Person (personCode,lastName,firstName,secID,personType) value 
('57IPQ9','Neal','Maryjane',null,null);

insert into Person (personCode,lastName,firstName,secID,personType) value
('FVD101','Le','Eric','sec098','J');

insert into Person (personCode,lastName,firstName,secID,personType) value
('REV455','Baker','David',null,null);

insert into Person (personCode,lastName,firstName,secID,personType) value
('931570','Scholl','Tommy',null,null);

insert into Person (personCode,lastName,firstName,secID,personType) value
('8E57R6','Field','Joseph','sec789','J');

insert into Person (personCode,lastName,firstName,secID,personType) value
('01WR93','Braswell','Verna','sec897','E');

insert into Countries (countryName) value ('United States');
insert into States (stateName, countryID) value ('RI',1);
insert into States (stateName, countryID) value ('NE',1);
insert into States (stateName, countryID) value ('IL',1);
insert into States (stateName, countryID) value ('FL',1);
insert into States (stateName, countryID) value ('LA',1);
insert into States (stateName, countryID) value ('CT',1);

insert into Address (personID,street,city,stateID,zipcode) value
(1,'709 Diamond Cove', 'Providence' ,1,null);

insert into Address (personID,street,city,stateID, zipcode) value
(2,'1040 Van Dorn St','Lincoln',2,'68512');

insert into Address (personID,street,city,stateID,zipcode) value
(3,'3635 Simpson St','Green Rock',3,'61244');

insert into Address (personID,street,city,stateID,zipcode) value
(4,'4095 Marion Drive','Tampa',4,'33607');

insert into Address (personID,street,city,stateID,zipcode) value
(5,'3420 Grand Ave', 'Baton Rouge', 5, '70810');

insert into Address (personID,street,city,stateID,zipcode) value
(6,'2554 Whitman Court','Wallinford',6,'06492');

insert into EmailAddress (emailAddress,personID) value ('MJ_Oneal@yahoo.com',1);
insert into EmailAddress (emailAddress,personID) value ('mj@yahoo.com',1);

insert into EmailAddress (emailAddress,personID) value ('EricLe@email.com',2);

insert into EmailAddress (emailAddress,personID) value ('SchollT@email.com',4);
insert into EmailAddress (emailAddress,personID) value ('st@gmail.com',4);
insert into EmailAddress (emailAddress,personID) value ('lol@yahoo.com',4);

insert into EmailAddress (emailAddress,personID) value ('jField3@email.com',5);

insert into Asset (assetCode,assetName,assetType,apr,quartDiv,BRR,beta,omega,stockSymbol,totalValue,sharePrice) value
('CMRO1592','Apple','S',null,3.82,0.083,0.0022,null,'AAPL',null,128.75);
insert into Asset (assetCode,assetName,assetType,apr,quartDiv,BRR,beta,omega,stockSymbol,totalValue,sharePrice) value
('O3I4JTVJ','CD','D',0.0260,null,null,null,null,null,null,null);
insert into Asset (assetCode,assetName,assetType,apr,quartDiv,BRR,beta,omega,stockSymbol,totalValue,sharePrice) value
('EIEIO12','Old McDonald Farm','P',null,15.00,0.2324,null,0.0012,null,100600.38,null);

insert into Asset (assetCode,assetName,assetType,apr,quartDiv,BRR,beta,omega,stockSymbol,totalValue,sharePrice) value
('GH59T5U3','Intel Corp','S',null,1.27,0.015,0.0123,null,'INTC',null,36.68);
insert into Asset (assetCode,assetName,assetType,apr,quartDiv,BRR,beta,omega,stockSymbol,totalValue,sharePrice) value
('CH1LL0','Netflix Inc','S',null,2.34,0.098,0.0023,null,'NFLX',null,139.20);

insert into PortAsset (assetID,portfolioID,portAssetVal) value (1,1,20);
insert into PortAsset (assetID,portfolioID,portAssetVal) value (2,1,3000.25);
insert into PortAsset (assetID,portfolioID,portAssetVal) value (3,1,0.50);

insert into PortAsset (assetID,portfolioID,portAssetVal) value (4,2,4);
insert into PortAsset (assetID,portfolioID,portAssetVal) value (5,2,2);

insert into PortAsset (assetID,portfolioID,portAssetVal) value (1,3,20);
insert into PortAsset (assetID,portfolioID,portAssetVal) value (2,3,3000.25);
insert into PortAsset (assetID,portfolioID,portAssetVal) value (3,3,0.50);
insert into PortAsset (assetID,portfolioID,portAssetVal) value (5,3,2);

insert into PortAsset (assetID,portfolioID,portAssetVal) value (4,4,4);
insert into PortAsset (assetID,portfolioID,portAssetVal) value (5,4,2);

insert into PortPerson(portfolioID, managerID, ownerID, beneficiaryID) value (1, 2,1,3);
insert into PortPerson(portfolioID, managerID, ownerID, beneficiaryID) value (2,5,4,6);
insert into PortPerson(portfolioID, managerID, ownerID, beneficiaryID) value (3,2,1,3);
insert into PortPerson(portfolioID, managerID, ownerID, beneficiaryID) value (4,5,4,6);









