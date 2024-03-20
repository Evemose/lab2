-- Inserting data into the users table
INSERT INTO student (id, username)
VALUES (1, 'user1');
INSERT INTO student (id, username)
VALUES (2, 'user2');
INSERT INTO teacher (id, username)
VALUES (3, 'user3');

insert into course (id, name)
values (1, 'Course 1'),
       (2, 'Course 2');

-- Inserting data into the tests table
INSERT INTO test (id, name, attempts_limit, time_limit, teacher_id, course_id)
VALUES (1, 'Test 1', 2, 120, 3, 1);

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


insert into student_courses (courses_id, students_id)
values (1, 1),
       (2, 1),
       (1, 2);

insert into teacher_courses (courses_id, teachers_id)
values (1, 3),
       (2, 3);

insert into article (id, title)
values (1, 'Article 1'),
       (2, 'Article 2');

insert into article_sections (article_id, content, title, video_url)
values (1, 'Content 1', 'Section 1', 'https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley'),
       (1, 'Content 2', 'Section 2', 'https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley'),
       (2, 'Content 1', 'Section 1', 'https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley'),
       (2, 'Content 2', 'Section 2', 'https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley');

