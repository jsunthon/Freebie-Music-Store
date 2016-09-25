# music-store
CS437 Software Engineering Group Project - Spring/Hibernate MVC

#requirements
* mysql
* tomcat 7.0

#database setup
* get springmusic.sql from the sql_scripts folder
* run the script in mysql to set up the databse

#Instructions (Assuming Eclipse IDE)
* go to deployed resources -> webapp -> web-inf -> applicationContext.xml
* change the user and pw to match your mysql login
* import as maven project in eclipse
* add tomcat 7.0 as a server
* right click on project folder name and click `properties`
* `targetted runtimes` -> check tomcat 7.0 -> apply -> ok
* right click on project folder name and `run on server`
