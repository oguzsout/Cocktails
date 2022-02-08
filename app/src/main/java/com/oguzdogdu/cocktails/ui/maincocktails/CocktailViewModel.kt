package com.oguzdogdu.cocktails.ui.maincocktails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oguzdogdu.cocktails.domain.use_case.CocktailUseCase
import com.oguzdogdu.cocktails.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CocktailViewModel @Inject constructor(private val useCase: CocktailUseCase) : ViewModel() {
    private val _cocktailList = MutableStateFlow(CocktailState())
    val cocktailList: StateFlow<CocktailState>
        get() = _cocktailList

    fun getSearchCocktails(cocktailName: String) {
        useCase(cocktailName).onEach {
            when (it) {
                is Resource.Loading -> {
                    _cocktailList.value = CocktailState(isLoading = true)
                }
                is Resource.Success -> {
                    _cocktailList.value = CocktailState(data = it.data)
                }
                is Resource.Error -> {
                    _cocktailList.value = CocktailState(error = it.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }
}