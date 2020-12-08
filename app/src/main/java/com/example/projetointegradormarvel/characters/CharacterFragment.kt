package com.example.projetointegradormarvel.characters

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.HORIZONTAL
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradormarvel.R
import com.example.projetointegradormarvel.model.viewModelCharacters
import com.example.projetointegradormarvel.repository.serv
import kotlinx.android.synthetic.main.fragment_home.view.*


// ao vier aqui, adicione o adapter com o onClickHQ e implemente-o
class CharacterFragment : Fragment(), CharacterAdapter.onClickHQ {

    var offset = 1000

    // criar o adapter e o layout para uso
    private lateinit var adapterCharacter: CharacterAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    private val viewModel by viewModels<viewModelCharacters>{
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return viewModelCharacters(serv) as T
            }
        }
    }

    @SuppressLint("WrongConstant")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         val view = inflater.inflate(R.layout.fragment_character, container, false)

        linearLayoutManager = LinearLayoutManager(context, HORIZONTAL, false)
        view.rv_characters.layoutManager = linearLayoutManager

        viewModel.listCharacters.observe(viewLifecycleOwner,{
            adapterCharacter = CharacterAdapter(it as ArrayList<Personagens.ResultTeste>, this)
            view.rv_characters.adapter = adapterCharacter
        })

        viewModel.getListCharacters(offset)
        setScrollView(view)

        return view
    }



    override fun hqClick(position: Int) {

        viewModel.listCharacters.observe(this, {
            val selectHQ = it[position]

            val bundle = bundleOf("chave" to selectHQ)
//            findNavController().navigate(R.id.action_fragmentListHQ_to_fragmentDetail, bundle)
        })
    }

    private fun setScrollView(view: View) {
        view.rv_characters?.run {
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    val itensTotal = adapterCharacter.itemCount
                    val itensVisible = linearLayoutManager.childCount
                    val itensPass = linearLayoutManager.findFirstVisibleItemPosition()

                    if ((itensVisible + itensPass) == itensTotal) {
                        offset++
                        viewModel.getListCharacters(offset)
                    }
                }
            })
        }
    }

}