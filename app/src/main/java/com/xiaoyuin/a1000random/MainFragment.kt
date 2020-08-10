package com.xiaoyuin.a1000random

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.xiaoyuin.a1000random.data.ChoiceCollectionRepository
import com.xiaoyuin.a1000random.data.ChoiceCollectionRepositoryImpl
import com.xiaoyuin.a1000random.data.SavedChoiceMaker
import com.xiaoyuin.a1000random.data.TestData
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {

    private val choiceCollectionRepo: ChoiceCollectionRepository by lazy { ChoiceCollectionRepositoryImpl() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(main_recycler_view) {
            layoutManager = StaggeredGridLayoutManager(1, RecyclerView.VERTICAL)
            adapter = SavedChoiceMakerAdapter(choiceCollectionRepo) {
                val navDirection = it.maker.getNavDirection(it)
                findNavController().navigate(navDirection)
            }
        }
    }
}

class SavedChoiceMakerAdapter(
    private val choiceCollectionRepo: ChoiceCollectionRepository,
    private val onItemClicked: (SavedChoiceMaker) -> Unit
) : RecyclerView.Adapter<SavedChoiceMakerAdapter.ViewHolder>() {

    val testSavedChoiceMakers = listOf(TestData.savedChoiceMaker1, TestData.savedChoiceMaker2)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_saved_choice_maker, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return testSavedChoiceMakers.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val savedChoiceMaker = testSavedChoiceMakers[position]
        val choiceCollection = choiceCollectionRepo.getChoiceCollection(savedChoiceMaker.choiceCollectionId)
        holder.titleTextView.text = savedChoiceMaker.title
        holder.choicesTextView.text = "Choose from: ${choiceCollection?.choices?.joinToString { it.text }}"
        holder.makerTextView.text = savedChoiceMaker.maker.name
        holder.itemView.setOnClickListener { onItemClicked.invoke(savedChoiceMaker) }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.title_text)
        val choicesTextView: TextView = view.findViewById(R.id.choices_text)
        val makerTextView: TextView = view.findViewById(R.id.maker_text)
    }
}