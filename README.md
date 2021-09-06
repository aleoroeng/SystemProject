# Prerequisites
Java 11 must be installed as well as Gradle 6.8+ https://gradle.org/install/
# Steps to run
After cloning and installing required tools run command ```gradle bootRun```, or to create a runnable Jar run ```gradle bootJar``` and in **~/build/libs** a runnable Jar will be generated

# Overview
Simple Spring Boot project for a request management system, with an authorized admin and unauthorized users that apply to the system. Admin can reject or approve requests within the last 30 days. 

Database console can be reached at ```~/h2-console``` and can be configured in the application.properties provided in ```src/main/resources```, basic start-up data is provided in data.sql in the same directory, test admin credentials can be edited as well in the same file.
