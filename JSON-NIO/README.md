# Using Java NIO (New IO) to Read a JSON File

> [!NOTE]
> Jackson Core, Annotations, and Databind JARs were added to the project's class library. The referenced .jar files can be found at https://search.maven.org/search?q=com.fasterxml.jackson.core

The idea for this tutorial is to show how you can utilize NIO to read from JSON files and create a list of objects. Although NIO can be used in conjunction with multi-threading, the purpose of this tutorial is to get you started down the path of reading file information.

This tutorial simply gets the file (can be placed anywhere. Here, we are referencing the root of the project folder) and reads all lines while seeting each to a string within an array. Then we iterate over the array to set the information to a JSON string which then can be read by the Jackson ```ObjectMapper```. Finally, we simply iterate over the new object array created by the ```ObjectMapper``` and add each object to an array list we can then use.
