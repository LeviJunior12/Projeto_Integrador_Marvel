package com.example.projetointegradormarvel.comics

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.projetointegradormarvel.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_character.view.*
import kotlinx.android.synthetic.main.fragment_comics.view.*

class ComicsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_comics, container, false)

        val data = arguments?.get("data") as ComicsResults

        val imgURL =
            data.thumbnail.path.replace("http", "https") + "." + data.thumbnail.extension

        Picasso.get().load(imgURL).into(view.iv_frag_comics_image)

        view.tv_frag_comics_title.text = data.title
        view.tv_frag_comics_description.text = data.description

        view.iv_share_comics.setOnClickListener {
            val shareTask = view.tv_frag_comics_title.text.toString()
            val dialog = AlertDialog.Builder(requireContext()).setTitle("").setMessage("Share this comic ?")
                .setPositiveButton("Yes") { dialog, _ ->
                    setShareIntent(shareTask(shareTask))
                    dialog.dismiss()
                }
                .setNegativeButton("Não") { dialog, _ ->
                    dialog.dismiss()
                }
            dialog.show()
        }

        return view
    }

    private fun setShareIntent(shareBody: String){
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody)
        startActivity(Intent.createChooser(sharingIntent, "Share Comics Name in Marvel Comics Wiki"))
    }
    fun shareTask(str: String): String {
        val resp = "Share Comic:\n$str\n Read more ? - https://www.marvel.com/"
        return resp
    }


    companion object {
        fun newInstance() = ComicsFragment()
    }
}