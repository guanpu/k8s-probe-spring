# About
This project is to demonstrate how to use k8s probe in a spring project.
In some situation, the application loads some resources on startup, and even though the web-server is started, the app don't want to serve any request already before the resources are totally loaded. In this example, we set the load action as read until the last line of a text file, before that, don't mark the pod as ready in k8s's perspective.
So that it won't serve any requests without the file being loaded, no matter the startup of the pod is triggered by a deploy, a redeployment, or scale out.

## Build & Run
1. mvn clean install
2. copy target/k8s-seamless-1.0-SNAPSHOT.jar to deployment directory
3. docker build -t k8s-seamless:latest .
4. kubectl apply -f k8s-resources.yaml
5. visit http://localhost:30007 to check if it's running

## Test probe feature
To understand the behavior, first start the app from IDE and visit http://localhost:8080/, you'll see 400 and after around 5 seconds (=100 lines * 50 milis/line) it's 200, this is the original application behavior without deploying to k8s.
Now if you build the app and deploy to k8s, and visit http://localhost:30007/, you'll never see 400, that what we want to achieve.

The script(test/test.sh) can be used to verify the aforementioned behavior. It tries to scale out the app from replica=1(as seen in k8s-resources.yaml) to replica=2, and run an apache bench test to check the behavior. The number of requests is decided to be 100000 so that in my local it takes around 10 seconds to finish, means the test can cover the "loading period", feel free to tune the numbers on your local.