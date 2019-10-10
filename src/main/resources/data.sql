CREATE TABLE course (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  course_name VARCHAR(250) NOT NULL,
  course_fee INT NOT NULL,
);

INSERT INTO course (id, course_name, course_fee) VALUES
  ('1','java', '1000'),
  ('2','Python', '2000'),
  ('3','cpp', '3000');