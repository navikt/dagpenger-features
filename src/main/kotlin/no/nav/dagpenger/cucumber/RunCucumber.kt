package no.nav.dagpenger.cucumber

import cucumber.api.cli.Main

val args = arrayOf(
    "-g", "no.nav.dagpenger",
    "-p", "pretty",
//    "-p", " json:build/cucumber.json",
    "classpath:features",
    "--tags", "not @ignored ")

fun main() {
    Main.main(args)
}
