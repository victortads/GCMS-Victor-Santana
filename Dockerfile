FROM ubuntu:latest

RUN apt-get update

RUN apt-get install -y gradle openjdk-17-jdk
# Aproveitando cache do docker
RUN apt-get install -y dos2unix

COPY . /App/

WORKDIR /App/

RUN chmod +x ./gradlew

# ./gradlew might have Windows-style line endings (\r\n) instead of 
# Unix-style line endings (\n). This can cause issues with script execution.
RUN dos2unix ./gradlew

CMD ["./gradlew", "build"]
# CMD while true; do sleep 3600; done;

# docker rm gcms-albert-sobral-container && docker rmi gcms-albert-sobral

# 1. docker build . -t gcms-albert-sobral
# 2. docker create --name gcms-albert-sobral-container gcms-albert-sobral
# 3. docker start gcms-albert-sobral-container
# 4. docker ps -a
# 5.0. docker logs gcms-albert-sobral-container
# 5.1. docker logs -f gcms-albert-sobral-container
# 6. docker commit gcms-albert-sobral-container gcms-albert-sobral

# 7. docker run -v .\:/App -w /App -p 8080:8080 --rm gcms-albert-sobral sh -c "dos2unix ./gradlew && ./gradlew build"
# 8. docker run -v .\:/App -w /App -p 8080:8080 --rm gcms-albert-sobral sh -c "dos2unix ./gradlew && ./gradlew bootRun"

# 9. docker tag gcms-albert-sobral albertalvin/gcms:webapp
# 10. docker push albertalvin/gcms:webapp
