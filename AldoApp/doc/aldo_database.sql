DROP DATABASE IF EXISTS aldo_vendor;

CREATE DATABASE aldo_vendor;

USE aldo_vendor;

DROP TABLE IF EXISTS branch_master;


CREATE TABLE branch_master (
  branchId INT UNSIGNED NOT NULL AUTO_INCREMENT,
  branchLocation VARCHAR(100) DEFAULT NULL,
  branchLocationLat VARCHAR(20) DEFAULT NULL,
  branchLocationLon VARCHAR(20) DEFAULT NULL,
  deleteFlag TINYINT(1) NOT NULL DEFAULT '0',
  createdOn DATETIME NOT NULL,
  modifiedOn DATETIME NOT NULL,
  PRIMARY KEY (branchId),
  UNIQUE KEY (branchLocation)
) ENGINE=INNODB DEFAULT CHARSET=latin1 ;

DESC branch_master;

INSERT INTO branch_master (branchLocation, branchLocationLat, branchLocationLon, createdOn, modifiedOn)
VALUES ('Czernyring 14, 69115 Heidelberg', '49.404011' , '8.670450', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


SELECT * FROM branch_master;




DROP TABLE IF EXISTS branch_timings;

CREATE TABLE branch_timings (
  id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  branchId INT UNSIGNED NOT NULL,
  dayInWeek TINYINT(1) NOT NULL COMMENT '1-Sunday, 2-Monday, 3-Tuesday, 4-Wednesday, 5-Thursday, 6-Friday, 7-Saturday',
  isOpen TINYINT(1) NOT NULL,
  openingTime TIME,
  closingTime TIME,
  deleteFlag TINYINT(1) NOT NULL DEFAULT '0',
  createdOn DATETIME NOT NULL,
  modifiedOn DATETIME NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY (branchId, dayInWeek),
  FOREIGN KEY (branchId) REFERENCES branch_master(branchId) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=latin1 ;

DESC branch_timings;


-- Sunday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT branch_master.branchId, 1, 0, NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM branch_master
WHERE branch_master.branchLocation = 'Czernyring 14, 69115 Heidelberg';


-- Monday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT branch_master.branchId, 2, 1, '08:00:00', '21:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM branch_master
WHERE branch_master.branchLocation = 'Czernyring 14, 69115 Heidelberg';



-- Tuesday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT branch_master.branchId, 3, 1, '08:00:00', '21:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM branch_master
WHERE branch_master.branchLocation = 'Czernyring 14, 69115 Heidelberg';



-- Wednesday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT branch_master.branchId, 4, 1, '08:00:00', '21:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM branch_master
WHERE branch_master.branchLocation = 'Czernyring 14, 69115 Heidelberg';



-- Thursday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT branch_master.branchId, 5, 1, '08:00:00', '21:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM branch_master
WHERE branch_master.branchLocation = 'Czernyring 14, 69115 Heidelberg';



-- Friday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT branch_master.branchId, 6, 1, '08:00:00', '21:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM branch_master
WHERE branch_master.branchLocation = 'Czernyring 14, 69115 Heidelberg';



-- Saturday

INSERT INTO branch_timings (branchId, dayInWeek, isOpen, openingTime, closingTime, createdOn, modifiedOn)
SELECT branch_master.branchId, 7, 1, '08:00:00', '21:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP
FROM branch_master
WHERE branch_master.branchLocation = 'Czernyring 14, 69115 Heidelberg';



SELECT * FROM branch_timings;

