package net.eucalypto.speechcompanion.buttonlist

import android.content.Context
import android.media.SoundPool
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.eucalypto.speechcompanion.R
import net.eucalypto.speechcompanion.data.SoundBite
import timber.log.Timber

internal const val MAX_SOUNDS = 4


class ButtonListViewModel : ViewModel() {

    val soundPool: SoundPool = SoundPool.Builder()
        .setMaxStreams(MAX_SOUNDS)
        .build()

    val soundList = listOf(
        SoundBite("Yes", R.raw.dersuperanton_yes_male),
        SoundBite("No", R.raw.dersuperanton_no_male),
        SoundBite("Approving Hmm", R.raw.trimono_approving_hm)
    )

    fun loadSoundList(list: List<SoundBite>, context: Context) {
        for (sound in list) {
            loadSound(sound, context)
        }
    }

    private fun loadSound(sound: SoundBite, context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            val soundId = soundPool.load(context, sound.resId, 1)
            sound.soundId = soundId
            Timber.d("Loading sound with id: $soundId, from coroutine in Thread: ${Thread.currentThread().name}")
        }
    }

    override fun onCleared() {
        super.onCleared()
        soundPool.release()
    }
}