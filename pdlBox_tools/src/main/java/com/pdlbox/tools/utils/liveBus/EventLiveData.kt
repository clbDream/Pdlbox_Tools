package com.pdlbox.tools.utils.liveBus

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.pdlbox.tools.utils.liveBus.LiveDataBus.unregister


class EventLiveData(private val mSubject: String) : LiveData<Any?>() {
    fun update(`object`: Any?) {
        postValue(`object`)
    }

    override fun removeObserver(observer: Observer<in Any?>) {
        super.removeObserver(observer)
        if (!hasObservers()) {
            unregister(mSubject)
        }
    }

    override fun removeObservers(owner: LifecycleOwner) {
        super.removeObservers(owner)
        if (!hasObservers()) {
            unregister(mSubject)
        }
    }
}
