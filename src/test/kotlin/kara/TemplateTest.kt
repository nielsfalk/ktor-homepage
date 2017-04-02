package kara

import kotlinx.html.*
import kotlinx.html.stream.createHTML
import org.hamcrest.core.AllOf
import org.hamcrest.core.StringContains.containsString
import org.junit.Assert.assertThat
import org.junit.Test

class DecoratorTest {
    @Test
    fun decorate() {
        val html = createHTML(true).html {
            with(MyTemplate()) {
                content {
                    div("content") { +"Lorem ipsum dolor sit" }
                }
                render()
            }
        }

        val expectedClasses = listOf("header", "content", "footer")
        assertThat(html, AllOf(expectedClasses.map { containsString("class=\"$it\"") }))
    }
}

class MyTemplate : Template<HTML>() {
    val content = Placeholder<BODY>()
    override fun HTML.render() {
        body {
            div("header") {}
            insert(content)
            div("footer") {}
        }
    }
}
