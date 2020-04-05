package com.health.ness.repository

import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RepositoryCalls(var mApiService: ApiServices) {


    //    Network calls
    fun getLocationWhetherData(context: Observer<Any>, locationName: String) =
        mApiService.getLocationWhetherData(
            "fd7acdb7154ec2250c65e23683e3a23d",
            locationName
        ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribeWith(context)
}
