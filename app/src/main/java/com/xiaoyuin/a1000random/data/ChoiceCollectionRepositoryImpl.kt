package com.xiaoyuin.a1000random.data

class ChoiceCollectionRepositoryImpl: ChoiceCollectionRepository {

    val choiceCollectionMap = mutableMapOf<String, ChoiceCollection>(
        TestData.choiceCollection1.id to TestData.choiceCollection1,
        TestData.choiceCollection2.id to TestData.choiceCollection2
    )

    override fun getAll(): List<ChoiceCollection> {
        return choiceCollectionMap.values.toList()
    }

    override fun getChoiceCollection(id: String): ChoiceCollection? {
        return choiceCollectionMap[id]
    }

    override fun saveChoiceCollection(choiceCollection: ChoiceCollection): Boolean {
        choiceCollectionMap[choiceCollection.id] = choiceCollection
        return true
    }

    override fun deleteChoiceCollection(id: String): Boolean {
        return choiceCollectionMap.remove(id) != null
    }
}