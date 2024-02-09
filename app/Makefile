build:
	./gradlew clean build

test-json-stylish:
	./build/install/app/bin/app src/test/resources/file1.json src/test/resources/file2.json

test-json-plain:
	./build/install/app/bin/app src/test/resources/file1.json src/test/resources/file2.json --format plain

test-json-json:
	./build/install/app/bin/app src/test/resources/file1.json src/test/resources/file2.json --format json

test-yaml-stylish:
	./build/install/app/bin/app src/test/resources/file1.yml src/test/resources/file2.yml

test-yaml-plain:
	./build/install/app/bin/app src/test/resources/file1.yml src/test/resources/file2.yml --format plain

test-yaml-json:
	./build/install/app/bin/app src/test/resources/file1.yml src/test/resources/file2.yml --format json

test-help:
	./build/install/app/bin/app -h

jacoco:
	./gradlew jacocoTestReport

.PHONY: build



