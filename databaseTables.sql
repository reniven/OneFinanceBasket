#version 1.0 of DataTables 
drop table if exists EmailAddress;
drop table if exists Address;
drop table if exists States;
drop table if exists Countries;
drop table if exists PortPerson;
drop table if exists Person;
drop table if exists PortAsset;
drop table if exists Asset;
drop table if exists Portfolio;

create table Person ( 
personID Integer auto_increment not null primary key unique,
personCode varchar(20), 
lastName varchar(255) not null, 
firstName varchar(255)not null,
secID varchar(20),
personType varchar(1)  
)engine=InnoDB,collate=latin1_general_cs; 


create table Asset( 
assetID integer not null primary key auto_increment unique, 
assetCode varchar(20) not null,
assetName varchar(50) not null,
assetType varchar(1) not null,
apr double,
quartDiv double,
BRR double,
beta double,
omega double,
stockSymbol varchar(50),
constraint uniqueValues unique (assetCode,assetName,stockSymbol),
totalValue double,
sharePrice double
)engine=InnoDB,collate=latin1_general_cs; 

create table Countries (
countryID integer not null primary key auto_increment unique,
countryName varchar(200) not null
)engine=InnoDB,collate=latin1_general_cs; 

 create table States (
stateID integer not null primary key auto_increment unique,
countryID integer not null,
stateName varchar(200),
foreign key (countryID) references Countries(countryID)
)engine=InnoDB,collate=latin1_general_cs; 

create table Address ( 
addressID integer not null primary key auto_increment unique, 
personID Integer not null, 
street varchar(255),
city varchar(100) , 
stateID integer not null, 
zipcode int, 
foreign key (personID) references Person(personID),
foreign key (stateID) references States(stateID)
)engine=InnoDB,collate=latin1_general_cs; 

create table Portfolio ( 
portfolioID Integer not null primary key auto_increment unique,
portCode varchar(20) not null,
totalFee double not null,
commissions double not null,
weightedRisk double not null,
totalReturnVal double not null,
totalPortVal double not null
)engine=InnoDB,collate=latin1_general_cs; 

create table PortPerson (
portPersonID Integer not null primary key auto_increment unique,
portfolioID Integer not null,
managerID integer not null,
ownerID integer not null,
beneficiaryID integer,
foreign key (managerID) references Person(personID),
foreign key (ownerID) references Person(personID),
foreign key (beneficiaryID) references Person(personID),
foreign key (portfolioID) references Portfolio(portfolioID)
)engine=InnoDB,collate=latin1_general_cs; 

create table PortAsset (
portAssetID Integer not null primary key auto_increment unique,
assetID integer not null,
portfolioID integer not null,
portAssetVal double not null, #for share price or percent investment or totalval of deposit
foreign key (assetID) references Asset(assetID),
foreign key (portfolioID) references Portfolio(portfolioID)
) engine=InnoDB,collate=latin1_general_cs; 
 
create table EmailAddress( 
emailAddressID integer not null primary key auto_increment unique,
emailAddress varchar(100) not null unique, 
personID integer not null,
foreign key (personID) references Person(personID) 
)engine=InnoDB,collate=latin1_general_cs; 


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










 

 
 