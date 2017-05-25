use ele;

drop table if exists EmailAddress;
drop table if exists Address;
drop table if exists States;
drop table if exists Country;
drop table if exists PortAsset;
drop table if exists Asset;
drop table if exists Portfolio;
drop table if exists Person;


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
assetCode varchar(50) not null,
assetName varchar(100) not null,
assetType varchar(3) not null,
apr double,
quarterlyDividend double,
baseRateReturn double,
beta double,
omega double,
stockSymbol varchar(50),
constraint uniqueValues unique (assetCode,assetName),
totalValue double,
sharePrice double
)engine=InnoDB,collate=latin1_general_cs; 

create table Portfolio ( 
portfolioID Integer not null primary key auto_increment unique,
managerID integer not null,
ownerID integer not null,
beneficiaryID integer,
foreign key (managerID) references Person(personID),
foreign key (ownerID) references Person(personID),
foreign key (beneficiaryID) references Person(personID),
portCode varchar(20) not null,
constraint uniqueValues unique (portCode)
)engine=InnoDB,collate=latin1_general_cs;  
 
create table Country (
countryID integer not null primary key auto_increment unique,
countryName varchar(200) not null
)engine=InnoDB,collate=latin1_general_cs; 

 create table States (
stateID integer not null primary key auto_increment unique,
stateAbbreviation varchar(3),
stateName varchar(200)
);

create table Address ( 
addressID integer not null primary key auto_increment unique, 
personID Integer not null, 
stateID integer not null, 
countryID integer,
street varchar(255),
city varchar(100) , 
zipcode varchar(100), 
foreign key (personID) references Person(personID),
foreign key (stateID) references States(stateID),
foreign key (countryID) references Country(countryID)
)engine=InnoDB,collate=latin1_general_cs;  


create table PortAsset (
portAssetID Integer not null primary key auto_increment unique,
assetID integer not null,
portfolioID integer not null,
portAssetValue double not null, #for share price or percent investment or totalval of deposit
foreign key (assetID) references Asset(assetID),
foreign key (portfolioID) references Portfolio(portfolioID)
) engine=InnoDB,collate=latin1_general_cs; 
 
create table EmailAddress( 
emailAddressID integer not null primary key auto_increment unique,
emailAddress varchar(100) not null unique, 
personID integer not null,
foreign key (personID) references Person(personID) 
)engine=InnoDB,collate=latin1_general_cs; 

insert into States (stateAbbreviation, stateName) value ('AL', 'Alabama');
insert into States (stateAbbreviation, stateName) value ('AK', 'Alaska');
insert into States (stateAbbreviation, stateName) value ('AR', 'Arkansas');
insert into States (stateAbbreviation, stateName) value ('AZ', 'Arizona');
insert into States (stateAbbreviation, stateName) value ('CA', 'California');
insert into States (stateAbbreviation, stateName) value ('CO', 'Colorado');
insert into States (stateAbbreviation, stateName) value ('CT', 'Connecticut');
insert into States (stateAbbreviation, stateName) value ('DE', 'Delaware');
insert into States (stateAbbreviation, stateName) value ('DC', 'District of Columbia');
insert into States (stateAbbreviation, stateName) value ('FL', 'Florida');
insert into States (stateAbbreviation, stateName) value ('GA', 'Georgia');
insert into States (stateAbbreviation, stateName) value ('HI', 'Hawaii');
insert into States (stateAbbreviation, stateName) value ('ID', 'Idaho');
insert into States (stateAbbreviation, stateName) value ('IL', 'Illinois');
insert into States (stateAbbreviation, stateName) value ('IN', 'Indiana');
insert into States (stateAbbreviation, stateName) value ('IA', 'Iowa');
insert into States (stateAbbreviation, stateName) value ('KS', 'Kansas');
insert into States (stateAbbreviation, stateName) value ('KY', 'Kentucky');
insert into States (stateAbbreviation, stateName) value ('LA', 'Lousiana');
insert into States (stateAbbreviation, stateName) value ('ME', 'Maine');
insert into States (stateAbbreviation, stateName) value ('MD', 'Maryland');
insert into States (stateAbbreviation, stateName) value ('MA', 'Massachusetts');
insert into States (stateAbbreviation, stateName) value ('MI', 'Michigan');
insert into States (stateAbbreviation, stateName) value ('MN', 'Minnesota');
insert into States (stateAbbreviation, stateName) value ('MS', 'Mississippi');
insert into States (stateAbbreviation, stateName) value ('MO', 'Missouri');
insert into States (stateAbbreviation, stateName) value ('MT', 'Montana');
insert into States (stateAbbreviation, stateName) value ('NE', 'Nebraska');
insert into States (stateAbbreviation, stateName) value ('NV', 'Nevada');
insert into States (stateAbbreviation, stateName) value ('NH', 'New Hampshire');
insert into States (stateAbbreviation, stateName) value ('NJ', 'New Jersey');
insert into States (stateAbbreviation, stateName) value ('NM', 'New Mexico');
insert into States (stateAbbreviation, stateName) value ('NY', 'New York');
insert into States (stateAbbreviation, stateName) value ('NC', 'North Carolina');
insert into States (stateAbbreviation, stateName) value ('ND', 'North Dakota');
insert into States (stateAbbreviation, stateName) value ('OH', 'Ohio');
insert into States (stateAbbreviation, stateName) value ('OK', 'Oklahoma');
insert into States (stateAbbreviation, stateName) value ('OR', 'Oregon');
insert into States (stateAbbreviation, stateName) value ('PA', 'Pennsylvania');
insert into States (stateAbbreviation, stateName) value ('RI', 'Rohde Island');
insert into States (stateAbbreviation, stateName) value ('SC', 'South Carolina');
insert into States (stateAbbreviation, stateName) value ('SD', 'South Dakota');
insert into States (stateAbbreviation, stateName) value ('TN', 'Tennessee');
insert into States (stateAbbreviation, stateName) value ('TX', 'Texas');
insert into States (stateAbbreviation, stateName) value ('UT', 'Utah');
insert into States (stateAbbreviation, stateName) value ('VT', 'Vermont');
insert into States (stateAbbreviation, stateName) value ('VA', 'Virginia');
insert into States (stateAbbreviation, stateName) value ('WA', 'Washington');
insert into States (stateAbbreviation, stateName) value ('WV', 'West Virgina');
insert into States (stateAbbreviation, stateName) value ('WI', 'Wisconsin');
insert into States (stateAbbreviation, stateName) value ('WY', 'Wyoming');
insert into Country (countryName) value ('United States');












 

 
 