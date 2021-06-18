package net.eucalypto.speechcompanion.buttonlist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import net.eucalypto.speechcompanion.data.SoundBite
import net.eucalypto.speechcompanion.databinding.SoundbiteButtonBinding

class SoundBiteAdapter :
    ListAdapter<SoundBite, SoundBiteViewHolder>(SoundBiteDiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SoundBiteViewHolder {
        return SoundBiteViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: SoundBiteViewHolder, position: Int) {
        val soundBite = getItem(position)
        holder.bindTo(soundBite)
    }
}

class SoundBiteViewHolder private constructor(private val binding: SoundbiteButtonBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindTo(soundBite: SoundBite) {
        binding.button.text = soundBite.title
    }


    companion object {
        fun from(parent: ViewGroup): SoundBiteViewHolder {
            val inflater = layoutInflaterFrom(parent)
            val binding =
                SoundbiteButtonBinding.inflate(inflater, parent, false)

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
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: SoundBite,
        newItem: SoundBite
    ): Boolean {
        return oldItem == newItem
    }
}
