package org.hariom.jetpackandroid

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class Observer : DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d("Main", "Observer -  ON CREATE")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d("Main", "Observer -  ON ONSTART")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d("Main", "Observer -  ON PAUSE")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.d("Main", "Observer -  ON ONDESTROY")
    }
}