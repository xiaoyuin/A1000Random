package com.xiaoyuin.a1000random.data

import com.xiaoyuin.a1000random.makers.NumberRandomMaker

object TestData {

    val choiceCollection1 = ChoiceCollection(
        "test_choice_collection1",
        "What to eat?",
        listOf(
            Choice("Chicken"),
            Choice("Beef"),
            Choice("Pork")
        )
    )

    val choiceCollection2 = ChoiceCollection(
        "test_choice_collection2",
        "Android Heroes",
        listOf(
            Choice("Andreas"),
            Choice("Bruno"),
            Choice("Xiaoyu"),
            Choice("Adrian"),
            Choice("Roland"),
            Choice("Alex"),
            Choice("Kalum")
        )
    )

    val savedChoiceMaker1 = SavedChoiceMaker(
        "test_saved_choiceMaker1",
        "What to eat?",
        choiceCollection1.id,
        maker = NumberRandomMaker()
    )

    val savedChoiceMaker2 = SavedChoiceMaker(
        "test_saved_choiceMaker2",
        "Android StandUp Selection",
        choiceCollection2.id,
        maker = NumberRandomMaker()
    )
}