package za.co.varsitycollege.st10466906.st10406906assignment2imad

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class QuizQuestionsActivity : AppCompatActivity() {

    private val questions = arrayOf(
        "Is 1 + 1 = 2?",
        "Is 2 an odd number?",
        "Are there 100 zeros in a googol?",
        "Is 100 divisible by 2?",
        "Is 10 larger than 9?"
    )
//added my list of questions to my array//
    private val answers = booleanArrayOf(true, false, true, true, true)
    private var currentIndex = 0
    private var score = 0

    private lateinit var questionTextView: TextView
    private lateinit var feedbackTextView: TextView
    private lateinit var nextPage: Button
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
//declaring none null variables//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.quizzquestions)

        questionTextView = findViewById(R.id.mathQuestions)
        feedbackTextView = findViewById(R.id.feedBackQuestions)
        nextPage = findViewById(R.id.nextPage)
        falseButton = findViewById(R.id.falseButton)
        trueButton = findViewById(R.id.trueButton)

        loadQuestion()

        trueButton.setOnClickListener { handleAnswer(true) }
        falseButton.setOnClickListener { handleAnswer(false) }
    //adding buttons for true and false questions//
        nextPage.setOnClickListener {
            currentIndex++
            if (currentIndex < questions.size) {
                loadQuestion()
            } else {
                val intent = Intent(this, Scoreactivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("questions", questions)
                intent.putExtra("answers", answers)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun loadQuestion() {
        questionTextView.text = questions[currentIndex]
        feedbackTextView.text = ""
        trueButton.isEnabled = true
        falseButton.isEnabled = true
        nextPage.isEnabled = false
    }

    private fun handleAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentIndex]
        if (userAnswer == correctAnswer) {
            feedbackTextView.text = "Correct"
            score++
        } else {
            feedbackTextView.text = "Incorrect"
        }

        trueButton.isEnabled = false
        falseButton.isEnabled = false
        nextPage.isEnabled = true
    }
}
