package com.example.projetointegradormarvel.creators

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
import kotlinx.android.synthetic.main.fragment_creators.view.*

class CreatorsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_creators, container, false)

        val data = arguments?.get("data") as CreatorsResults

        val imgURL =
            data.thumbnail.path.replace("http", "https") + "." + data.thumbnail.extension

        Picasso.get().load(imgURL).into(view.iv_frag_creators_image)
        view.tv_frag_creators_title.text = data.fullName
        view.tv_frag_creators_description.text = data.firstName

        view.iv_share_creator.setOnClickListener {
            val shareTask = view.tv_frag_creators_title.text.toString()
            val dialog = AlertDialog.Builder(requireContext()).setTitle("").setMessage("Share this creator ?")
                .setPositiveButton("Yes") { dialog, _ ->
                    setShareIntent(shareTask(shareTask))
                    dialog.dismiss()
                }
                .setNegativeButton("No") { dialog, _ ->
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
        startActivity(Intent.createChooser(sharingIntent, "Share Creator Name in Marvel Comics Wiki"))
    }
    fun shareTask(str: String): String {
        val resp = "Share Creator: \n$str\n Read more ? - https://www.marvel.com/"
        return resp
    }

    companion object {
        fun newInstance() = CreatorsFragment()
    }
}