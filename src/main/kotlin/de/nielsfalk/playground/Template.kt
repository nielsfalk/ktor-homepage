package de.nielsfalk.playground

// copied from https://github.com/TinyMission/kara/blob/master/src/KaraLib/src/kara/Template.kt
// License: Kara is Open Source and licensed under the Apache Licenses, version 2.0. It can be freely used in commercial projects.

abstract class Template<in T>() {
    abstract fun T.render()
}

open class Placeholder<T>() {
    private var content: (T.(Placeholder<T>) -> Unit)? = null

    operator fun invoke(content: T.(Placeholder<T>) -> Unit) {
        this.content = content
    }

    fun T.render() {
        content?.let {
            it(this@Placeholder)
        }
    }
}

fun <T> T.insert(placeholder: Placeholder<T>): Unit = with(placeholder) { render() }
