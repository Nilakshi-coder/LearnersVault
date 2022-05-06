insert into learners_academy.student (fname, lname)
values ('Nilakshi', 'Patil');

insert into learners_academy.student (fname, lname)
values ('Samiksha','Save'),
		('Riddhi', 'Patil'),
        ('Jayashree', 'Patil'),
        ('Kajol','Waghela'),
        ('Sarah','Shetty'),
        ('Harshada','Rane'),
        ('Nishant','Indap');
        
select * from LEARNERS_ACADEMY.student;

select * from learners_academy.course;

insert into learners_academy.course (course_name)
values
	('Web Designing'),
    ('Graphic Designing'),
    ('Android Development');

select * from learners_academy.teacher;

insert into learners_academy.teacher (teacher_name)
values ('Sanjay GopalKumar'),
		('Ravi Thakur'),
        ('Deepak Patil'),
        ('Rahul Patil'),
        ('Kriyansh Save'),
        ('Tejas Save'),
        ('Tanvi Gokhale'),
        ('Jayesh Raut'),
        ('Komal Pathari');
        
select * from learners_academy.subject;

insert into learners_academy.subject (subject_name, course_id, teacher_id)
values ('Java',3,6),
		('HTML',1,8),
        ('CSS',1,null),
        ('PHP',1,null),
        ('Kotlin',3,null),
        ('C++',2,null),
        ('Photoshop',2,null),
        ('Illustrator',null,null);
        
select * from learners_academy.student_details;

select * from learners_academy.subject;

insert into learners_academy.student_details (contact_no, email_address)
values 
('8793017626','nilakshi.patil@gmail.com'),
('8083715409','samiksha.save@gmail.com'),
('8794929456','riddhi.patil@gmail.com'),
('8796097341','jayashree.patil@gmail.com'),
('9271536875','kajol.waghela@gmail.com'),
('7897099711','sarah.shetty@gmail.com'),
('7028765521','harshada.rane@gmail.com'),
('7896097899','nishant.indap@gmail.com');

UPDATE `LEARNERS_ACADEMY`.`student` SET `student_details_id` = '1' WHERE (`student_id` = '1');
UPDATE `LEARNERS_ACADEMY`.`student` SET `student_details_id` = '2' WHERE (`student_id` = '2');
UPDATE `LEARNERS_ACADEMY`.`student` SET `student_details_id` = '3' WHERE (`student_id` = '3');
UPDATE `LEARNERS_ACADEMY`.`student` SET `student_details_id` = '4' WHERE (`student_id` = '4');
UPDATE `LEARNERS_ACADEMY`.`student` SET `student_details_id` = '5' WHERE (`student_id` = '5');
UPDATE `LEARNERS_ACADEMY`.`student` SET `student_details_id` = '6' WHERE (`student_id` = '6');
UPDATE `LEARNERS_ACADEMY`.`student` SET `student_details_id` = '7' WHERE (`student_id` = '7');
UPDATE `LEARNERS_ACADEMY`.`student` SET `student_details_id` = '8' WHERE (`student_id` = '8');

UPDATE `LEARNERS_ACADEMY`.`student` SET `enrollment_id` = '3' WHERE (`student_id` = '1');
UPDATE `LEARNERS_ACADEMY`.`student` SET `enrollment_id` = '2' WHERE (`student_id` = '2');
UPDATE `LEARNERS_ACADEMY`.`student` SET `enrollment_id` = '1' WHERE (`student_id` = '3');
UPDATE `LEARNERS_ACADEMY`.`student` SET `enrollment_id` = '3' WHERE (`student_id` = '4');
UPDATE `LEARNERS_ACADEMY`.`student` SET `enrollment_id` = '3' WHERE (`student_id` = '5');
UPDATE `LEARNERS_ACADEMY`.`student` SET `enrollment_id` = '2' WHERE (`student_id` = '6');
UPDATE `LEARNERS_ACADEMY`.`student` SET `enrollment_id` = '1' WHERE (`student_id` = '7');
UPDATE `LEARNERS_ACADEMY`.`student` SET `enrollment_id` = '2' WHERE (`student_id` = '8');

UPDATE `learners_academy`.`subject` SET `teacher_id` = '9' WHERE (`subject_id` = '19');
UPDATE `learners_academy`.`subject` SET `teacher_id` = '1' WHERE (`subject_id` = '20');
UPDATE `learners_academy`.`subject` SET `teacher_id` = '3' WHERE (`subject_id` = '21');
UPDATE `learners_academy`.`subject` SET `teacher_id` = '4' WHERE (`subject_id` = '22');
UPDATE `learners_academy`.`subject` SET `teacher_id` = '5' WHERE (`subject_id` = '23');


select t.teacher_id, t.teacher_name, s.subject_name, s.subject_id from learners_academy.teacher t, learners_academy.subject s
where t.teacher_id=s.teacher_id
group by s.subject_name;

select c.course_id, c.course_name, s.subject_name, s.subject_id from learners_academy.course c, learners_academy.subject s
where  






