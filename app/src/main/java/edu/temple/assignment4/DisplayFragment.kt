package edu.temple.assignment4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider


class DisplayFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.fragment_display, container, false)
        return layout;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewModelProvider(requireActivity())
            .get(ViewModelPlayers::class.java)
            .getPlayers()
            .observe(requireActivity(), {
                changeImage(it)
            })
    }

    private fun changeImage(player : ImageObject) {
        view?.findViewById<ImageView>(R.id.playerPicture).setImageResource(player.imageId)
        view?.findViewById<TextView>(R.id.playerName).text = player.text

    }
}