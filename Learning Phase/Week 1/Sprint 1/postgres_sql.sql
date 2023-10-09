CREATE TABLE EMPLOYEE
(
    ID SERIAL,
    NAME VARCHAR (50) NOT NULL,
    CONTACT BIGINT NOT NULL,
    DEPARTMENT VARCHAR (50)NOT NULL,
    EMAIL VARCHAR (50) NOT NULL,
    ADDRESS VARCHAR (100)NOT NULL,
    PRIMARY KEY (ID)
);

COMMIT;

INSERT INTO employee (
	NAME,
   	CONTACT,
	DEPARTMENT,
     EMAIL,
ADDRESS
)
VALUES
    ('Sandeep Jain', 917292410390, 'Accounts and Finance','Jack_Gonzales4078@muall.tech','7849 Wood Street'),
    ('Abhishek Kelenia', 917291039024, 'HR','Maggie_Hastings2506@grannar.com', '7892 Sherlock Street'),
    ( 'Harsh Aggarwal', 917241290390, 'Sales and Marketing ','Anne_Larsen8671@joiniaa.com','4789 Blanche Street'),
    ( 'Raju Kumar', 917286119781,'Creative', 'Raju_Kumar@gmail.com','7589 Upjill Street'),
    ('Nikhil Aggarwal', 9172119781,'Infrastructure','Matthew_Davies3098@mafthy.com', '3789 Drusfus Street'),
    ( 'Anshul Aggarwal',9172861781, 'Research and Development','Liv_Weasley1596@iatim.tech', '8789 Naomie Avenue'),
    ('Virat Kohli', 9172861181,'Learning and Development','Aiden_Roberts258@brety.org', '6789 Hungary Blvd.'),
    ('Rohit Sharma', 917289781,'IT Services','Vivian_Ross9931@elnee.tech', '7489 Embassy Road ')
	;
	
SELECT * FROM employee;

CREATE TABLE LOGIN
(
    ID SERIAL,
    USERNAME VARCHAR (50) NOT NULL,
    PASSWORD VARCHAR (50) NOT NULL,
    EMPLOYEE_ID INT NOT NULL,
    ROLE CHAR (1)NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT fk_employee
      FOREIGN KEY(EMPLOYEE_ID) 
	  REFERENCES EMPLOYEE(ID)
);

INSERT INTO LOGIN (
	USERNAME,
   	PASSWORD,
	EMPLOYEE_ID,
    ROLE)
VALUES
    ('metwo', 'password',2,'A');
    
	
SELECT * FROM login;















