FROM maven:3.6.3-openjdk-8

#
WORKDIR /home/compiler

#
COPY . .

#
RUN mvn package -DskipTests

#
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","target/coaster-1.0.0.jar"]