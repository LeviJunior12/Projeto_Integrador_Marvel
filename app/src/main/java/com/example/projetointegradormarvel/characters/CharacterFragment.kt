package com.example.projetointegradormarvel.characters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projetointegradormarvel.R
import com.example.projetointegradormarvel.comics.ComicsResults
import com.example.projetointegradormarvel.database.AppDatabase
import com.example.projetointegradormarvel.models.model.Character
import com.example.projetointegradormarvel.services.Repository
import com.example.projetointegradormarvel.services.RepositoryImpl
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_character.*
import kotlinx.android.synthetic.main.fragment_character.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CharacterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CharacterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var db: AppDatabase
    private lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_character, container, false)

        val data = arguments?.get("data") as CharactersResults

        val imgURL =
            data.thumbnail.path.replace("http", "https") + "." + data.thumbnail.extension

        Picasso.get().load(imgURL).into(view.iv_frag_character_image)
        view.tv_frag_character_title.text = data.name
        view.tv_frag_character_description.text = data.description

        initBD()

        repository = RepositoryImpl(db.characterDAO())

        val viewModel by viewModels<CharacterViewModel> {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return CharacterViewModel(repository) as T
                }
            }
        }

        // viewModel.addCharacter(Character(data.id, data.name, data.description))

        return view
    }

    fun initBD() {
        db = AppDatabase.invoke(requireContext().applicationContext)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CharacterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CharacterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}