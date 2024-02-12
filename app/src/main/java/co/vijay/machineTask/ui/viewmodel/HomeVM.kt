package co.vijay.machineTask.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.vijay.machineTask.network.data.ResponseModel
import co.vijay.machineTask.repo.AppRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class HomeVM @Inject constructor(private val repository: AppRepo) : ViewModel() {

    private val _getData = MutableLiveData<Response<ResponseModel>>()
    val getData: LiveData<Response<ResponseModel>>
        get() = _getData

    fun getData() {
        CoroutineScope(Dispatchers.IO).launch {
            val a = repository.getData()
            _getData.postValue(a)
        }
    }
}