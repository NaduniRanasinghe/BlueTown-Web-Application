CREATE TABLE bluelite.employee(
  id int auto_increment primary key,
  empnic varchar(15),
  fname varchar(15), 
  lname varchar(15),
  email varchar(50),
  contact varchar(20),
  gender varchar(10),
  department varchar(30),
  post varchar(50),
  address1 varchar(50),
  address2 varchar(50),
  emppassword varchar(50)
);

create table bluelite.career(

id int auto_increment primary key,
department varchar(50),
post varchar(50),
exdate varchar(20),
supervisor varchar(50),
empStatus varchar(50),
jobdDescription varchar(500)

);

create table bluelite.salary(
id int auto_increment primary key,
nic varchar(20),
basicSal double,
decrement double,
bonus double, 
otrate double,
othrs double,
commission double,
total double
);

CREATE TABLE `test` (
  `cv_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
 
  `cv` mediumblob,
  PRIMARY KEY (`cv_id`));
  
 

CREATE TABLE `contacts` (
  `cv_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `cv` mediumblob,
  PRIMARY KEY (`cv_id`));

CREATE TABLE `asset` (
  `ID` int(4) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Type` varchar(50) NOT NULL,
  `AdditionalDetails` varchar(100) DEFAULT NULL,
  `OtherIDs` varchar(100) DEFAULT NULL,
  `Value` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID`));
  
CREATE TABLE `bill` (
  `BillNumber` int(11) NOT NULL,
  `Type` varchar(45) NOT NULL,
  `BillDate` date NOT NULL,
  `DueDate` date NOT NULL,
  `AdditionalDetails` varchar(45) NOT NULL,
  `Payment` decimal(10,2) NOT NULL,
  PRIMARY KEY (`BillNumber`)
);

CREATE TABLE `purchase` (
  `InvoiceNumber` int(10) NOT NULL,
  `Date` date NOT NULL,
  `SellerID` int(4) NOT NULL,
  `AdditionalDetails` varchar(100) DEFAULT NULL,
  `Value` decimal(10,2) NOT NULL,
  PRIMARY KEY (`InvoiceNumber`)
);

CREATE TABLE `revenue` (
  `ID` int(4) NOT NULL AUTO_INCREMENT,
  `Year` int(4) NOT NULL,
  `Month` varchar(9) NOT NULL,
  `Review` varchar(50) NOT NULL,
  `Revenue` decimal(10,2) NOT NULL,
  PRIMARY KEY (`ID`));

CREATE TABLE bluelite.customer(
cusid int auto_increment primary key,
nic varchar(50),
firstname varchar(50),
lastname varchar(50),
email varchar(50),
mobile varchar(50),
address1 varchar(50),
address2 varchar(50),
city varchar(50),
gender varchar(50),
apartmenttype varchar(50),
site varchar(50),
password varchar(50)

);

use bluelite;
create table raw_material
(
   

id int not null auto_increment,
   
type varchar(20),
   
quantity decimal(10,2),
   
unit varchar(10),
   
unit_cost decimal(10,2),
   
quota decimal(10,2),
   
total decimal(10,2), 
   
   

Constraint rm_pk primary key(id)
);

create table equipment
(
   

id int not null auto_increment,
   
type varchar(20),
   
quantity integer,
   
unit_cost decimal(10,2),
   
maintenance_cost decimal(10,2),
   
total decimal(10,2), 
   
   

Constraint eq_pk primary key(id)

);

create table logistics
(



id int not null auto_increment,   

type varchar(30),

cost decimal(10,2),

maintenance_cost varchar(10),

fuel_cost decimal(10,2),

total decimal(10,2), 
   


Constraint log_pk primary key(id)

);

CREATE TABLE `apartment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apartmentName` varchar(30) DEFAULT NULL,
  `apartmentId` int(11) DEFAULT NULL,
  `type` varchar(30) DEFAULT NULL,
  `site` varchar(255) DEFAULT NULL,
  `room` int(11) DEFAULT NULL,
  `squrft` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

CREATE TABLE `features` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apartmentId` int(11) DEFAULT NULL,
  `AC` varchar(10) DEFAULT NULL,
  `AttachedBathroom` varchar(10) DEFAULT NULL,
  `CCTV` varchar(10) DEFAULT NULL,
  `serventRoom` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `sales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `saleID` int(11) DEFAULT NULL,
  `totPay` double DEFAULT NULL,
  `intPay` double DEFAULT NULL,
  `instlCount` int(11) DEFAULT NULL,
  `cusID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;


create table blueLite.metportal(

	id int auto_increment primary key,
    company_name varchar(20),
    address_line_1 varchar(40),
	address_line_2 varchar(40),
    city varchar(20),
    email varchar(40),
    mobile varchar(20),
    item_name varchar(20),
    unit_price double
  
    );
    
        create table blueLite.hrportal(
		 id int auto_increment primary key,
         namehr varchar(30),
	     address_line_1 varchar(40),
         address_line_2 varchar(40),
         city varchar(20),
         email varchar(40),
		 mobile varchar(20)
    );
    
    
     create table blueLite.serviceportal(
    
		 id int auto_increment primary key,
         name varchar(30),
		address_line_1 varchar(40),
		address_line_2 varchar(40),
        city varchar(20),				
        mobile varchar(20),
        email varchar(40)
    );
    
    Create Table bluelite.task(

	id int auto_increment primary key,
	taskname varchar(10),
    date date,
	description varchar(20),
	Budget double
    );
     
     
    Create Table bluelite.Event(

	id int auto_increment primary key,
	eventname varchar(10),
    description varchar(20),
    date  date,
    EventType varchar(9),
    estimateBudget double,
    location varchar(60)
    );
    
    
    create table bluelite.machinery(
	machineryID int not null auto_increment primary key,
    machineryName varchar(60) not null,
    quantity double
	
);

create table bluelite.material(
	materialID int not null auto_increment primary key,
    materialName varchar(60) not null,
    quantity double
	
);

CREATE TABLE bluelite.sites2(
	siteID int(11) NOT NULL AUTO_INCREMENT,
	siteName varchar(60) NOT NULL,
	siteOwnerName varchar(60) DEFAULT NULL,
	estimatedCost double DEFAULT NULL,
	receivedAmount double DEFAULT NULL,
	handOverDate date DEFAULT NULL,
  PRIMARY KEY (siteID)
) ;

