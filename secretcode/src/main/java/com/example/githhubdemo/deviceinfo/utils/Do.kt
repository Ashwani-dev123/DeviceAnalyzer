package com.example.githhubdemo.deviceinfo.utils

object Do {

    /**
     * Indicates to the linter that the following when statement should be exhaustive.
     *
     * @sample Do exhaustive when (bool) {
     *     true -> Unit
     *     false -> Unit
     * }
     */
    inline infix fun <reified T> exhaustive(any: T?) = any
}
