package de.nielsfalk.playground

import kara.Placeholder
import kara.Template
import kara.insert
import kotlinx.html.*
import org.jetbrains.ktor.application.ApplicationCall
import org.jetbrains.ktor.locations.Locations
import org.jetbrains.ktor.locations.url

/**
 * @author Niels Falk
 */
class Decorator(val call: ApplicationCall, val locations: Locations) : Template<HTML>() {
    val title = "Niels Falk - Java EE Spezialist"
    val content = Placeholder<DIV>()
    override fun HTML.render() {
        head {
            title { +this@Decorator.title }
            styleLink("style.css")
            styleLink(call.url(Style()))
            meta {
                httpEquiv = "Content-Type"
                content = "text/html; charset=UTF-8"
            }
            meta("description", this@Decorator.title)
        }
        body {
            div("header") {
                div("container") {
                    img(src = call.url(NielsImage()))
                    h1 { +this@Decorator.title }
                    ul {
                        li { a(href = locations.href(Home())) { +"über mich" } }
                        li { a("contact.html") { +"Kontakt" } }
                        li { a("imprint.html") { +"Impressum" } }
                    }
                }
            }
            div("container") {
                insert(content)
            }
        }
    }
}