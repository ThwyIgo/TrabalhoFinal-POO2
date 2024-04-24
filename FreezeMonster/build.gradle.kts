plugins {
    id("buildlogic.java-application-conventions")
}

dependencies {
    implementation(project(":Framework"))
}

application {
    // Define the main class for the application.
    mainClass = "FreezeMonster.Main"
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = application.mainClass
    }
    from (project(":Framework").sourceSets["main"].output)
}
