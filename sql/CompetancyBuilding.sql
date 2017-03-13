CREATE DATABASE competancy_building;
USE competancy_building;

CREATE TABLE Users (
	Users_id INT(10)  auto_increment primary key,
	User_name VARCHAR(100) not null
);

CREATE TABLE `topic` (
	`topic_id` INT(10) auto_increment NOT NULL,
	`topic_name` VARCHAR(20) NOT NULL,
	`topic_description` VARCHAR(100) NULL DEFAULT NULL,
	`topic_child_of` INT(10) NULL DEFAULT NULL,
	`topic_category` VARCHAR(20) NULL DEFAULT NULL,
	`version` VARCHAR(10) NULL DEFAULT NULL,
	PRIMARY KEY (`topic_id`)
);

CREATE TABLE `questions` (
	`Question_id` INT(12) NOT NULL auto_increment,
	`question_type` INT(2) NOT NULL,
	`question_statement` VARCHAR(1000) NOT NULL,
	`topic_id` INT(12) NULL DEFAULT NULL,
	`complexity_level` INT(2) NOT NULL,
	`ccreated_by` INT(10) NULL DEFAULT NULL,
	`created_on` DATE NOT NULL,
	PRIMARY KEY (`Question_id`),
	CONSTRAINT `topic_id` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`)
);

CREATE TABLE `answer` (
	`answer_id` INT(11) NOT NULL,
	`question_Id` INT(11) NOT NULL,
	`answer` VARCHAR(500) NOT NULL,
	PRIMARY KEY (`answer_id`),
	INDEX `FK__questions` (`question_Id`),
	CONSTRAINT `FK__questions` FOREIGN KEY (`question_Id`) REFERENCES `questions` (`Question_id`)
);


CREATE TABLE Test (
	Test_id INT(10) auto_increment primary key,
	Test_type INT(2) not null,
	Test_description VARCHAR(1000),
	Test_numberOfQuestionsPerTopic VARCHAR(100),
	Test_topics VARCHAR(100) not null,	
	Test_createdOn DATE not null,
	Test_createdBy INT(10) references Users(Users_id),	
	Test_time INT(3) not null,	
	Test_complexityLevel INT(2) not null
);

CREATE TABLE History (
	History_id INT(10) auto_increment primary key,
	History_test_id INT(10) references Test(Test_id),
	History_user_id INT(10) references Users(Users_id),
	History_dateAndTime DATE not null,
	History_remark VARCHAR(1000),
	History_resultsPerTopics VARCHAR(100)
);

CREATE TABLE AskedQuestion(
	AskedQuestion_users_id INT(10) references Users(Users_id),
	AskedQuestion_question_id INT(10) references Questions(Question_id),
	AskedQuestion_history_id INT(10) references History(History_id)
);

CREATE TABLE OngoingTest (
	OngoingTest_user_id INT(10) references Users(Users_id),
	OngoingTest_test_id INT(10) references Test(Test_id),
	OngoingTest_questionId INT(10) references Questions(Question_id),
	OngoingTest_MarkedAnswers varchar(100000),
	OngoingTest_TimeStamp DATE not null
);

CREATE TABLE `options` (
	`Option_id` INT(12) NOT NULL AUTO_INCREMENT,
	`Option_description` VARCHAR(16) NOT NULL,
	`is_option_correct` VARCHAR(1) NULL DEFAULT '0',
	`question_id` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`Option_id`),
	INDEX `FK_options_questions` (`question_id`),
	CONSTRAINT `FK_options_questions` FOREIGN KEY (`question_id`) REFERENCES `questions` (`Question_id`)
);

CREATE TABLE assignedTest(
	User_id int(10) REFERENCES Users(Users_id),
	Test_id INT(10) REFERENCES test(Test_id)
);