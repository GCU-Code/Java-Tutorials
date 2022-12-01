# Using Java IO to Read a JSON File

> [!NOTE]
> Jackson Core, Annotations, and Databind JARs were added to the project's class library. The referenced .jar files can be found at https://search.maven.org/search?q=com.fasterxml.jackson.core

The idea for this tutorial is to show how you can utilize simple IO to read from JSON files and create a list of objects. 

This tutorial simply gets the file (can be placed anywhere. Here, we are referencing the root of the project folder) and reads all bytes from the stream and sets the stream to a string. The string is then mapped and set to an array. Finally, we simply iterate over the new object array created by the ObjectMapper and add each object to an array list we can then use.
