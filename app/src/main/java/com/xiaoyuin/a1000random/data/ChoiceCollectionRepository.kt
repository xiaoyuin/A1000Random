package com.xiaoyuin.a1000random.data

interface ChoiceCollectionRepository {

    fun getAll(): List<ChoiceCollection>

    fun getChoiceCollection(id: String): ChoiceCollection?

    fun saveChoiceCollection(choiceCollection: ChoiceCollection): Boolean

    fun deleteChoiceCollection(id: String): Boolean
}