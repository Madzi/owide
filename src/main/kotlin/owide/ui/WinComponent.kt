package owide.ui

import kotlin.browser.window

object WinComponent {

    private var width = window.innerWidth
    private var height = window.innerHeight

    fun getWidth() = width
    fun getHeight() = height
    fun setWidth(w: Int): Unit {
        width = w
        window.resizeBy(width, height)
    }
    fun setheight(h: Int): Unit {
        height = h
        window.resizeBy(width, height)
    }

}