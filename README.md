# SWER348: Advanced Object Oriented - Assignment 1

This assignment focuses on Java 8 features, including lambda expressions, Stream API, Optional, and Java 8 Date and Time API. The objective is to review the Java Collections API, work with a Maven project, and upload the code to GitHub using Git commands.

## Assignment Description

The application reads a student's schedule from a text file and displays any conflicts between lectures. If there are no conflicts, it displays "No Conflict."

### Sample Input
Mon 08:00 75
Mon 08:30 75
Mon 13:00 150
Tue 08:00 75
Tue 13:00 75
Wed 08:00 75
Wed 11:00 50
Wed 13:00 75
Wed 13:00 15
Thu 09:30 75
Thu 13:00 150

### Sample Output
Conflict between Wed 13:00:00 75 minutes and Wed 13:00:00 15 minutes
Conflict between Mon 08:00:00 75 minutes and Mon 08:30:00 75 minutes

## Assignment Requirements

1. Utilize Java 8 Streams API wherever possible. Only use a loop while reading input or while comparing lectures' times for conflicts within the same day.
2. Use Maps.
3. Work with Java 8 Date and Time API. Create a class called Lecture with the following fields: `DayOfWeek dayOfWeek`, `LocalTime time`, and `Duration duration`. Parse the input into these data types and create the lecture objects.

## How to Run the Application

1. Clone the repository.
2. Ensure you have Java 8 and Maven installed on your system.
3. Build the project using the command: `mvn clean install`.
4. Run the application using the command: `java -jar target/assignment1.jar`.


