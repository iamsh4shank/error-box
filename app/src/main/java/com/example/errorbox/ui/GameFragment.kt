package com.example.errorbox.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.errorbox.R
import com.example.errorbox.databinding.FragmentGameBinding


class GameFragment : Fragment() {
    data class Question(
            val text: String,
            val answers: List<String>)

    // The first answer is the correct one.  We randomize the answers before showing the text.
    // All questions must have four answers.  We'd want these to contain references to string
    // resources so we could internationalize. (or better yet, not define the questions in code...)
    private val questions: MutableList<Question> = mutableListOf(
            Question(text = "What is Android Jetpack?",
                    answers = listOf("all of these", "tools", "documentation", "libraries")),
            Question(text = "Base class for Layout?",
                    answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")),
            Question(text = "Layout for complex Screens?",
                    answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")),
            Question(text = "Pushing structured data into a Layout?",
                    answers = listOf("Data Binding", "Data Pushing", "Set Text", "OnClick")),
            Question(text = "Inflate layout in fragments?",
                    answers = listOf("onCreateView", "onActivityCreated", "onCreateLayout", "onInflateLayout")),
            Question(text = "Build system for Android?",
                    answers = listOf("Gradle", "Graddle", "Grodle", "Groyle")),
            Question(text = "Android vector format?",
                    answers = listOf("VectorDrawable", "AndroidVectorDrawable", "DrawableVector", "AndroidVector")),
            Question(text = "Android Navigation Component?",
                    answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher")),
            Question(text = "Registers app with launcher?",
                    answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher")),
            Question(text = "Mark a layout for Data Binding?",
                    answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>"))
    )

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    var score:Int = 0
    private val imageArray: MutableList<Int> = mutableListOf<Int>(R.drawable.ic_online_class, R.drawable.ic_quix_1,
            R.drawable.ic_quiz_2, R.drawable.ic_quiz_4, R.drawable.ic_exam, R.drawable.ic_quiz_5, R.drawable.ic_quiz6, R.drawable.ic_quiz_7)
    private val numQuestions = Math.min((questions.size + 1) / 2, 3)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
                inflater, R.layout.fragment_game, container, false)

        // Shuffles the questions and sets the question index to the first question.
        randomizeQuestions()
        var tvScore:TextView = binding.tvScore
        // Bind this fragment class to the layout
        binding.game = this

        // Set the onClickListener for the submitButton
        binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId
            // Do nothing if nothing is checked (id == -1)
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.secondAnswerRadioButton -> answerIndex = 1
                    R.id.thirdAnswerRadioButton -> answerIndex = 2
                    R.id.fourthAnswerRadioButton -> answerIndex = 3
                }
                // The first answer in the original question is always the correct one, so if our
                // answer matches, we have the correct answer.


                //If the answer is correct
                //TODO


                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    //score += 1
                    questionIndex++
                    if (questionIndex < numQuestions) {
                        currentQuestion = questions[questionIndex]
                        Toast.makeText(activity, getString(R.string.correct_ans), Toast.LENGTH_SHORT).show()
                        //setQuestion()
                        val random: Int = (0..7).shuffled().first()
                        binding.questionImage.setImageResource(0)
                        binding.questionImage.setBackgroundResource(imageArray[random])
                        binding.invalidateAll()
                        tvScore.text = score.toString()
                    }
                } else {

                    //If the answer is wrong just change the question
                    questionIndex++
                    setQuestion()
                    val random: Int = (0..7).shuffled().first()
                    binding.questionImage.setImageResource(0)
                    binding.questionImage.setBackgroundResource(imageArray[random])
                    Toast.makeText(activity, getString(R.string.wrong_ans), Toast.LENGTH_SHORT).show()
                    binding.invalidateAll()

                }

                if (questionIndex>=3) {
                    if (score<2 ) {
                        val nextFrag = GameOverFragment()
                        activity!!.supportFragmentManager.beginTransaction()
                                .replace(R.id.container_a, nextFrag, "findThisFragment")
                                .addToBackStack(null)
                                .commit()
                    }
                    //TODO
                    //winning condition
                    //write function to open GameWonFragment
                    if (score >=2) {

                        /*val nextFrag = GameWonFragment()
                        activity!!.supportFragmentManager.beginTransaction()
                                .replace(R.id.container_a, nextFrag, "findThisFragment")
                                .addToBackStack(null)
                                .commit()*/
                    }
                }
            }
        }
        return binding.root
    }

    // randomize the questions and set the first question
    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    // Sets the question and randomizes the answers.  This only changes the data, not the UI.
    // Calling invalidateAll on the FragmentGameBinding updates the data.
    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // and shuffle them
        answers.shuffle()
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_android_trivia_question, questionIndex + 1, numQuestions)
    }

}