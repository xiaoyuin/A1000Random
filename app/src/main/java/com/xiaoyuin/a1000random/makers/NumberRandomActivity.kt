package com.xiaoyuin.a1000random.makers

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import androidx.navigation.NavDirections
import androidx.navigation.navArgs
import com.xiaoyuin.a1000random.MainFragmentDirections
import com.xiaoyuin.a1000random.R
import com.xiaoyuin.a1000random.data.*
import kotlinx.android.synthetic.main.activity_number_random.*
import kotlin.random.Random

class NumberRandomActivity : AppCompatActivity() {

    val args by navArgs<NumberRandomActivityArgs>()

    val repo: SavedChoiceMakerRepository by lazy { SavedChoiceMakerRepositoryImpl() }
    private val choiceCollectionRepo: ChoiceCollectionRepository by lazy { ChoiceCollectionRepositoryImpl() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_random)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val savedChoiceMaker = repo.get(args.savedChoiceMakerId)

        if (savedChoiceMaker != null) {
            val choiceCollection =
                choiceCollectionRepo.getChoiceCollection(savedChoiceMaker.choiceCollectionId)
            if (choiceCollection != null) {
                current_choices_text.text =
                    "Current choices: ${choiceCollection.choices.joinToString { it.text }}"
                start_button.setOnClickListener {
                    val rNum = Random.nextInt(choiceCollection.choices.size)
                    number_text.text = rNum.toString()
                    result_text.text = choiceCollection.choices[rNum].text
                }
            } else {
                throw NullPointerException()
            }
        } else {
            throw NullPointerException()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}

class NumberRandomMaker : Maker("Random Number") {
    override fun getNavDirection(savedChoiceMaker: SavedChoiceMaker): NavDirections {
        return MainFragmentDirections.actionMainFragmentToNumberRandomActivity2(savedChoiceMaker.id)
    }
}