package net.eucalypto.speechcompanion.buttonlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import net.eucalypto.speechcompanion.databinding.FragmentButtonListBinding

class ButtonListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding =
            FragmentButtonListBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentButtonListBinding.bind(view)

        binding.buttonListRecyclerview.layoutManager =
            LinearLayoutManager(context)
    }
}