#Hi!
My name is Pongpat Phokeed.
Here is a todo-list API.

END-POINT
http://{address}:{port}/todo/api/{services}

Properties
##########  
    task_status :   {
                        api: "/todo/utils/status",
                        example:{
                                "PENDING": "Pending",
                                "DONE": "Done"
                                }
                    },
    task_domain :   {
                      "subject": "task subject 2",
                      "detail": "task detail",
                      "status": {task_status},
                    }
########## 
            
For handler Task using "tasks" instead of {services}.

From now these pattern use for explain services
##########     
        request url             : "{HTTP-METHOD} /todo/api/{services}",
        request body            : {},
        response({http-status}) : {...}
########## 
Service List

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
	

Instruction for deploy

1.Install MySQL 5.5 if not exits.

2.Create Scheme "todo".

3.Clone this Repository to your Eclipse.

4.Convert to maven project.

5.Locate to "application.properties" file.

		change the properties
			spring.datasource.url=jdbc:mysql://{your db address}:{your db port}/todo?characterEncoding=utf-8
			spring.datasource.username={your username that owner scheme "todo"}
			spring.datasource.password={your password}
			
6.Open terminal then locate to project folder.

7.Type "mvn clean package".

8.Look at target folder will have complied jar file eg "dashboard-0.0.1-SNAPSHOT.jar".

9.Open terminal/cmd and locate to {project}/target folder 

			then type "java -jar {name of complied jar}.jar"
