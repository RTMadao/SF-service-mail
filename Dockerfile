FROM openjdk:11-jre-slim

COPY build/libs/mailService-0.0.1-SNAPSHOT.jar home/spring/salcedo_fawcett/mail_service.jar
EXPOSE 3004

# Add docker-compose-wait tool -------------------
ENV WAIT_VERSION 2.7.2
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/$WAIT_VERSION/wait /wait
RUN chmod +x /wait

CMD /wait && java -jar /home/spring/salcedo_fawcett/mail_service.jar