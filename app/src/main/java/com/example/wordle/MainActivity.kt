package com.example.wordle

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    private lateinit var wordToGuess: String
    private var guessCount = 0
    private var gameOver = false

    private lateinit var submitButton: Button
    private lateinit var resetButton: Button
    private lateinit var guessInput: EditText

    private lateinit var guess1: TextView
    private lateinit var guess1Check: TextView
    private lateinit var guess2: TextView
    private lateinit var guess2Check: TextView
    private lateinit var guess3: TextView
    private lateinit var guess3Check: TextView
    private lateinit var answerText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Buttons
        submitButton = findViewById(R.id.submitButton)
        resetButton = findViewById(R.id.resetButton)

        // Input
        guessInput = findViewById(R.id.guessInput)

        // Guess rows
        guess1 = findViewById(R.id.guess1Value)
        guess1Check = findViewById(R.id.guess1CheckValue)
        guess2 = findViewById(R.id.guess2Value)
        guess2Check = findViewById(R.id.guess2CheckValue)
        guess3 = findViewById(R.id.guess3Value)
        guess3Check = findViewById(R.id.guess3CheckValue)

        // Answer
        answerText = findViewById(R.id.answerText)

        startNewGame()

        submitButton.setOnClickListener {
            if (gameOver) return@setOnClickListener

            val guess = guessInput.text.toString().uppercase()

            if (guess.length != 4) {
                Toast.makeText(this, "Enter exactly 4 letters", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //val result = checkGuess(guess)
            val result = getColoredGuess(guess)
            guessCount++

            when (guessCount) {
                1 -> {
                    guess1.text = guess
                    guess1Check.setText(result, TextView.BufferType.SPANNABLE)
                }
                2 -> {
                    guess2.text = guess
                    guess2Check.setText(result, TextView.BufferType.SPANNABLE)                }
                3 -> {
                    guess3.text = guess
                    guess3Check.setText(result, TextView.BufferType.SPANNABLE)                }
            }

            guessInput.text.clear()
            hideKeyboard()

            if (guess == wordToGuess || guessCount == 3) {
                endGame()
            }
        }

        resetButton.setOnClickListener {
            startNewGame()
        }
    }

    private fun startNewGame() {
        wordToGuess = FourLetterWordList.getRandomFourLetterWord()
        guessCount = 0
        gameOver = false

        clearGuesses()
        answerText.visibility = View.GONE

        resetButton.visibility = View.GONE
        submitButton.visibility = View.VISIBLE

        guessInput.text.clear()
        hideKeyboard()
    }

    private fun clearGuesses() {
        guess1.text = "----"
        guess1Check.text = "----"
        guess2.text = "----"
        guess2Check.text = "----"
        guess3.text = "----"
        guess3Check.text = "----"
    }

    private fun endGame() {
        gameOver = true
        answerText.text = wordToGuess
        answerText.visibility = View.VISIBLE

        submitButton.visibility = View.GONE
        resetButton.visibility = View.VISIBLE

        hideKeyboard()
    }

    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }

    private fun getColoredGuess(guess: String): SpannableString {
        val spannable = SpannableString(guess)

        for (i in guess.indices) {
            val color = when {
                guess[i] == wordToGuess[i] -> {
                    ContextCompat.getColor(this, android.R.color.holo_green_dark)
                }
                guess[i] in wordToGuess -> {
                    ContextCompat.getColor(this, android.R.color.holo_red_dark)
                }
                else -> null
            }

            color?.let {
                spannable.setSpan(
                    ForegroundColorSpan(it),
                    i,
                    i + 1,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        }

        return spannable
    }


    private fun hideKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        val view = currentFocus ?: View(this)
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
