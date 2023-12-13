# for terminal
app: compile run

compile:
	./mvnw clean compile package
test:
	./mvnw test
run:
	./mvnw spring-boot:run
clean:
	./mvnw clean



# for Docker Deploying
start: build up
restart: down up
rebuild: down remove build up
stop: down rmi

down: docker-down
build: docker-build
up: docker-up
remove: rmi

docker-down:
	docker-compose down --remove-orphans

docker-build:
	docker-compose build

docker-up:
	docker-compose up -d

rmi:
	docker images -a | grep "javawebsmartcalc" | awk '{print $3}' | xargs docker rmi

