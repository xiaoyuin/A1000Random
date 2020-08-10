package com.xiaoyuin.a1000random.data

class SavedChoiceMakerRepositoryImpl : SavedChoiceMakerRepository {

    val choiceMakerMap = mutableMapOf<String, SavedChoiceMaker>(
        TestData.savedChoiceMaker1.id to TestData.savedChoiceMaker1,
        TestData.savedChoiceMaker2.id to TestData.savedChoiceMaker2
    )

    override fun getAll(): List<SavedChoiceMaker> {
        return choiceMakerMap.values.toList()
    }

    override fun get(id: String): SavedChoiceMaker? {
        return choiceMakerMap[id]
    }

    override fun add(choiceMaker: SavedChoiceMaker): Boolean {
        choiceMakerMap[choiceMaker.id] = choiceMaker
        return true
    }

    override fun remove(id: String): Boolean {
        return choiceMakerMap.remove(id) != null
    }
}