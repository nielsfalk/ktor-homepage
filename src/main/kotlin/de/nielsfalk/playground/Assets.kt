package de.nielsfalk.playground

import org.jetbrains.ktor.application.call
import org.jetbrains.ktor.content.resolveClasspathWithPath
import org.jetbrains.ktor.locations.get
import org.jetbrains.ktor.locations.location
import org.jetbrains.ktor.routing.Routing

@location("/style.css") class Style()
@location("/nf.png") class NielsImage()

fun Routing.assets() {
    get<Style> { call.respond(call.resolveClasspathWithPath("", "style.css")!!) }
    get<NielsImage> { call.respond(call.resolveClasspathWithPath("", "nf.jpg")!!) }
}