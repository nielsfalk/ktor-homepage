package de.nielsfalk.playground

import org.jetbrains.ktor.application.ApplicationCall
import org.jetbrains.ktor.application.call
import org.jetbrains.ktor.content.resolveClasspathWithPath
import org.jetbrains.ktor.locations.get
import org.jetbrains.ktor.locations.location
import org.jetbrains.ktor.locations.url
import org.jetbrains.ktor.routing.Routing


@location("/assets") class Assets(val resource: resource)
enum class resource(val file: String) {
    pictureOfNiels("nf.jpg"), css("style.css");
}

fun Routing.assets() {
    get<Assets> {
        call.respond(call.resolveClasspathWithPath("", it.resource.file)!!)
    }
}

internal fun ApplicationCall.resolve(resource: resource): String = url(Assets(resource))