package net.eucalypto.speechcompanion.ui.addvoice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import net.eucalypto.speechcompanion.databinding.AddVoiceFragmentBinding

class AddVoiceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding =
            AddVoiceFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }
}