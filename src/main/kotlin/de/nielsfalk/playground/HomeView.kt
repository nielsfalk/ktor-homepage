package de.nielsfalk.playground

import kotlinx.html.a
import kotlinx.html.h2
import kotlinx.html.p
import org.jetbrains.ktor.application.Application
import org.jetbrains.ktor.application.call
import org.jetbrains.ktor.html.respondHtml
import org.jetbrains.ktor.locations.get
import org.jetbrains.ktor.locations.location
import org.jetbrains.ktor.routing.Routing


/**
 * @author Niels Falk
 */
@location("/") class Home : View {
    override val linkText: String get() = "über mich"
}

fun Routing.home(application: Application) {
    get<Home> {
        call.respondHtml {
            with(ViewDecorator(call, application)) {
                content {
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
                render()
            }
        }
    }

}


