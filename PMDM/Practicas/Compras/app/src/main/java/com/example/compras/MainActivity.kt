package com.example.compras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.compras.databinding.ActivityMainBinding
import org.json.JSONObject
import com.android.volley.Request.Method
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.compras.adaptadores.ProductosAdapter
import com.example.compras.model.Producto
import com.example.compras.ui.CompraActivity
import com.example.compras.ui.DetalleActivity
import com.example.compras.ui.dialog.BuscarDialog
import com.example.compras.ui.dialog.FiltrarDialog
import com.example.compras.ui.dialog.ResetDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), ProductosAdapter.OnProductoSelected,
    FiltrarDialog.OnCategoryDialogListener, ResetDialog.OnResetDialogListener, BuscarDialog.OnBuscarDialogListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listaProductos: ArrayList<Producto>
    private lateinit var listaCarrito: ArrayList<Producto>
    private lateinit var adaptadorProducto: ProductosAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaProductos = ArrayList()
        listaCarrito = ArrayList()

        adaptadorProducto = ProductosAdapter(listaProductos, this)
        binding.recyclerProductos.adapter = adaptadorProducto

        binding.recyclerProductos.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        getURLResponseProductos("https://dummyjson.com/products")

        binding.imageButtonCarrito.setOnClickListener {

        val intent = Intent(applicationContext,CompraActivity :: class.java)
        if (listaCarrito.size == 0){
            Snackbar.make(binding.root,"Lista de carrito vacia",Snackbar.LENGTH_SHORT).show()

        }else {
            intent.putExtra("listaCarrito", listaCarrito)
            startActivity(intent)
        }
        }
    }


    //SACAR EL MENU : sobreescribir
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_filtrar -> {
                val dialog = FiltrarDialog()
                dialog.show(supportFragmentManager, null)
            }

            R.id.menu_buscar -> {
                val dialog = BuscarDialog()
                dialog.show(supportFragmentManager, null)
            }

            R.id.menu_reset -> {
                val dialog = ResetDialog()
                dialog.show(supportFragmentManager, null)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun getURLResponseProductos(url: String): Unit {
        val peticion: JsonObjectRequest = JsonObjectRequest(
            Method.GET,
            url,
            null,
            { response ->
                getProductos(response)
            },
            { error ->
                Snackbar.make(
                    binding.root,
                    "Error de conexión: ${error.message}",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        )

        Volley.newRequestQueue(applicationContext).add(peticion)
    }

    fun getProductos(response: JSONObject) {
        listaProductos.clear()
        adaptadorProducto.notifyDataSetChanged()

        //sacar todos los productos:

        val results = response.getJSONArray("products")

        for (i in (0..results.length() - 1)) {
            val listaImagenes = ArrayList<String>()
            val product = results.getJSONObject(i);
            val title = product.getString("title")
            val price = product.getInt("price")
            val description = product.getString("description");
            val stock = product.getInt("stock");
            val thumbnail = product.getString("thumbnail")
            val images = product.getJSONArray("images")
            for (i in 0..<images.length()) {

                val imagenIndi = images.getString(i)
                listaImagenes.add(imagenIndi)
            }

            val producto = Producto(title, price, stock, description, thumbnail, listaImagenes)
            listaProductos.add(producto)
            adaptadorProducto.notifyDataSetChanged()
        }
    }

    override fun onCategorySelected(category: String) {
        if (category.isNotEmpty()) {
            getURLResponseProductos("https://dummyjson.com/products/category/$category")

        } else {
            Snackbar.make(binding.root, "No se seleccionaron categorías", Snackbar.LENGTH_SHORT)
                .show()
        }
    }

    override fun onButtonComprarClicked(producto: Producto) {
        listaCarrito.add(producto)
        binding.textNumeroCarrito.text = listaCarrito.size.toString()

    }

    override fun onButtonDetalleClicked(producto: Producto) {
        val intent = Intent(applicationContext,DetalleActivity :: class.java)
        intent.putExtra("producto",producto)

        startActivity(intent)
    }

    override fun onResetClicked() {
        getURLResponseProductos("https://dummyjson.com/products")
        listaCarrito.clear()
        binding.textNumeroCarrito.text = 0.toString()
    }

    override fun onButtonOKSelected(x: String) {
        getURLResponseProductos("https://dummyjson.com/products/search?q=$x")
    }
}