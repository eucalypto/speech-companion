package net.eucalypto.speechcompanion.ui.buttonlist

import android.content.Context
import android.media.SoundPool
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import net.eucalypto.speechcompanion.ui.buttonlist.soundbitebutton.SoundbiteButtonViewModel
import net.eucalypto.speechcompanion.data.SoundBite
import net.eucalypto.speechcompanion.databinding.SoundbiteButtonBinding

class SoundBiteAdapter(private val soundPool: SoundPool) :
    ListAdapter<SoundBite, SoundBiteViewHolder>(SoundBiteDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SoundBiteViewHolder {
        return SoundBiteViewHolder.from(parent, soundPool)
    }

    override fun onBindViewHolder(holder: SoundBiteViewHolder, position: Int) {
        val soundBite = getItem(position)
        holder.bindTo(soundBite)
    }
}

class SoundBiteViewHolder private constructor(private val binding: SoundbiteButtonBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindTo(soundBite: SoundBite) {
        binding.viewModel?.apply { sound = soundBite }
        binding.executePendingBindings()
    }


    companion object {

        fun from(parent: ViewGroup, soundPool: SoundPool): SoundBiteViewHolder {
            val inflater = layoutInflaterFrom(parent)
            val binding = SoundbiteButtonBinding
                .inflate(inflater, parent, false).apply {
                    viewModel = SoundbiteButtonViewModel(soundPool)
                }
            return SoundBiteViewHolder(binding)
        }

        private fun layoutInflaterFrom(parent: ViewGroup) =
            parent.context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE)
                    as LayoutInflater

    }

}

class SoundBiteDiffCallback : DiffUtil.ItemCallback<SoundBite>() {
    override fun areItemsTheSame(
        oldItem: SoundBite,
        newItem: SoundBite
    ): Boolean {
        return oldItem.resId == newItem.resId
    }

    override fun areContentsTheSame(
        oldItem: SoundBite,
        newItem: SoundBite
    ): Boolean {
        return oldItem == newItem
    }
}
