.DEFAULT_GOAL := build-run

run:
	java -jar ./target/java-project-lvl1-1.0-SNAPSHOT-jar-with-dependencies.jar

clean:
	.\mvnw clean

build-run: build run

build: clean
	.\mvnw clean package

update:
	.\mvnw versions:update-properties versions:display-plugin-updates