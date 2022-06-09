FROM jetbrains/teamcity-server:latest
SHELL ["pwsh", "-Command"]
RUN Invoke-WebRequest -Uri "https://dlcdn.apache.org/maven/maven-3/3.8.5/binaries/apache-maven-3.8.5-bin.zip" -Outfile "maven.zip"
RUN Expand-Archive -Path "maven.zip" -DestinationPath "C:\\Maven\\"

USER ContainerAdministrator
RUN setx /M PATH $($Env:PATH + ';C:\Maven\apache-maven-3.8.5\bin')
USER ContainerUser

CMD "C:\\TeamCity\\run-server.ps1"