CREATE DATABASE IF NOT EXISTS loboticket;

USE loboticket;

create table Venues
(
    Id       Int PRIMARY KEY AUTO_INCREMENT,
    Name     varchar(100)    not null,
    Capacity Int             not null
);

create table Acts
(
    Id          Int PRIMARY KEY AUTO_INCREMENT,
    Name        TEXT            not null,
    RecordLabel TEXT            null
);

create table Gigs
(
    Id          Int PRIMARY KEY AUTO_INCREMENT,
    VenueId     Int           not null,
    ActId       Int           not null,
    TicketsSold Int           not null,
    Price       decimal(4, 2) not null,
    Date        Date          not null,

    FOREIGN KEY (VenueId) REFERENCES Venues (Id),
    FOREIGN KEY (ActId) REFERENCES Acts (Id)
);

DELIMITER $$
create procedure GetActs()
begin
    select acts.name, acts.recordlabel
    from acts
    where acts.recordlabel IS NOT NULL
    order by acts.name;
    
end $$
DELIMITER ;

DELIMITER $$
create procedure GigReport(IN startdate Date, IN enddate Date)
begin
    select gigs.date, acts.name 'Act', acts.recordlabel, venues.name 'Venue', ticketssold, venues.capacity
    from gigs
             join acts on acts.id = gigs.actid
             join venues on venues.id = gigs.venueid
    where date >= startdate
      and date <= enddate
    order by gigs.date;
end $$
DELIMITER ;

DELIMITER $$
-- returns the total sales in the out parameter
create procedure GetTotalSales(OUT sales decimal(8, 2))
begin
    select sum(currentvalue) 'totalsales' from
        (select ticketssold, price, ticketssold*price 'currentvalue'
         from gigs) salestable
    into sales;
end $$
DELIMITER ;

DELIMITER $$
-- call like this:
-- set @newprice = 11;
--
-- call SetNewPrice(1, 0.1, @newprice);
--
-- select @newprice;
-- The idea is to see if we can set a new price, it takes the current price and applies a percentage rise
-- if the new price is less than the maximum then it is set and returned in the inout parameter
-- if the proposed new price is too large then the value is not changed and the current value is returned in the inout parameter
create procedure SetNewPrice(IN gigid int, IN percentage decimal(8,2), inout maxprice decimal(8,2))
begin
    declare gigprice decimal(8,2) default 0.0;
    declare proposedprice decimal(8,2);


    set gigprice = (select max(price) from gigs where id = gigid);

    set proposedprice = gigprice + (gigprice * percentage);

    if (proposedprice < maxPrice)
    then
        set maxprice = proposedprice;
        update gigs set price = proposedprice where id = gigid;
    else
        set maxprice = gigprice;
    end if;
end $$
-- end $$-- 
DELIMITER ;

INSERT INTO Venues (Id, Name, Capacity)
Values (1, 'The Arena', 100);
INSERT INTO Venues (Id, Name, Capacity)
Values (2, 'The Bowl', 150);
INSERT INTO Venues (Id, Name, Capacity)
Values (3, 'The Garage', 200);
INSERT INTO Venues (Id, Name, Capacity)
Values (4, 'The Yard', 20);

INSERT INTO Acts (Id, Name, RecordLabel)
VALUES (1, 'Foo Feathers', 'Copitol');
INSERT INTO Acts (Id, Name, RecordLabel)
VALUES (2, 'The Bottles', 'Banana');
INSERT INTO Acts (Id, Name)
VALUES (3, 'BAAB');
INSERT INTO Acts (Id, Name)
VALUES (4, 'Alede');
INSERT INTO Acts (Id, Name)
VALUES (5, 'Dana Lead Rey');
INSERT INTO Acts (Id, Name)
VALUES (6, 'Led Balloon');
INSERT INTO Acts (Id, Name)
VALUES (7, 'Sheryl Rook');



INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (1, 1, 10.5, 90, '2022-11-04');
INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (2, 1, 10.5, 110, '2022-11-05');
INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (3, 1, 10.5, 170, '2022-11-06');
INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (4, 1, 10.5, 20, '2022-11-08');

INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (1, 2, 12.99, 91, '2022-11-05');
INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (2, 2, 12.99, 113, '2022-11-04');

INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (3, 3, 4.99, 153, '2022-11-07');
INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (4, 4, 4.99, 10, '2022-11-04');

INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (1, 5, 14.99, 153, '2022-11-06');
INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (2, 5, 14.99, 101, '2022-11-10');

INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (1, 6, 14.99, 153, '2022-11-07');
INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (2, 6, 14.99, 101, '2022-11-09');
INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (4, 6, 9.99, 20, '2022-11-05');

INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (2, 7, 15.99, 150, '2022-11-08');
INSERT INTO Gigs(VenueId, ActId, Price, TicketsSold, Date)
VALUES (3, 7, 15.5, 101, '2022-11-04');
