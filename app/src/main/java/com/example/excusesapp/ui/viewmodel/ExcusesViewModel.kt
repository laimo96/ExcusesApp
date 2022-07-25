package com.example.excusesapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.excusesapp.repository.ExcusesRepository
import com.example.excusesapp.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ExcusesViewModel @Inject constructor(
    private val excusesRepository: ExcusesRepository
) : ViewModel() {

    private val _allExcuses: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val allExcuses: LiveData<UIState> get() = _allExcuses

    private val _familyExcuses: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val familyExcuses: LiveData<UIState> get() = _familyExcuses

    private val _officeExcuses: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val officeExcuses: LiveData<UIState> get() = _officeExcuses

    private val _childrenExcuses: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val childrenExcuses: LiveData<UIState> get() = _childrenExcuses

    private val _collegeExcuses: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val collegeExcuses: LiveData<UIState> get() = _collegeExcuses

    private val _partyExcuses: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val partyExcuses: LiveData<UIState> get() = _partyExcuses

    fun getAllExcuses() {
        CoroutineScope(Dispatchers.IO).launch {

            try {
                val response = excusesRepository.getAllExcuses()
                if (response.isSuccessful) {
                    response.body()?.let {

                        _allExcuses.postValue(UIState.SUCCESS(it))

                    } ?: throw Exception("Data Null")
                } else {
                    throw Exception(response.errorBody()?.string())
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _allExcuses.postValue(UIState.ERROR(e))
                }
            }
        }
    }

    fun getFamilyExcuses() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = excusesRepository.getFamilyExcuses()
                if (response.isSuccessful) {
                    response.body()?.let {

                        _familyExcuses.postValue(UIState.SUCCESS(it))

                    } ?: throw Exception("Data Null")
                } else {
                    throw Exception(response.errorBody()?.string())
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _familyExcuses.postValue(UIState.ERROR(e))
                }
            }
        }
    }

    fun getOfficeExcuses() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = excusesRepository.getOfficeExcuses()
                if (response.isSuccessful) {
                    response.body()?.let {

                        _officeExcuses.postValue(UIState.SUCCESS(it))

                    } ?: throw Exception("Data Null")
                } else {
                    throw Exception(response.errorBody()?.string())
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _officeExcuses.postValue(UIState.ERROR(e))
                }
            }
        }
    }

    fun getChildrenExcuses() {
        CoroutineScope(Dispatchers.IO).launch {

            try {
                val response = excusesRepository.getChildrenExcuses()
                if (response.isSuccessful) {
                    response.body()?.let {

                        _childrenExcuses.postValue(UIState.SUCCESS(it))

                    } ?: throw Exception("Data Null")
                } else {
                    throw Exception(response.errorBody()?.string())
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _childrenExcuses.postValue(UIState.ERROR(e))
                }
            }
        }
    }

    fun getCollegeExcuses() {
        CoroutineScope(Dispatchers.IO).launch {

            try {
                val response = excusesRepository.getCollegeExcuses()
                if (response.isSuccessful) {
                    response.body()?.let {

                        _collegeExcuses.postValue(UIState.SUCCESS(it))

                    } ?: throw Exception("Data Null")
                } else {
                    throw Exception(response.errorBody()?.string())
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _collegeExcuses.postValue(UIState.ERROR(e))
                }
            }
        }
    }

    fun getPartyExcuses() {
        CoroutineScope(Dispatchers.IO).launch {

            try {
                val response = excusesRepository.getPartyExcuses()
                if (response.isSuccessful) {
                    response.body()?.let {

                        _partyExcuses.postValue(UIState.SUCCESS(it))

                    } ?: throw Exception("Data Null")
                } else {
                    throw Exception(response.errorBody()?.string())
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _partyExcuses.postValue(UIState.ERROR(e))
                }
            }
        }
    }

    public override fun onCleared() {
        super.onCleared()
    }

}