package com.example.accessibilitysamples.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.accessibilitysamples.databinding.ActivityHomeBinding
import com.example.accessibilitysamples.ui.dynamicList.DynamicListActivity
import com.example.accessibilitysamples.ui.readCustomText.CustomReadActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val adapter = DashHomeAdapter(::onItemClicked)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.rvOptions.adapter = adapter
        adapter.submitList(
            listOf(
                DashItem(
                    title = "Leitura de textos",
                    description = "Faça com que a acessibilidade leia um texto de forma customizada."
                ),
                DashItem(
                    title = "Lista Dinâmica",
                    description = "Carregamento de conteúdo de uma lista de forma dinâmica para que a acessibilidade possa ler de forma correta."
                ),
                DashItem(
                    title = "Exemplo não mapeado",
                    description = "Crie um outro exemplo de acessibilidade mostrando um outro comportamento diferente que possa ser customizado."
                )
            )
        )
    }

    private fun onItemClicked(position: Int) {
        when (position) {
            0 -> CustomReadActivity.start(this)
            1 -> DynamicListActivity.start(this)
        }
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, HomeActivity::class.java))
        }
    }
}