# QuizMe

This project is a web application that helps a user solve online examinations on various programming languages. 
A user has a choice in the selection of programming language and the sub-topic he/she plans to attempt. 
The website offers practice exam to the users. On the consumer side, when a user finishes an examination, 
they are evaluated based on their score and score history (if any) and are ranked accordingly on the leaderboard 
which can be reviewed by the users and the admin. It also offers registration to an exam in advance. Also, on completion, 
they get a choice to retake an exam (on same topic) or 
choose another topic for next exam and get recommendation for other topics based on their performance history. 
The web application is maintained by an admin who has special privileges over the application. 
Based on the sentiment analysis on user's performance, the quiz will be updated by the admin. 

The application is developed using HTML, CSS, JavaScript, Spring Framework, MySQL. The User Interface is designed with HTML, CSS, 
JavaScript and integrated with Model View Controller. MySQL is used at the backend to store all user information, questions database 
along with user responses.

What distinguishes this from the other Quiz applications, is the usage of Sentiment Analysis and Recommendation System. 
All the responses of users are stored in the database for each question and this data is used to recommend the users sub topics 
in which he/she needs to improve more.Also, the users can give feedback, which is then used as an input to 
the Sentiment classifier to distinguish this as positive or negative feedback. The admin can view the sentiment analysis report to 
improve the questions further in each topic.

A sticky notes kind of feature is available in this application , user can store important notes in this sticky notes ,once 
the user saves the information in the sticky notes , he can view the information any number of times by logging in to his account.
user can also modify and delete the existing notes.

## Application Features:

The website is accessible only on Authentication of users or admin during Login.

### The website provides following services:

1.	Online examination in various programming languages with a choice of sub-topic.
2.	Leaderboard covering performance of all the users.
3.	Registration to Offline exams.
4.	Suggests users with topics they can take quiz, on completion of their quiz based on their performance
5.	Stores the responses and feedback of users for improving the quality of questions.

### A User can perform following:
1.	Take a quiz on a technical topic of his/her choice.
2.	View score on completion of the exam.
3.	View leaderboard to compare his score evaluated on all his/her past performance.
4.	Provide feedback for the quiz.
5.	Register to offline exams.

### An Admin can perform following:
1.	View leaderboard of the users.
2.	Add or delete questions.
3.	Create new exams.
4.	Update question level.
5.	View Sentiment analysis.

## Future Scope:

1. A mock exam can be conducted for the participants before taking the exam. 
   This helps the participant to assess his level of skills for a topic of his choice.

2. A timer can also be included for this mock exam which helps the participants to assess their time management

3. A newsletter can also be implemented that sends a mail to all the registered users with the latest trends in the technical field.
