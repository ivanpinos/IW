# Web Service Client 

This project requires that running ```soap-server-ws``` server. 

One of the first steps is the generation of the code required to invoke the client from
[ClientService.wsdl](src/main/wsdl/ClientService.wsdl) file. Look at [build.gradle](build.gradle) to get a glimpse of the 
complexities of the code generation process. If you want to create only the code just run ```gradle wsimport```.

The client can be run with the command ```gradle jettyEclipseRun```. 