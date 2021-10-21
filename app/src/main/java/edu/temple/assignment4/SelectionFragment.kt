package edu.temple.assignment4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import edu.temple.assignment4.ARG_PARAM1 as ARG_PARAM1

private const val ARG_PARAM1 = "param1"

class SelectionFragment : Fragment() {

    private lateinit var list: Array<ImageObject>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            list = it.getSerializable(ARG_PARAM1) as Array<ImageObject>
        }
        RecyclerView.Adapter() =ImageAdapter(requireContext(),list)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.fragment_selection, container, false)
        val recyclerView = layout.findViewById<RecyclerView>(R.id.recyclerView)
        val ViewModelPlayers = ViewModelProvider(requireActivity())
            .get(ViewModelPlayers::class.java)
        recyclerView.setOnClickListener() {

        }
        return layout
    }

    companion object {
        fun newInstance(param1: Array<ImageObject>) =
            SelectionFragment().apply {
                arguments?.let {
                   param1 = it.getSerializable(ARG_PARAM1) as Array<ImageObject>
                }
            }
    }
}