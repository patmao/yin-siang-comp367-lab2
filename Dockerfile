FROM openjdk:21
EXPOSE 8080
ADD target/YinSiangMao_COMP367_lab2.jar YinSiangMao_COMP367_lab2.jar
ENTRYPOINT [ "java", "-jar","/YinSiangMao_COMP367_lab2.jar" ]