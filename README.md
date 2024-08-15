
# Appium-SerenityBDD-Cucumber-SauceLabs

Proyecto de automatización de despositivo movil Android con Appium, Serenity BDD y Cucumber

## Pasos para replicar el proyecto

Seguir el paso a paso

```bash
Abrir IntelliJ y crear un nuevo proyecto Java - Gradle
```

Modificar el archivo build.gradle con la siguiente estructura

```bash
defaultTasks 'clean', 'test', 'aggregate'

repositories {
    mavenCentral()
}

buildscript {
    repositories {
        maven {
            url "https://plugins.gradle.org/m2/"
        }
    }
    dependencies {
        //classpath "net.serenity-bdd:serenity-gradle-plugin:3.3.0"
        classpath "net.serenity-bdd:serenity-gradle-plugin:3.3.10"
    }
}


apply plugin: 'java'
apply plugin: 'eclipse'
apply plugin: 'idea'
apply plugin: "net.serenity-bdd.serenity-gradle-plugin"

sourceCompatibility = 1.8
targetCompatibility = 1.8

ext {
    slf4jVersion = '1.7.7'
    serenityCoreVersion = '3.3.10'
    serenityCucumberVersion = '3.3.10'
    junitVersion = '4.13.1'
    assertJVersion = '3.23.1'
    logbackVersion = '1.2.10'
}

dependencies {
    implementation "ch.qos.logback:logback-classic:${logbackVersion}"

    testImplementation "net.serenity-bdd:serenity-core:${serenityCoreVersion}",
            "net.serenity-bdd:serenity-cucumber:${serenityCucumberVersion}",
            "net.serenity-bdd:serenity-screenplay:${serenityCoreVersion}",
            "net.serenity-bdd:serenity-screenplay-webdriver:${serenityCoreVersion}",
            "net.serenity-bdd:serenity-ensure:${serenityCoreVersion}",
            "junit:junit:${junitVersion}",
            "org.junit.platform:junit-platform-launcher:1.8.2",
            "org.junit.jupiter:junit-jupiter-engine:5.8.2",
            "org.junit.vintage:junit-vintage-engine:5.8.2",
            "org.assertj:assertj-core:${assertJVersion}"
}

test {
    testLogging.showStandardStreams = true
    systemProperties System.getProperties()
}

serenity {
    // Specify the root package of any JUnit acceptance tests to appear in the Serenity report
    testRoot = "starter"
    // Specify the root directory of any Cucumber feature files
    requirementsDir = "src/test/resources/features"

}

gradle.startParameter.continueOnFailure = true

test.finalizedBy(aggregate)
```

Crear la estructura del proyecto. Dentro de la carpeta resources guardar el archivo .apk

```bash
src/test/java/starter/ui, tasks, questions, stepdefinitions, etc...
src/test/java/resources/features...
```

En la raiz del proyecto crear el archivo serenity.properties con la siguiente estructura

```bash
# Define the default driver
#webdriver.driver=phantomjs

# Appears at the top of the reports
serenity.project.name = Demo Project using Appium, Serenity Screenplay and Cucumber

# Root package for any JUnit acceptance tests
#serenity.test.root=net.serenitybdd.tutorials.features

# Customise your riequirements hierarchy
#serenity.requirement.types=feature, story

# Run the tests without calling webdriver - useful to check your JUnit wiring
#serenity.dry.run=true

# Customise browser size
#serenity.browser.height = 1200
#serenity.browser.width = 1200

webdriver.driver= appium
#webdriver.timeouts.implicitlywait = 50000
#webdriver.wait.for.timeout = 100000

appium.hub = http://localhost:4723/wd/hub

####### Android CAPS ######
appium.automationName=uiautomator2
appium.platformName = Android
appium.platformVersion = 11.0
appium.deviceName  = AutomationTesting
appium.app = C:\\Users\\usuario acer\\Documents\\Curso Appium - Serenity BDD\\Appium-SerenityBDD-Cucumber-SauceLabs\\src\\test\\resources\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk
appium.appWaitForLaunch = false
appium.noReset = true
appium.newCommandTimeout = 2000
```

En la raiz del proyecto crear el archivo local.properties con la siguiente estructura

```bash
## This file must *NOT* be checked into Version Control Systems,
# as it contains information specific to your local configuration.
#
# Location of the SDK. This is only used by Gradle.
# For customization when using a Version Control System, please read the
# header note.
#Tue Aug 13 16:22:48 COT 2024
sdk.dir=C\:\\Users\\usuario acer\\AppData\\Local\\Android\\Sdk
```

En la raiz del proyecto crear el archivo logback-test.xml con la siguiente estructura

```bash
<configuration>
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>
                %d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n
            </pattern>
        </encoder>
    </appender>

    <logger name="root" level="WARN"/>
    <logger name="net.serenitybdd" level="INFO"/>
    <logger name="net.thucydides" level="INFO"/>

    <root level="INFO">
        <appender-ref ref="STDOUT"/>
    </root>

</configuration>
```

Dentro de la carpeta starter crear el runner CucumberTestSuite con la siguiente estructura

```bash
package starter;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features")
public class CucumberTestSuite {
}
```

Crear los features y archivos necesarios para el proyecto
## Antes de Ejecutar los Tests

Iniciar el servidor Appium
Abrir el dispositivo movil en Android Studio

## Ejecutar Tests

Para ejecutar los casos de prueba, abrir una terminal y copiar el comando

```bash
    gradle clean test
```
## Authors

- Jorge Franco