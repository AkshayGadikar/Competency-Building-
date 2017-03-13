
insert into Users values(null, 'Mohamadali Shaikh');
insert into Users values(null, 'Chaitanya Patel');
insert into Users values(null, 'Akshay Gadikar');
insert into Users values(null, 'User4');



insert into topic values(null,'Inheritance','Java Inheritance',null,'Java', null);
insert into topic values(null,'Arrays','Java Arrays',null,'Java', null);
insert into topic values(null,'Operating System','Operating System class T.E. Pattern 2014',null,'Operating system', null);

insert into questions(Question_id,question_type,question_statement,topic_id,complexity_level,ccreated_by,created_on) values(null,1,'Which of these keyword must be used to inherit a class?',1,5,null,now());
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'super','N',1);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'this','N',1);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'extent','N',1);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'extends','Y',1);

insert into questions(Question_id,question_type,question_statement,topic_id,complexity_level,ccreated_by,created_on) values(null,1,'Which of these keywords is used to refer to member of base class from a sub class?',1,5,null,now());
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'upper','N',2);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'super','Y',2);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'this','N',2);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'None of the mentioned','N',2);

insert into questions(Question_id,question_type,question_statement,topic_id,complexity_level,ccreated_by,created_on) values(null,1,'A class member declared protected becomes member of subclass of which type?',1,5,null,now());
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'public member','N',3);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,' private member','Y',3);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'protected member','N',3);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'static member','N',3);

insert into questions(Question_id,question_type,question_statement,topic_id,complexity_level,ccreated_by,created_on) values(null,1,'Which of these is correct way of inheriting class A by class B?',1,5,null,now());
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'class B + class A {}','N',4);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'class B inherits class A {}','N',4);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'class B extends A {}','Y',4);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'class B extends class A {}','N',4);


insert into questions(Question_id,question_type,question_statement,topic_id,complexity_level,ccreated_by,created_on) values(null,1,'Which of the following statements are incorrect?',1,5,null,now());
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'public members of class can be accessed by any code in the program.','N',5);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'private members of class can only be accessed by other members of the class.','N',5);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'private members of class can be inherited by a sub class, and become protected members in sub class.','Y',5);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'protected members of a class can be inherited by a sub class, and become private members of the sub class.','N',5);


insert into questions(Question_id,question_type,question_statement,topic_id,complexity_level,ccreated_by,created_on) values(null,2,'Which of these keyword must be used to inherit a class?',1,5,null,now());
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'super','N',6);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'this','Y',6);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'extent','N',6);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'extends','Y',6);

insert into questions(Question_id,question_type,question_statement,topic_id,complexity_level,ccreated_by,created_on) values(null,2,'Which of these keywords is used to refer to member of base class from a sub class?',1,5,null,now());
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'upper','N',7);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'super','Y',7);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'this','N',7);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'None of the mentioned','N',7);

insert into questions(Question_id,question_type,question_statement,topic_id,complexity_level,ccreated_by,created_on) values(null,2,'A class member declared protected becomes member of subclass of which type?',1,5,null,now());
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'public member','Y',8);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,' private member','Y',8);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'protected member','N',8);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'static member','Y',8);

insert into questions(Question_id,question_type,question_statement,topic_id,complexity_level,ccreated_by,created_on) values(null,2,'Which of these is correct way of inheriting class A by class B?',1,5,null,now());
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'class B + class A {}','Y',9);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'class B inherits class A {}','N',9);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'class B extends A {}','Y',9);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'class B extends class A {}','N',9);


insert into questions(Question_id,question_type,question_statement,topic_id,complexity_level,ccreated_by,created_on) values(null,2,'Which of the following statements are incorrect?',1,5,null,now());
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'public members of class can be accessed by any code in the program.','Y',10);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'private members of class can only be accessed by other members of the class.','N',10);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'private members of class can be inherited by a sub class, and become protected members in sub class.','Y',10);
insert into options (Option_id,Option_description,is_option_correct,question_id) values(null,'protected members of a class can be inherited by a sub class, and become private members of the sub class.','Y',10);


insert into questions (Question_id,question_type,question_statement,topic_id,complexity_level,ccreated_by,created_on) values (null,3,'What is the purpose of system calls and how do the system calls relate to operating system ?',3,5,null,now());
insert into questions (Question_id,question_type,question_statement,topic_id,complexity_level,ccreated_by,created_on) values (null,3,'write a shell script for sorting a given list of numbers using bubble sort.',3,5,null,now());
insert into questions (Question_id,question_type,question_statement,topic_id,complexity_level,ccreated_by,created_on) values (null,3,'Explain monitors in brief.',3,5,null,now());
insert into questions (Question_id,question_type,question_statement,topic_id,complexity_level,ccreated_by,created_on) values (null,3,'Explain various allocation methods for storage of files on disk.',3,5,null,now());
insert into questions (Question_id,question_type,question_statement,topic_id,complexity_level,ccreated_by,created_on) values (null,3,'describe free space management techniques with suitable example.',3,5,null,now());
insert into questions (Question_id,question_type,question_statement,topic_id,complexity_level,ccreated_by,created_on) values (null,3,'Discuss the security in Unix.',3,5,null,now());
insert into questions (Question_id,question_type,question_statement,topic_id,complexity_level,ccreated_by,created_on) values (null,3,'What are the common techniques for structuring the page table ? Explain at least three of the techniques',3,5,null,now());
insert into questions (Question_id,question_type,question_statement,topic_id,complexity_level,ccreated_by,created_on) values (null,3,'What is the difference among deadlock avoidance, detection and prevention ?',3,5,null,now());
insert into questions (Question_id,question_type,question_statement,topic_id,complexity_level,ccreated_by,created_on) values (null,3,'Write a semaphore solution for readers-writers problem.',3,5,null,now());


insert into Test(Test_id,Test_type,Test_description,Test_numberOfQuestionsPerTopic,Test_topics,Test_createdOn,Test_createdBy,Test_time,Test_complexityLevel) values (null,1,'Java Interfaces only','5;','1',now(),null,7,5);
insert into Test(Test_id,Test_type,Test_description,Test_numberOfQuestionsPerTopic,Test_topics,Test_createdOn,Test_createdBy,Test_time,Test_complexityLevel) values (null,2,'operating Systems','5;','3;',now(),null,30,5);

insert into assignedTest(User_id,Test_id) values(1,1);
insert into assignedTest(User_id,Test_id) values(1,2);
insert into assignedTest(User_id,Test_id) values(2,1);
insert into assignedTest(User_id,Test_id) values(3,1);
insert into assignedTest(User_id,Test_id) values(4,1);

