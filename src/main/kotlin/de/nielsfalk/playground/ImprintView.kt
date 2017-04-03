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
@location("/imprint") class Imprint : View {
    override val linkText: String get() = "Impressum"
}

fun Application.imprint(routing: Routing) {
    routing.get<Imprint> {
        call.respondHtmlTemplate(ViewDecorator(call, this@imprint)) {
            content {
                h2 { +"Impressum" }
                p {
                    +"Niels Falk"
                    br
                    +"Heidefalterweg 10"
                    br
                    +"12683 Berlin"
                    br
                    +"Deutschland"
                    br
                    +"Email: "
                    a("mailto:niels@nielsfalk.de") { +"niels@nielsfalk.de" }
                    br
                    +"Mobil: +49 1577 7755957"
                    br
                    +"USt.IDNr.: DE290833696"
                    br
                }
                p {
                    +"Inhaltlich Verantwortlicher gemäß § 10 Absatz 3 MDStV: Niels Falk (Anschrift wie oben)"
                }
                p {
                    +"Haftungshinweis: Trotz sorgfältiger inhaltlicher Kontrolle übernehmen wir keine Haftung für die Inhalte externer"
                    +"Links. Für den Inhalt der verlinkten Seiten sind ausschließlich deren Betreiber verantwortlich."
                }
                h2 { +"Weitere Profile" }
                p {
                    a("https://github.com/nielsfalk") { +"github" }
                    br
                    a("https://www.xing.com/profiles/Niels_Falk") { +"XING" }
                }
                p { +"Fotografin: Lara Beins" }
            }
        }
    }
}


