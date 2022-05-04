#DROP USER 'simplilearn_learner'@'localhost';

CREATE USER 'simplilearn_learner'@'localhost' IDENTIFIED WITH mysql_native_password BY 'abc@123';

GRANT ALL PRIVILEGES ON * . * TO 'simplilearn_learner'@'localhost';


