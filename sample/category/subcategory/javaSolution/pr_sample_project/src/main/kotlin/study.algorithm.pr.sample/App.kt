package study.algorithm.pr.sample

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

fun main(args: Array<String>) {
    println(App().greeting)
}
