# About
This project is to demonstrate how to use k8s probe in a spring project, it loads a file on the container starts, but don't mark the pod as ready in k8s's perspective until the file is fully loaded.
So that it won't serve any requests without the file being loaded, no matter the scenario is a redeployment, scale out or any other Ops action.

## Build & Run
1. mvn clean install
2. copy target/k8s-seamless-1.0-SNAPSHOT.jar to deployment directory
3. docker build -t k8s-seamless:latest .
4. kubectl apply -f k8s-resources.yaml
5. visit http://localhost:30007 to check if it's running

## Test probe feature
