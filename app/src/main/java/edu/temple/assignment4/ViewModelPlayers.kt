package edu.temple.assignment4

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class ViewModelPlayers: ViewModel()  {

    private val players : MutableLiveData<ImageObject> by lazy {
        MutableLiveData<ImageObject>()
    }

    fun getPlayers () : LiveData<ImageObject> {
            return players
    }

    fun setSelectedPlayer (player: ImageObject) {
        this.players.value = player
    }
}