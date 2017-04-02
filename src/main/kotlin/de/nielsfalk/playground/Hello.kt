package de.nielsfalk.playground

import kotlinx.html.*
import org.jetbrains.ktor.application.call
import org.jetbrains.ktor.html.respondHtml
import org.jetbrains.ktor.netty.embeddedNettyServer
import org.jetbrains.ktor.routing.get
import org.jetbrains.ktor.routing.routing

val title = "Niels Falk - Java EE Spezialist"

fun main(args: Array<String>) {
    embeddedNettyServer(8080) {
        routing {
            get("/") {
                call.respondHtml {
                    head {
                        title { +title }
                        styleLink("style.css")
                        meta {
                            httpEquiv = "Content-Type"
                            content = "text/html; charset=UTF-8"
                        }
                        meta("description", title)
                    }
                    body {
                        div("header") {
                            div("container") {
                                img(src = "nf.jpg")
                                h1 { title }
                                ul {
                                    li { a("index.html") { +"über mich" } }
                                    li { a("contact.html") { +"Kontakt" } }
                                    li { a("imprint.html") { +"Impressum" } }
                                }
                            }
                        }
                        div("container") {
                            h2 { +"Wer bin ich" }
                            p {
                                +"An Softwareentwicklung begeistert mich der Umgang mit Technologie. "
                                +"Nach 10 Jahren in Festanstellungen gehe ich nun als Freiberufler neue Wege. "
                                +"Meine Zielstrebigkeit, der ständige Wunsch nach Ausbau meiner Fähigkeiten "
                                +"und mein schrittweises Vorgehen findet sich auch in meinen Freizeitaktivitäten"
                                a("http://www.youtube.com/watch?v=FhLnyNwStiE") { +"Einradfahren" }
                                +", Wakeboarding und Slacklining wieder."
                            }
                            h2 { +"Mein Verständnis von guter Software" }
                            p {
                                +"Software wird häufiger gelesen als geschrieben. Die hohe Kunst ist es die Fachlichkeit simpel, präzise und"
                                +"effizient"
                                +"auszudrücken. Design-Patterns sind toll, dennoch sollte der gesunde Menschenverstand über Dogmen siegen."
                                +"Kleinschrittiges Vorgehen, frühes Feedback durch kurze Iterationen und schnelle Inbetriebnahme helfen Irrwege"
                                +"frühzeitig zu erkennen, Kosten zu sparen und das Wohlbefinden aller Beteiligten zu bewahren."
                            }
                            p {
                                +"Die richtige Menge guter Tests erlauben es den Code flexibel zu refactoren ohne die Funktionalität zu gefährden."
                                +"Automatisierte Integrationstests sind ein must-have."
                            }
                            p {
                                +"Bereits in einer frühen Projektphase sollte sichergestellt werden, die gewünschte Performance zu erreichen."
                                +"Solange"
                                +"keine groben Fehler gemacht wurden, können Performance-Schwachstellen nur durch Messen ermittelt werden."
                            }
                        }
                    }
                }
            }
        }
    }.start(wait = true)
}