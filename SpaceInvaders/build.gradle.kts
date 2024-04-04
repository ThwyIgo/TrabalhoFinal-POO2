plugins {
    id("buildlogic.java-application-conventions")
}

dependencies {
    implementation(project(":Framework"))
}

application {
    // Define the main class for the application.
    mainClass = "SpaceInvaders.SpaceInvadersGame"
}
