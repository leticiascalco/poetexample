plugins {
	kotlin("jvm") version "1.8.0"
	kotlin("plugin.spring") version "1.8.0"
	id("org.springframework.boot") version "3.1.0"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "com.br.poetexample"
version = "1.0.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.2")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.register("generateTrancode", com.br.poetexample.generator.tasks.GenerateTrancode::class) {
	group = "code generation"
	description = "Generate classes for trancode"
}
