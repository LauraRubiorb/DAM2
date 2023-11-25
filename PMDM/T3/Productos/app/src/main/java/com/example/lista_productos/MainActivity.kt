package com.example.lista_productos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lista_productos.adapter.adaptadorProductos
import com.example.lista_productos.data.ProductoDataSet
import com.example.lista_productos.databinding.ActivityMainBinding
import com.example.lista_productos.model.Producto
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(),adaptadorProductos.OnRecyclerProductosListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: adaptadorProductos
    private lateinit var listaProductos: ArrayList<Producto>
    private lateinit var listaCesta : ArrayList<Producto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //inicializar binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //recuperar una lista
        //si es nulo te creas como un array vacio
        listaCesta = savedInstanceState?.getParcelableArrayList("cesta")?:ArrayList()
        listaProductos = savedInstanceState?.getParcelableArrayList("lista")?:ArrayList()
        //Asociooooo
        adapter = adaptadorProductos(listaProductos,this)
        binding.listaProductos.adapter = adapter
        //forma en la quemuestre
        binding.listaProductos.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)

        binding.botonAdd.setOnClickListener{
            //listaProductos.add( ProductoDataSet.getProducto())
            val producto: Producto = ProductoDataSet.getProducto()
            adapter.addProductos(producto)
        }
    }

    override fun onProductoSelected(item: Producto) {
        listaCesta.add(item)

        if(listaCesta.size == 5){
            //pasamos el carrito    a otra pantalla
            val intent = Intent(applicationContext,CestaActivity::class.java)
            intent.putParcelableArrayListExtra("lista",listaCesta)
            startActivity(intent)
        }else{
            Snackbar.make(binding.root,"Tamaño de tu cesta ${listaCesta.size}",Snackbar.LENGTH_SHORT).show()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList("lista",listaProductos)
        outState.putParcelableArrayList("cesta",listaCesta)
    }
    //CREAR UN RECYCLER: me creo un adaptador
    //creamos el adaptador: xml y el viewHolder y sobreescribimos los metodos
    //Asocio los datos recycler y adaptador -> en el activity donde este el recycler
    //gestiono acciones
    //en el adaptador
    //o en la intefaz de callback si quiero que se guarden los datos
}