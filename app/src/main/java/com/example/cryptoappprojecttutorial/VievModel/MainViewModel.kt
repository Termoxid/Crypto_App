package com.example.cryptoappprojecttutorial.VievModel

import androidx.lifecycle.ViewModel
import com.example.cryptoappprojecttutorial.Repository.MainRepository

class MainViewModel(val repository: MainRepository):ViewModel() {
    constructor():this(MainRepository())

    fun loadData()  = repository.items
}