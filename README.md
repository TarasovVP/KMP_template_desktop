# KMP Template — Desktop App

[![Java](https://img.shields.io/badge/Java-17-ED8B00.svg?logo=openjdk&logoColor=white)](https://openjdk.org/)
[![JavaFX](https://img.shields.io/badge/JavaFX-21-5382A1.svg)](https://openjfx.io/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

A native JVM desktop application that consumes a Kotlin Multiplatform library from Java through a Maven artifact.

This repository is the Desktop example from [**KMP: Integrating into Native Projects**](https://medium.com/@vptarasov/kmp-integrating-into-native-projects-f0f35091706d). It shows that a KMP library can be used from an ordinary Java and JavaFX project without converting the consumer to Gradle or Kotlin.

## What the app demonstrates

- A Java 17 application built with Maven.
- A JavaFX 21 user interface.
- Consumption of the KMP JVM target as a regular Maven dependency.
- Direct Java calls to Kotlin-generated classes.
- Shared behavior with a fully native desktop presentation layer.

The window displays the shared greeting and date together with the desktop device description and host operating-system version.

## Shared dependency

The application depends on:

```xml
<dependency>
    <groupId>com.tarasovvp.kmptemplate</groupId>
    <artifactId>shared-jvm</artifactId>
    <version>1.0</version>
</dependency>
```

The artifact is produced by [KMP_template_shared](https://github.com/TarasovVP/KMP_template_shared) and resolved from Maven Local. Publish it before compiling the desktop application:

```shell
git clone https://github.com/TarasovVP/KMP_template_shared.git
cd KMP_template_shared
./gradlew :shared:publishToMavenLocal
```

## Companion repositories

These independent repositories form the complete example from the article:

| Repository | Role |
|---|---|
| [KMP_template_shared](https://github.com/TarasovVP/KMP_template_shared) | Shared KMP library and JVM artifact source |
| [KMP_template_android](https://github.com/TarasovVP/KMP_template_android) | Android consumer with Jetpack Compose |
| [KMP_template_ios](https://github.com/TarasovVP/KMP_template_ios) | iOS consumer with SwiftUI |
| **KMP_template_desktop** | JVM desktop consumer with JavaFX |
| [KMP_template_web](https://github.com/TarasovVP/KMP_template_web) | JavaScript consumer with Vite |

## Tech stack

- Java 17
- JavaFX 21.0.2
- Maven
- KMP `shared-jvm` artifact from Maven Local

The current Maven configuration selects the `mac-aarch64` JavaFX classifier. Change `javafx.platform` in `pom.xml` when building for another operating system or CPU architecture.

## Requirements

- JDK 17+
- Maven 3.8+
- The `shared-jvm:1.0` artifact published to Maven Local

## Build

After publishing the shared artifact:

```shell
git clone https://github.com/TarasovVP/KMP_template_desktop.git
cd KMP_template_desktop
mvn compile
```

Open the Maven project in IntelliJ IDEA and run the `Main` class to start the JavaFX application.

## Project structure

```text
KMP_template_desktop/
├── pom.xml                 # JavaFX and shared-jvm dependencies
└── src/main/java/Main.java # JavaFX UI and shared API calls
```

## Later automation

[KMP_template_agents](https://github.com/TarasovVP/KMP_template_agents) was created later as a separate orchestration harness built around this already-existing example set. It automates publishing the shared JVM artifact, resolving Maven dependencies, building the application, and running a behavior smoke test; it is not the source or parent project of this desktop application.

See [AI Agents for a KMP Developer](https://levelup.gitconnected.com/ai-agents-for-a-kmp-developer-82af4e8851a9) for that later automation layer.

## License

Licensed under the [MIT License](LICENSE).
