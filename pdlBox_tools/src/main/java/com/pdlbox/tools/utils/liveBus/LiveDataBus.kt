package com.pdlbox.tools.utils.liveBus

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

/**
 * 消息订阅发送
 */
object LiveDataBus {
    private val sSubjectMap: MutableMap<String, EventLiveData?> = HashMap()
    @Synchronized
    private fun getLiveData(subject: String): EventLiveData {
        var liveData: EventLiveData? = sSubjectMap[subject]
        if (liveData == null) {
            liveData = EventLiveData(subject)
            sSubjectMap[subject] = liveData
        }
        return liveData
    }

    fun subscribe(subject: String, lifecycle: LifecycleOwner, action: Observer<Any?>) {
        getLiveData(subject).observe(lifecycle, action)
    }

    fun unregister(subject: String) {
        sSubjectMap.remove(subject)
        Log.d("LiveDataBus", "remove subject $subject")
    }

    /**
     * pls refer to [androidx.lifecycle.LiveData.postValue]
     *
     * @param subject
     * @param message
     */
    fun postValue(subject: String, message: Any) {
        getLiveData(subject).update(message)
    }

    fun setValue(subject: String, message: Any) {
        getLiveData(subject).update(message)
    }
}