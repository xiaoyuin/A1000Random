package com.xiaoyuin.a1000random.data

interface SavedChoiceMakerRepository {

    fun getAll(): List<SavedChoiceMaker>

    fun get(id: String): SavedChoiceMaker?

    fun add(choiceMaker: SavedChoiceMaker): Boolean

    fun remove(id: String): Boolean
}