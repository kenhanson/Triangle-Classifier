# Triangle-Classifier
This is a developer coding challenge for Flexion.

## Installation

### Downloading and Unzipping

Download the project to your local computer into a new directory. For the sake of these instructions, the local path is assumed to be **C:\projects**. This will download a zip file named **Triangle-Classifier-master.zip**.

Unzip the downloaded zip file to the same directory which creates a subdirectory named **Triangle-Classifier-master** containing an additional subdirectory named **Triangle-Classifier-master**.

**NOTE: The project ia already built in Java version 1.8.0_77. If your locally installed version of Java is the same or higher, you may skip to the section titled Running Triangle Classifier.**

### Installing Maven

Triangle Classifier is a Maven project containing Java code. Use Maven to install the program. Maven can be downloaded from https://maven.apache.org/download.cgi and instructions for installing Maven are at https://maven.apache.org/install.html.

### Installing Triangle Classifier

At a command prompt navigate to the directory containing the **pom.xml** file, such as **C:\projects\Triangle-Classifier-master\Triangle-Classifier-master\triangle-classifier** depending upon your local path to the downloaded project.

Then install Triangle Classifier with the following Maven command:

**mvn clean install**

This command will remove (clean) the prior build if it exists, then build the program and run the Junit tests. All dependency libraries are included in the executable jar file **triangle-classifier-0.0.1-SNAPSHOT-jar-with-dependencies.jar** which is the end result of the build.
    
## Running Triangle Classifier

Navigate to the **C:\projects\Triangle-Classifier-master\Triangle-Classifier-master\triangle-classifier\target** directory at a command prompt. Then run Triangle Classifier with the following command which is followed by three arguement values representing the three triangle side lengths of the triangle to classify. For this example the side lengths are 1.5, 1.5 and 1.5:

**java -jar triangle-classifier-0.0.1-SNAPSHOT-jar-with-dependencies.jar 1.5 1.5 1.5**    
The result for this example will be **equilateral**.
    
The possible responses depending upon the successfully entered side length values are **equilateral**, **isosceles**, **scalene**, or **not a triangle**. The program will display error details along with usage instructions in the event that the arguement values have a problem that prevents proper classification.
