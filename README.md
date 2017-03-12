#Hi!
My name is Pongpat Phokeed.
Here is a todo-list API.

#END-POINT
http://{address}:{port}/todo/api/{services}

Properties
##########  

This properties using for status combobox/dropdown.

    task_status :   {
                        request url		: "GET"  /todo/utils/status,
                        response			:	{
				                                "PENDING": "Pending",
				                                "DONE": "Done"
		                                		}
                    },
                    
This domain properties using for add/update/get Task
                    
    task_domain :   {
                      "subject": "task subject 2",
                      "detail": "task detail",
                      "status": {task_status},
                    }
########## 
            
For access Task using "tasks" word instead of {services}.

From now these pattern use for explain services
##########     
        request url             : "{HTTP-METHOD} /todo/api/{services}",
        request body            : {},
        response({http-status}) : {...}
########## 
#Service List

	1. view all task list 
        request url     : "GET"  /todo/api/tasks,
	    response(200)   :  "tasks": [
                                      {
                                        "id": 1,
                                        "subject": "task subject",
                                        "detail": "task detail",
                                        "status": "PENDING"
                                      }
                                    ]
	2. view a single task 
        request url     : "GET"  /todo/api/tasks/{id},
        response(200)   :   {
                                "id": 1,
                                "subject": "task subject",
                                "detail": "task detail",
                                "status": "PENDING"
                            }
	3. add a task 
	    request url     : "POST"  /todo/api/tasks,
        request body    :   {
                              "subject": "task subject 2",
                              "detail": "task detail",
                              "status": {task_status}
                            }
        response(201)   
        
	4. edit a task 
	    request url     : "PATCH"  /todo/api/tasks/{id},
        request body    :   {
                              "subject": "task subject 2",
                              "detail": "task detail",
                              "status": {task_status}
                            }
        response(204)
	5. set a task status 
		request url     : "PATCH"  /todo/api/tasks/{id},
        request body    :   {
                              "status": {task_status}
                            }
        response(204)
	6. delete a task 
	    request url     : "DELETE"  /todo/api/tasks/{id}
        response(204)
	

You also look RestRepository at Hal Browser by http://{address}:{port}/todo/api/browse


#Instruction for deploy

make sure you installed jdk 1.8

##solution 1

1.Install MySQL 5.5 if not exits.

2.Create Scheme "todo".

3.Clone this Repository to your Eclipse.

4.Convert to maven project(if it not).

5.Locate to "application.properties" file.

		change the properties
			spring.datasource.url=jdbc:mysql://{your db address}:{your db port}/todo?characterEncoding=utf-8
			spring.datasource.username={your username that owner scheme "todo"}
			spring.datasource.password={your password}
			
6.Open terminal then locate to project folder.

7.Type "mvn clean package".

8.Look at target folder will have complied jar file eg "dashboard-0.0.1-SNAPSHOT.jar".

9.Open terminal/cmd and locate to {project}/target folder then type "java -jar {name of complied jar}.jar"

10.Application will start at http://localhost:8080/todo 

##solution 2

make sure you installed jdk 1.8

1.Download jar file from https://drive.google.com/file/d/0BzbKcge9WTKKdkF3Q0NWenVMM2M/view?usp=sharing

2.Open terminal/cmd and locate to folder of file then type "java -jar {jar file name}.jar"

3.Application will start at http://localhost:8080/todo 