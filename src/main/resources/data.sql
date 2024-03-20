-- Inserting data into the users table
INSERT INTO users (dtype, id, username)
VALUES ('user', 1, 'user1');
INSERT INTO users (dtype, id, username)
VALUES ('user', 2, 'user2');
INSERT INTO users (dtype, id, username)
VALUES ('teacher', 3, 'user3');

-- Inserting data into the tests table
INSERT INTO test (name, attempts_limit, time_limit, teacher_id)
VALUES ('Test 1', 2, 120, 3);

-- Inserting data into the questions table
INSERT INTO question (id, question)
VALUES (1, 'Question 1');
INSERT INTO question (id, question)
VALUES (2, 'Question 2');
INSERT INTO question (id, question)
VALUES (3, 'Question 3');

insert into question_answer_options (question_id, text)
values (1, 'Option 1'),
       (1, 'Option 2'),
       (1, 'Option 3'),
       (1, 'Option 4'),
       (2, 'Option 1'),
       (2, 'Option 2'),
       (2, 'Option 3'),
       (2, 'Option 4'),
       (3, 'Option 1'),
       (3, 'Option 2'),
       (3, 'Option 3'),
       (3, 'Option 4');

-- Inserting data into the test_questions table
INSERT INTO test_questions (test_id, questions_id)
VALUES (1, 1),
       (1, 2),
       (1, 3);

-- Inserting data into the test_allowed_students table
INSERT INTO test_allowed_students (test_id, allowed_students_id)
VALUES (1, 1);



