#1)
select * from Person p
join EmailAddress e on p.personID = e.personID
join Address a on p.personID = a.personID;

#2)
select * from EmailAddress where personID = 1;

#3)
insert into EmailAddress (emailAddress,personID) value ('OnealM@hotmail.com',1);

#4)
update EmailAddress set emailAddress = 'maryjane@yahoo.com' where emailAddressID = 2;

#5)
delete from EmailAddress where personID = 1;
delete from Address where personID = 1;
delete from PortPerson where ownerID =1;
delete from Person where personID = 1;

#6)
insert into Person (personCode,lastName,firstName,secID,personType) value 
('LADKJ124','Simpson','Jessica','sec666','J');

#7)
select assetName from Portfolio p
join PortAsset a on p.portfolioID  = a.portfolioID 
join Asset s on s.assetID = a.assetID
where p.portfolioID = 1;

#8)
select assetName from Person p
join PortPerson pp on p.personID = pp.ownerID
join Portfolio pf on pp.portfolioID = pf.portfolioID
join PortAsset pa on pf.portfolioID = pa.portfolioID
join Asset a on a.assetID = pa.assetID
where p.personID = 1;

#9)
insert into Asset (assetCode,assetName,apr,quartDiv,BRR,beta,omega,stockSymbol,totalValue,sharePrice) value
('LKDFL1214','Google',null,3.54,0.044,0.25,null,'GOOG',null,145.60);

#10)
insert into Portfolio (portCode,totalFee,commissions,weightedRisk,totalReturnVal,totalPortVal) value
('SLKDF495',150.00,135.79,0.45,280.00,2000.00);

#11)
select assetName, p.portfolioID,p.portCode from Portfolio p
join PortAsset pa on p.portfolioID = pa.portfolioID
join Asset a on a.assetID = pa.assetID
where a.assetID = 3;

#12)
select p.lastName, p.firstName, count(pp.portfolioID) amount from Person p
join PortPerson pp on p.personID = pp.ownerID
join Portfolio pf on pf.portfolioID = pp.portfolioID
group by p.personID;

#13)
select p.lastName, p.firstName, count(pp.portfolioID) amount from Person p
join PortPerson pp on p.personID = pp.managerID
join Portfolio pf on pf.portfolioID = pp.portfolioID
group by p.personID;

#14)
select sum(sharePrice * portAssetVal) as totalStockVal from Portfolio p
join PortAsset pa on p.portfolioID = pa.portfolioID
join Asset a on a.assetID = pa.assetID
where a.assetType = 'S';

#15)
select count(*) invalidDistribution from Portfolio p
join PortAsset pa on p.portfolioID = pa.portfolioID
join Asset a on a.assetID = pa.assetID
where a.assetType = 'P' and portAssetVal > 1;

