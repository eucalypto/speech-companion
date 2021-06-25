package net.eucalypto.speechcompanion.ui.buttonlist.soundbitebutton

import android.media.SoundPool
import androidx.lifecycle.ViewModel
import net.eucalypto.speechcompanion.data.SoundBite

class SoundbiteButtonViewModel(
    private val soundPool: SoundPool
) : ViewModel() {

    var sound: SoundBite? = null

    val title
        get() = sound?.title ?: ""


    fun onClick() {
        sound?.let {
            soundPool.play(it.soundId, 1f, 1f, 1, 0, 1f)
        }
    }
}