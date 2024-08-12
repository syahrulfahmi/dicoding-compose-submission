package com.sf.dcd.compose.page.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sf.dcd.compose.core.data.source.DataResult
import com.sf.dcd.compose.core.domain.model.MovieDomain
import com.sf.dcd.compose.core.domain.usecase.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val movieUseCase: MovieUseCase) : ViewModel() {

    private val _movieUiState: MutableStateFlow<DataResult<MovieDomain.Result>> = MutableStateFlow(DataResult.Loading(null))
    val movieUiState: StateFlow<DataResult<MovieDomain.Result>> = _movieUiState

    init {
        getMovie()
    }

    private fun getMovie() {
        viewModelScope.launch {
            movieUseCase.getMovie().collect {
                _movieUiState.value = it
            }
        }
    }

}