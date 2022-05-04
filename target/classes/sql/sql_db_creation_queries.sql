DROP SCHEMA IF EXISTS LEARNERS_ACADEMY;
CREATE SCHEMA LEARNERS_ACADEMY;
USE LEARNERS_ACADEMY;

DROP TABLE IF EXISTS student;

CREATE TABLE student
(
	student_id INT AUTO_INCREMENT,
	fname VARCHAR(20) NOT NULL,
    lname VARCHAR(20) NOT NULL,
    enrollment_id INT,
    student_details_id INT,
    PRIMARY KEY(student_id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
USE LEARNERS_ACADEMY;

DROP TABLE IF EXISTS student_details;

CREATE TABLE student_details
(
	id INT AUTO_INCREMENT,
    contact_no VARCHAR(10),
    email_address VARCHAR(40),
    PRIMARY KEY(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS course;

CREATE TABLE course
(
	course_id INT AUTO_INCREMENT,
    course_name VARCHAR(30) NOT NULL UNIQUE,
	PRIMARY KEY(course_id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

ALTER TABLE student
ADD FOREIGN KEY (enrollment_id) REFERENCES course(course_id) ON UPDATE CASCADE ON DELETE CASCADE,
ADD FOREIGN KEY (student_details_id) REFERENCES student_details(id) ON UPDATE CASCADE ON DELETE CASCADE;

DROP TABLE IF EXISTS subject;

CREATE TABLE subject
(
	subject_id INT AUTO_INCREMENT,
    subject_name VARCHAR(30) NOT NULL,
	course_id INT,
    teacher_id INT,
    PRIMARY KEY(subject_id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS teacher;

CREATE TABLE teacher
(
	teacher_id INT AUTO_INCREMENT,
    teacher_name VARCHAR(30) NOT NULL,
    PRIMARY KEY(teacher_id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

ALTER TABLE subject
ADD FOREIGN KEY (course_id) REFERENCES course(course_id) ON UPDATE CASCADE ON DELETE CASCADE,
ADD FOREIGN KEY (teacher_id) REFERENCES teacher(teacher_id) ON UPDATE CASCADE ON DELETE CASCADE;

SET FOREIGN_KEY_CHECKS = 1;

