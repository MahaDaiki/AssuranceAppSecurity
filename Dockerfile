# Use an official Tomcat image as the base image
FROM tomcat:9.0


RUN rm -rf /usr/local/tomcat/webapps/*

WORKDIR /usr/local/tomcat/webapps/

COPY target/AssuranceAppSecurity.war /usr/local/tomcat/webapps/ROOT.war


EXPOSE 5050

# Start Tomcat server
CMD ["catalina.sh", "run"]
