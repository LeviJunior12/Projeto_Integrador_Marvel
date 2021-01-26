package com.example.projetointegradormarvel.home

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradormarvel.DataAdapter
import com.example.projetointegradormarvel.R
import com.example.projetointegradormarvel.Thumbnail
import com.example.projetointegradormarvel.characters.CharacterAdapter
import com.example.projetointegradormarvel.characters.CharactersResults
import com.example.projetointegradormarvel.characters.CharactersViewModel
import com.example.projetointegradormarvel.comics.ComicAdapter
import com.example.projetointegradormarvel.comics.ComicsResults
import com.example.projetointegradormarvel.comics.ComicsViewModel
import com.example.projetointegradormarvel.creators.CreatorAdapter
import com.example.projetointegradormarvel.creators.CreatorsResults
import com.example.projetointegradormarvel.creators.CreatorsViewModel
import com.example.projetointegradormarvel.database.AppDatabase
import com.example.projetointegradormarvel.services.*
import com.example.projetointegradormarvel.webService
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {

    private lateinit var db: AppDatabase
    private lateinit var repository: Repository
    private lateinit var repositoryComic: RepositoryComic
    private lateinit var repositoryCreator: RepositoryCreator

    private val viewModel by viewModels<HomeViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelCLass: Class<T>): T {
                return HomeViewModel(webService) as T
            }
        }
    }

    val viewModelCharacters by viewModels<CharactersViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return CharactersViewModel(repository) as T
            }
        }
    }

    val viewModelComics by viewModels<ComicsViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ComicsViewModel(repositoryComic) as T
            }
        }
    }

    val viewModelCreators by viewModels<CreatorsViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return CreatorsViewModel(repositoryCreator) as T
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        if(isOnline()) {

            viewModel.getCharacters(1)
            viewModel.getComics(1)
            viewModel.getCreators(1)

            view.rv_characters.layoutManager =
                LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
            viewModel.listCharacters.observe(viewLifecycleOwner, {
                rv_characters.adapter = CharacterAdapter(it, this)

                if(viewModel.listCharacters.value != null) {
                    addCharactersDatabase(viewModel.listCharacters.value!!)
                }

            })

            view.rv_comics.layoutManager =
                LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
            viewModel.listComics.observe(viewLifecycleOwner, {
                rv_comics.adapter = ComicAdapter(it, this)

                if(viewModel.listComics.value != null) {
                    addComicsDatabase(viewModel.listComics.value!!)
                }

            })

            view.rv_creators.layoutManager =
                LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
            viewModel.listCreators.observe(viewLifecycleOwner, {
                rv_creators.adapter = CreatorAdapter(it, this)

                if(viewModel.listCreators.value != null) {
                    addCreatorsDatabase(viewModel.listCreators.value!!)
                }
            })

        } else {
            getAllCharacterDatabase()
            getAllComicsDatabase()
            getAllCreatorsDatabase()

            view.rv_characters.layoutManager =
                LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
            viewModelCharacters.listCharacters.observe(viewLifecycleOwner, {
                rv_characters.adapter = CharacterAdapter(it, this)
            })

        view.rv_characters.layoutManager =
            LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
        viewModel.listCharacters.observe(viewLifecycleOwner, {
//            rv_characters.adapter = CharacterAdapter(it, this)
            rv_characters.adapter = DataAdapter(it, this)
        })

        view.rv_comics.layoutManager =
            LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
        viewModel.listComics.observe(viewLifecycleOwner, {
//            rv_comics.adapter = ComicAdapter(it, this)
            rv_comics.adapter = DataAdapter(it, this)
        })

        view.rv_creators.layoutManager =
            LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
        viewModel.listCreators.observe(viewLifecycleOwner, {
//            rv_creators.adapter = CreatorAdapter(it, this)
            rv_creators.adapter = DataAdapter(it, this)
        })

        return view
    }

    fun initDB() {
        db = AppDatabase.invoke(requireContext().applicationContext)
    }

    private fun getAllCharacterDatabase() {
        initDB()

        repository = ReposirotyImpl(db.characterDAO())
        viewModelCharacters.getAllCharacters()
    }

    private fun getAllComicsDatabase() {
        initDB()

        repositoryComic = RepositoryComics(db.comicsDAO())
        viewModelComics.getAllComics()
    }

    private fun getAllCreatorsDatabase() {
        initDB()

        repositoryCreator = RepositoryCreators(db.creatorsDAO())
        viewModelCreators.getAllCreators()
    }

    private fun addCharactersDatabase(characters: List<CharactersResults>) {
        initDB()
        repository = ReposirotyImpl(db.characterDAO())

        for(character in characters) {
            viewModelCharacters.addAllCharacter(CharactersResults(
                character.id,
                character.name,
                character.description,
                character.modified,
                character.thumbnail,
                character.resourceURI,
            ))
        }
    }

    private fun addComicsDatabase(comics: List<ComicsResults>) {
        initDB()
        repositoryComic = RepositoryComics(db.comicsDAO())

        for(comic in comics) {
            viewModelComics.addAllComics(ComicsResults(
                comic.id,
                comic.title,
                "description",
                comic.pageCount,
                comic.resourceURI,
                comic.thumbnail
            ))
        }

    }

    private fun addCreatorsDatabase(creators: List<CreatorsResults>) {
        initDB()
        repositoryCreator = RepositoryCreators(db.creatorsDAO())

        for(creator in creators) {
            viewModelCreators.addAllCreators(
                CreatorsResults(
                    creator.id,
                    creator.firstName,
                    creator.middleName,
                    creator.lastName,
                    creator.suffix,
                    creator.fullName,
                    creator.modified,
                    creator.thumbnail,
                    creator.resourceURI
                )
            )
        }
    }

    fun isOnline(): Boolean {
        val cm = requireContext().applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }

}