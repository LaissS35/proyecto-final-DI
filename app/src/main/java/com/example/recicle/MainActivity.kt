package com.example.recicle

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toolbar
import androidx.activity.viewModels
import androidx.annotation.NonNull
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.recicle.comentarios.ComentarioAbstract
import com.example.recicle.comentarios.ComentarioViewModel
import com.example.recicle.comentarios.RepositorioComen
import com.example.recicle.comentarios.WordViewModelFactoryC
import com.example.recicle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val database by lazy {PeliculaAbstract.getDatabase(this)}
    val miRepositorio by lazy {Repositorio(database.miDAO(),database.miDAOComentarios())}
    val miViewModel: PeliculaViewModel by viewModels {WordViewModelFactory(miRepositorio)  }

    //var toolbar =actionBar

    val databaseC by lazy { ComentarioAbstract.getDatabase(this)}
    val miRepositorioC by lazy { RepositorioComen(databaseC.miDAOC()) }
    val miViewModelC: ComentarioViewModel by viewModels { WordViewModelFactoryC(miRepositorioC)  }

   // val vivi:V by viewModels() inactivo


    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        //getSupportActionBar()?.setTitle("Peliculas")
        //getSupportActionBar()?.setIcon(getDrawable(R.drawable.iconodocumentos));
        //fin toolbar

        val navController = findNavController(R.id.nav_host_fragment_content_main)

        appBarConfiguration = AppBarConfiguration(navController.graph)
        //setupActionBarWithNavController(navController, appBarConfiguration) coge el nombre automaticamente del fragmento, quitar antes de intentar nada

////EDITA EL KOTLIN

    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }



    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}