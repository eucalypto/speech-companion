package net.eucalypto.speechcompanion.buttonlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.eucalypto.speechcompanion.databinding.ButtonListFragmentBinding

class ButtonListFragment : Fragment() {

    private val viewModel: ButtonListViewModel by viewModels()

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




        setUpRecyclerView(binding.buttonListRecyclerview)
    }

    private fun setUpRecyclerView(recycler: RecyclerView) {
        recycler.apply {
            adapter = SoundBiteAdapter(viewModel.soundPool).apply {
                viewModel.loadSoundList(viewModel.soundList, requireContext())
                submitList(viewModel.soundList)
            }
            layoutManager = LinearLayoutManager(context)
        }
    }
}