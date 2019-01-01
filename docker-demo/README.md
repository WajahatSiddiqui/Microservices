# Demo for Docker
# Command to build docker file
$ docker build -f Dockerfile -t tag_name

#Command to run docker
$ docker run -p 8085:8085 <jar_file>.jar

# Command to check docker images
$ docker images

# Example
C:\Users\Wajahat\workspace\Microservices\docker-demo>docker build -f Dockerfile -t docker-demo .
Sending build context to Docker daemon  16.82MB
Step 1/4 : FROM openjdk:8
 ---> f2194a7e67df
Step 2/4 : ADD target/docker-demo.jar docker-demo.jar
 ---> a7c032d1c0b9
Step 3/4 : EXPOSE 8085
 ---> Running in 9e9a61b3a935
Removing intermediate container 9e9a61b3a935
 ---> c49f43ed9bbd
Step 4/4 : ENTRYPOINT ["java", "-jar", "docker-demo.jar"]
 ---> Running in a8d272a3d73d
Removing intermediate container a8d272a3d73d
 ---> 36434e0afb85
Successfully built 36434e0afb85
Successfully tagged docker-demo:latest
SECURITY WARNING: You are building a Docker image from Windows against a non-Windows Docker host. All files and directories added to build context will have '-rwxr-xr-x' permissions. It is recommended to double check and reset permissions for sensitive files and directories.

C:\Users\Wajahat\workspace\Microservices\docker-demo>docker images
REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
docker-demo         latest              36434e0afb85        44 seconds ago      640MB
hello-world         latest              fce289e99eb9        16 hours ago        1.84kB
openjdk             8                   f2194a7e67df        3 days ago          624MB


