import commands.*
import net.dv8tion.jda.api.JDA
import util.parseCommandTemplate
import net.dv8tion.jda.api.entities.Activity

import util.*

private val BOT_TOKEN = System.getenv("BOT_TOKEN")

lateinit var bot: JDA

fun main() {
    val template = parseCommandTemplate("send ?in")
    println("template: $template")

    val input = "send lucy hello"
    println("input: $input")

    val call = parseCommandString(input)
    println("call: $call")

    val data = commandDataFromCall(call, template)
    println("data: $data")

    commands {
        command(Ping)
        command(Save)
        command(GetSaved)
        command(Ban)
        command(Bans)
        command(Kick)
        command(Kicks)
        command(Warn)
        command(Warnings)
        command(Help)
    }

    bot = jda(BOT_TOKEN) {
        eventListeners = arrayOf(CommandProxy.handler)
        activity = Activity.playing("!ping")
        build().awaitReady()
    }
}
