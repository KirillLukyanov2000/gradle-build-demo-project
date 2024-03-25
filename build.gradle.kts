plugins {
    id("java")
    id("org.springframework.boot") version "3.2.4"

}

group = "ru.lukyanov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()
    flatDir {
        dirs("mytestrepo")
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(18))
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // https://mvnrepository.com/artifact/org.projectlombok/lombok
    compileOnly("org.projectlombok:lombok:1.18.30")

    // https://mvnrepository.com/artifact/org.slf4j/slf4j-api
    implementation("org.slf4j:slf4j-api:2.0.9")
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.4")
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-thymeleaf
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf:3.2.4")
}

task(println("some text goes to Console.\n" + System.getProperty("java.home")).toString())
task(delete("build/docs").toString())

tasks {
    register("myTask") {
        doLast {
            logger.log(LogLevel.INFO, "just a test log").toString()
        }
    }
}

tasks.test {
    useJUnitPlatform()
}
