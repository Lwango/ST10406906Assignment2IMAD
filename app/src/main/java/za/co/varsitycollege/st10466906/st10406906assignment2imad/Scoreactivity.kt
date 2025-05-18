package za.co.varsitycollege.st10466906.st10406906assignment2imad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Scoreactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_scoreactivity)

        val score = intent.getIntExtra("score", 0)
        val questions = intent.getStringArrayExtra("questions") ?: arrayOf()
        val answers = intent.getBooleanArrayExtra("answers") ?: booleanArrayOf()

        val theScore = findViewById<TextView>(R.id.theScore)
        val feedBackQuestions = findViewById<TextView>(R.id.feedBackQuestions)
        val exitButton = findViewById<Button>(R.id.exitButton)
        val reviewButton = findViewById<Button>(R.id.reviewButton)

        theScore.text = "You got $score out of ${questions.size}"
        feedBackQuestions.text = if (score >= 3) "Congrats Mfethu" else "This is embarrassing dawg."

        reviewButton.setOnClickListener {
            val reviewMsg = buildString {
                for (i in questions.indices) {
                    append("Q: ${questions[i]}\nA: ${answers[i]}\n\n")
                }
            }

            AlertDialog.Builder(this)
                .setTitle("Review Answers")
                .setMessage(reviewMsg)
                .setPositiveButton("shap", null)
                .show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        exitButton.setOnClickListener {
            finishAffinity()
        }
    }
}
