#Hi!
My name is Pongpat Phokeed
Here is a todo-list API.

END-POINT
http://{address}:{port}/todo/api/{services}

Properties
    May be use in some service
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
            
                    
Service List
For handler Task using "tasks" instead of {services}
From now these pattern use for explane services
##########     
        request url             : "{HTTP-METHOD} /todo/api/{services}",
        request body            : {},
        response({http-status}) : {...}
########## 
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
        response(204)   
        
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