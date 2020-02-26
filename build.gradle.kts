import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.2.2.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
    kotlin("jvm") version "1.3.61"
    kotlin("plugin.spring") version "1.3.61"
}

group = "com.example.demo"
version = "1.0"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.apache.kafka:kafka-streams:2.4.0")
    implementation("org.apache.kafka:kafka-clients:2.4.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.6.0")
    testImplementation("org.apache.kafka:kafka-streams-test-utils:2.4.0")
    testImplementation("io.mockk:mockk:1.9")
}
val developmentOnly by configurations.creating
configurations {
    runtimeClasspath {
        extendsFrom(developmentOnly)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:6.0.1")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.apache.kafka:kafka-streams")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("org.springframework.kafka:spring-kafka")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("org.springframework.kafka:spring-kafka-test")
    testImplementation("org.junit.jupiter:junit-jupiter:5.5.0")
    testCompile("com.nhaarman.mockitokotlin2:mockito-kotlin:2.0.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<JacocoReport> {
    reports {
        xml.isEnabled = false
        csv.isEnabled = false
        html.destination = file("${buildDir}/jacocoHtml")
    }
}