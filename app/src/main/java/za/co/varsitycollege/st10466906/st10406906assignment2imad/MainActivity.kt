package za.co.varsitycollege.st10466906.st10406906assignment2imad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val begin: Button = findViewById<Button>(R.id.begin)
        begin.setOnClickListener { val intent = Intent(this,QuizQuestionsActivity::class.java)
        startActivity(intent)
//added button to direct user to the next page//
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.trueButton)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets


            }
        }
    }
}