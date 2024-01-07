package com.example.compras.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.compras.R
import com.example.compras.adaptadores.ComprasAdapter
import com.example.compras.databinding.ActivityCompraBinding
import com.example.compras.model.Producto
import com.google.android.material.snackbar.Snackbar

class CompraActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCompraBinding
    private lateinit var listaCarrito : ArrayList<Producto>
    private lateinit var adapter: ComprasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompraBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listaCarrito = ArrayList()

        adapter = ComprasAdapter(this, listaCarrito)
        binding.recyclerCompra.adapter = adapter
        binding.recyclerCompra.layoutManager =
            LinearLayoutManager(applicationContext, VERTICAL, false)


        listaCarrito = intent.getSerializableExtra("listaCarrito") as ArrayList<Producto>


    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_compras, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_comprar->{
                Snackbar.make(binding.root,"¿Desea realizar la compra?",Snackbar.LENGTH_INDEFINITE).setAction("OK"){
                    Toast.makeText(this,"Compra realizada",Toast.LENGTH_SHORT).show()
                }.show()
            }
        }

        return super.onOptionsItemSelected(item)
    }


}