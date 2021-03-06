package de.nielsfalk.playground

import kotlinx.html.a
import kotlinx.html.br
import kotlinx.html.h2
import kotlinx.html.p
import org.jetbrains.ktor.application.Application
import org.jetbrains.ktor.application.call
import org.jetbrains.ktor.html.respondHtmlTemplate
import org.jetbrains.ktor.locations.get
import org.jetbrains.ktor.locations.location
import org.jetbrains.ktor.routing.Routing


/**
 * @author Niels Falk
 */
@location("/contact") class Contact : View {
    override val linkText: String get() = "Kontakt"
}


fun Application.contact(routing: Routing) {
    routing.get<Contact> {
        call.respondHtmlTemplate(ViewDecorator(call, this@contact)) {
            content {
                h2 { +"Kontakt" }
                p { +"Niels Falk" }
                p {
                    +"Email: "
                    a("mailto:niels@nielsfalk.de") { +"niels@nielsfalk.de" }
                    br
                    +"Mobil: +49 1577 7755957"
                }
                p {
                    +"Heidefalterweg 10"
                    br
                    +"12683 Berlin"
                    br
                }
                h2 { +"Weitere Profile" }
                p {
                    a("https://github.com/nielsfalk") { +"github" }
                    br
                    a("https://www.xing.com/profiles/Niels_Falk") { +"XING" }
                }
            }
        }
    }
}


