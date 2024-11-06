import kotlin.math.abs
import kotlin.math.max
import kotlin.random.Random

interface Task {
    fun perform()
    fun isCorrect(): Boolean
}

abstract class AbstractTask : Task {
    protected var answer: Int = -1

    override fun perform() {
        printQuestion()
        readAnswer()
    }

    abstract fun printQuestion()

    private fun readAnswer() {
        answer = readln().toInt()
    }
}

class LettersTask : AbstractTask() {
    private val lowercaseLetter = CharArray(SIZE)
    private val uppercaseLetter = CharArray(SIZE)

    init {
        repeat(SIZE) {
            lowercaseLetter[it] = nextChar()
            uppercaseLetter[it] = if (Random.nextBoolean()) lowercaseLetter[it] else nextChar()
        }
    }

    override fun printQuestion() {
        println(lowercaseLetter.joinToString(" "))
        println(uppercaseLetter.joinToString(" ") { it.uppercase() })
    }

    override fun isCorrect() = (lowercaseLetter zip uppercaseLetter).count { (a, b) -> a == b } == answer

    companion object {
        private const val SIZE = 4
        private const val ABC_SIZE = 'z' - 'a' + 1
        private fun nextChar() = ('a'.code + Random.nextInt(0, ABC_SIZE)).toChar()
    }
}

class DigitTask : AbstractTask() {
    private val digits = IntArray(SIZE)

    init {
        repeat(SIZE) { digits[it] = Random.nextInt(0, 100) }
    }

    override fun printQuestion() {
        println(digits.joinToString(" "))
    }

    override fun isCorrect(): Boolean {
        val sorted = digits.sorted()
        return abs(answer - sorted[1]) == max(sorted[1] - sorted[0], sorted[2] - sorted[1])
    }

    companion object {
        private const val SIZE = 3
    }
}

fun main(args: Array<String>) {
    val taskNumber = try {
        args.first().toInt()
    } catch (e: Exception) {
        10
    }
    val tasks: List<Task> = List(taskNumber) { if (Random.nextBoolean()) LettersTask() else DigitTask() }
    tasks.forEach { it.perform() }

    println("Question number: $taskNumber")
    val correctAnswers = tasks.count { it.isCorrect() }
    println("Correct answers: $correctAnswers")
    println("Rate: ${(correctAnswers * 100).toDouble() / taskNumber}")
}