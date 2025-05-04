package za.co.varsitycollege.st10466906.st10406906assignment2imad

import android.os.Bundle
import android.view.inputmethod.TextAttribute
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizzquestionsActivity : AppCompatActivity() {
    private val quizzQuestions= arrayOf(
     "is 1 + 1 =2?","is 2 an odd number?","are there 100 googl in a zero?","is 100 divisbale by 2?","is 10 larger than 9?"
    )
    private val answers = booleanArrayOf(true,false,true,true,true)
    private var currentIndex = 0
    private var score = 0
    private lateinit var quizzQuestions:TextView
    private lateinit var feedBackQuestions:TextView
    private lateinit var nextPage:Button
    private lateinit var trueButton:Button
    private lateinit var falseButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.quizzquestions)
        quizzQuestions = findViewById(R.id.quizzQuestions)
        feedBackQuestions = findViewById(R.id.feedBackQuestions)
        nextPage = findViewById(R.id.nextPage)
        falseButton = findViewById(R.id.falseButton)
        trueButton = findViewById(R.id.trueButton)
        loadQuestion()
        trueButton.setOnClickListener { handleAnswer(true) }
        falseButton.setOnClickListener { handleAnswer(false) }

        nextPage.setOnClickListener {
            currentIndex++
            if (currentIndx < questions.size) {
                loadQuestion()
            } else {
                val intent = Intent(this,ScoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("questions", questions)
                intent.putExtra("answers", answers)
                startActivity(intent)
                finish()
            }
        }
    private fun loadQuestion() {
        quizzQuestions.text = questions[currentIndex]
        feedBackQuestions.text = ""
        nextPage.isEnabled = false
        trueButton.isEnabled = true
        falseButton.isEnabled = true
    }
    private fun handleAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentIndex]
        if (userAnswer == correctAnswer) {
            feedBackQuestions = "Correct"
            score++
        } else {
            feedBackQuestions.text = "Incorrect"

        }
        trueButton.isEnabled = false
        falseButton.isEnabled = true
        nextPage.isEnabled = true



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.trueButton)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}