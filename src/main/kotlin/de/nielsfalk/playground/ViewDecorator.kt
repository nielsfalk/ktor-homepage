package de.nielsfalk.playground

import kara.Placeholder
import kara.Template
import kara.insert
import kotlinx.html.*
import org.jetbrains.ktor.application.Application
import org.jetbrains.ktor.application.ApplicationCall
import org.jetbrains.ktor.application.feature
import org.jetbrains.ktor.locations.Locations
import org.jetbrains.ktor.locations.url

/**
 * @author Niels Falk
 */
class ViewDecorator(val call: ApplicationCall, val application: Application) : Template<HTML>() {
    val title = "Niels Falk - Java EE Spezialist"
    val content = Placeholder<DIV>()
    override fun HTML.render() {
        head {
            title { +this@ViewDecorator.title }
            styleLink("style.css")
            styleLink(call.url(Style()))
            meta {
                httpEquiv = "Content-Type"
                content = "text/html; charset=UTF-8"
            }
            meta("description", this@ViewDecorator.title)
        }
        body {
            div("header") {
                div("container") {
                    img(src = call.url(NielsImage()))
                    h1 { +this@ViewDecorator.title }
                    ul {
                        val locations = application.feature(Locations)
                        listOf(Home(), Contact(), Imprint())
                                .forEach {
                                    li { a(href = locations.href(it)) { +it.linkText } }
                                }
                    }
                }
            }
            div("container") {
                insert(content)
            }
        }
    }
}