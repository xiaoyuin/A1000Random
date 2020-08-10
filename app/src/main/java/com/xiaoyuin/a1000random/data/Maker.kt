package com.xiaoyuin.a1000random.data

import androidx.navigation.NavDirections

abstract class Maker(val name: String) {

    abstract fun getNavDirection(savedChoiceMaker: SavedChoiceMaker): NavDirections
}