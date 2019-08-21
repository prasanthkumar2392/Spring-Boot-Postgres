FROM openjdk:11	
VOLUME /tmp
COPY build/libs/Spring-Sample-boot.jar  Spring-Sample-boot.jar
EXPOSE 7000
ENTRYPOINT ["java","-jar","/Spring-Sample-boot.jar"]