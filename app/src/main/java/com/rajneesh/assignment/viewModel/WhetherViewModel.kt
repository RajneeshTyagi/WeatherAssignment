package com.rajneesh.assignment.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.health.ness.repository.RepositoryCalls
import com.rajneesh.assignment.di.DaggerRepositoryComponent
import com.rajneesh.assignment.model.Current
import com.rajneesh.assignment.model.Location
import com.rajneesh.assignment.model.Request
import com.rajneesh.assignment.model.WhetherResponseModel
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class WhetherViewModel : ViewModel {
    private var request = MutableLiveData<Request>()
    private var location = MutableLiveData<Location>()
    private var current = MutableLiveData<Current>()

    @Inject
    lateinit var repositoryCalls: RepositoryCalls

    constructor() {
        DaggerRepositoryComponent.create().inject(this)
    }

    fun getRequest() = request
    fun getLocation() = location
    fun getCurrent() = current
    fun getCurrentWhether() {
//        Coroutines Api call
//        viewModelScope.launch(Dispatchers.IO) {
//            println("Thread Name is :- ${Thread.currentThread().name}")
//            try {
//                repositoryCalls.getLocationWhetherData("New Delhi")
//            } catch (e: java.lang.Exception) {
//            }
//        }

//    With RX java
        repositoryCalls.getLocationWhetherData(object : Observer<Any> {
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Any) {
                if (t is WhetherResponseModel) {
                    request.postValue(t.request)
                    location.postValue(t.location)
                    current.postValue(t.current)
                }
            }

            override fun onError(e: Throwable) {
            }
        }, "New Delhi")
    }
}