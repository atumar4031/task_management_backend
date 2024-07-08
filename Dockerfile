FROM openjdk:17.0-jdk
LABEL authors="almustaphatukur"
ARG JAR_FILE=target/*jar
WORKDIR /app
COPY ${JAR_FILE} /app/task_management_backend.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "task_management_backend.jar"]

#FROM openjdk:17.0-jdk
#LABEL authors="almustaphatukur"
#WORKDIR /app
#COPY target/task_management_backend.jar /app/task_management_backend.jar
#EXPOSE 9090
#CMD ["java", "-jar", "task_management_backend.jar"]
##ENTRYPOINT ["java", "-jar", "task_management_backend.jar"]