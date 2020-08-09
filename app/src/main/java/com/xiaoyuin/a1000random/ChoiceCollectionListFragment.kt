package com.xiaoyuin.a1000random

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.fragment.app.Fragment
import com.xiaoyuin.a1000random.data.ChoiceCollectionRepository
import com.xiaoyuin.a1000random.data.ChoiceCollectionRepositoryImpl

/**
 * A fragment representing a list of Items.
 */
class ChoiceCollectionListFragment : Fragment() {

    private var columnCount = 1

    private val choiceRepo: ChoiceCollectionRepository by lazy { ChoiceCollectionRepositoryImpl() }

    private val listData = choiceRepo.getAll().map { collection ->
        mapOf("title" to collection.title, "choices" to collection.choices.joinToString { it.text })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_choices_list, container, false)

        // Set the adapter
        if (view is ListView) {
            with(view) {
                adapter = SimpleAdapter(
                    context,
                    listData,
                    android.R.layout.simple_list_item_2,
                    arrayOf("title", "choices"),
                    intArrayOf(android.R.id.text1, android.R.id.text2)
                )
            }
        }
        return view
    }

    companion object {

        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int) =
            ChoiceCollectionListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}