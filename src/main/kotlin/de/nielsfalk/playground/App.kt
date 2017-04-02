@file:Suppress("EXPERIMENTAL_FEATURE_WARNING")

package de.nielsfalk.playground

import org.jetbrains.ktor.application.Application
import org.jetbrains.ktor.application.install
import org.jetbrains.ktor.features.DefaultHeaders
import org.jetbrains.ktor.locations.Locations
import org.jetbrains.ktor.logging.CallLogging
import org.jetbrains.ktor.routing.Routing


fun Application.main() {
    install(DefaultHeaders)
    install(CallLogging)
    install(Locations)
    install(Routing) {
        assets()
        home(this@main)
    }
}

