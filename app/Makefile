build:
	./gradlew build

test-json-stylish:
	./build/install/app/bin/app src/test/resources/file5.json src/test/resources/file6.json

test-json-plain:
	./build/install/app/bin/app src/test/resources/file5.json src/test/resources/file6.json --format plain

test-json-json:
	./build/install/app/bin/app src/test/resources/file5.json src/test/resources/file6.json --format json

test-yaml-stylish:
	./build/install/app/bin/app src/test/resources/file7.yml src/test/resources/file8.yml

test-yaml-plain:
	./build/install/app/bin/app src/test/resources/file7.yml src/test/resources/file8.yml --format plain

test-help:
	./build/install/app/bin/app -h

jacoco:
	./gradlew jacocoTestReport

.PHONY: build



