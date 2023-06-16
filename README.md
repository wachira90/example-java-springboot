# example-java-springboot
example java springboot

## run command

```bat
java -jar myapp-0.0.1-SNAPSHOT.jar
```

## test

```
http://localhost:8080/
```


## version

```bat
>java -version
openjdk version "17.0.7" 2023-04-18
OpenJDK Runtime Environment Temurin-17.0.7+7 (build 17.0.7+7)
OpenJDK 64-Bit Server VM Temurin-17.0.7+7 (build 17.0.7+7, mixed mode, sharing)

>javac -version
javac 17.0.7
```

## Dockerfile

### mv myapp-0.0.1-SNAPSHOT.jar app.jar

### docker build -t wachira90/spring-boot:1.0 .

```
FROM openjdk:8-jre
WORKDIR /app
ADD app.jar /app
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
```

## kubernet yaml

```
apiVersion: apps/v1
kind: Deployment
metadata:
  name: dep-spring
  namespace: develop
  labels:
    app: spring
spec:
  replicas: 1
  selector:
    matchLabels:
      app: spring
  template:
    metadata:
      labels:
        app: spring
    spec:
      containers:
      - name: spring
        image: wachira90/spring-boot:1.0
---
apiVersion: v1
kind: Service
metadata:
  name: svc-spring
  namespace: develop
  labels:
    app: spring
spec:
  type: NodePort
  selector:
    app: spring
  ports:
    - port: 8080
      targetPort: 8080
      nodePort: 31000
```
