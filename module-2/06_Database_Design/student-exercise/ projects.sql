--CREATE DATABASE project_organizer;

START TRANSACTION;

CREATE TABLE project
(
        id                      serial,
        name                    varchar(64) NOT NULL,
        start_date              TIMESTAMP,
        
        CONSTRAINT pk_project PRIMARY KEY (id)     
        
);

CREATE TABLE employee
(
        id                      serial,
        job_title               varchar(64) NOT NULL,
        last_name               varchar(64) NOT NULL,
        first_name              varchar(64) NOT NULL,
        gender                  varchar(16),
        date_of_birth           DATE NOT NULL,
        date_of_hire            DATE NOT NULL,
        department              int NOT NULL,
        
        CONSTRAINT pk_employee PRIMARY KEY (id)
        
        
);

CREATE TABLE department
(
        id                      serial,
        name                    varchar(64) NOT NULL,
        
        CONSTRAINT pk_department PRIMARY KEY (id) 
           
        
);

CREATE TABLE employee_project
(
        employee_id             int     NOT NULL,             
        project_id              int     NOT NULL,
        
        CONSTRAINT  pk_person_address    PRIMARY KEY            (employee_id, project_id)
);

INSERT INTO project (name, start_date) VALUES ('Database Design', '1/18/2021');
INSERT INTO project(name, start_date) VALUES ('Learn to Code', '11/30/2020');
INSERT INTO project(name, start_date) VALUES ('SQL', '1/11/2021');
INSERT INTO project(name, start_date) VALUES ('Objects', '12/7/2020');

INSERT INTO employee (job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department)
VALUES ('CEO', 'Matos', 'Diandra', 'Nonbinary', '02/03/1995', '01/05/2019', 1);
INSERT INTO employee (job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department)
VALUES ('CFO', 'Weyont', 'Stina', 'Female', '04/12/1993', '02/10/2018', 1);
INSERT INTO employee (job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department)
VALUES ('COO', 'Webb', 'Lee', 'Male', '07/03/1991', '09/22/2020', 1);
INSERT INTO employee (job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department)
VALUES ('Senior Developer', 'Higgs', 'Ally', 'Female', '06/17/1980', '06/20/2015', 2);  
INSERT INTO employee (job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department)
VALUES ('Junior Developer', 'Santos', 'Santi', 'Male', '01/22/1965', '01/05/2010', 2);     
INSERT INTO employee (job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department)
VALUES ('Senior Developer', 'Smith', 'Deen', 'Nonbinary', '12/09/1972', '08/05/2020', 2);  
INSERT INTO employee (job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department)
VALUES ('Director of HR', 'Locke', 'John', 'Male', '02/03/1964', '07/05/2009', 3);  
INSERT INTO employee (job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department)
VALUES ('Junior Developer', 'Diaz', 'Sandy', 'Female', '11/30/1988', '02/05/2017', 2); 
INSERT INTO employee (job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department)
VALUES ('Talent Acquisition', 'Hunter', 'Data', 'Female', '10/03/1975', '11/25/2016', 3);  

INSERT INTO department(name) VALUES('Leadership');
INSERT INTO department(name) VALUES('Developers');
INSERT INTO department(name) VALUES('HR');

INSERT INTO employee_project(employee_id, project_id) VALUES (1, 1);
INSERT INTO employee_project(employee_id, project_id) VALUES (2, 5);
INSERT INTO employee_project(employee_id, project_id) VALUES (3, 2);
INSERT INTO employee_project(employee_id, project_id) VALUES (4, 7);

ALTER TABLE employee_project
--  CONSTRAINT      NAME            CONSTRAINT-TYPE         COLUMNS         REF             TABLE   COLUMN
ADD CONSTRAINT  fk_employee_id_id      FOREIGN KEY          (employee_id)   REFERENCES     employee(id),
ADD CONSTRAINT  fk_project_id_id       FOREIGN KEY          (project_id)    REFERENCES      project(id);

ALTER TABLE employee
ADD CONSTRAINT  fk_department_id_id    FOREIGN KEY           (department)           REFERENCES      department(id);





ROLLBACK;




