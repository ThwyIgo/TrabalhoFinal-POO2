/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("buildlogic.java-application-conventions")
}

dependencies {
    implementation("org.apache.commons:commons-text")
    implementation(project(":Framework"))
}

application {
    // Define the main class for the application.
    mainClass = "FreezeMonster.Main"
}
