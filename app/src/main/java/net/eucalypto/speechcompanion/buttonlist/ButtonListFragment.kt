package net.eucalypto.speechcompanion.buttonlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import net.eucalypto.speechcompanion.data.SoundBite
import net.eucalypto.speechcompanion.databinding.ButtonListFragmentBinding

class ButtonListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding =
            ButtonListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = ButtonListFragmentBinding.bind(view)



        binding.buttonListRecyclerview.apply {
            adapter = SoundBiteAdapter().apply {
                submitList(
                    listOf(
                        SoundBite(0, "Foo"),
                        SoundBite(1, "bar"),
                        SoundBite(2, "bacon")
                    )
                )
            }
            layoutManager = LinearLayoutManager(context)
        }
    }
}