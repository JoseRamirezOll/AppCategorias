package com.example.appmovile

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import android.view.accessibility.AccessibilityNodeInfo
import androidx.annotation.RequiresApi

class genAdapter(context: Context):
    RecyclerView.Adapter<genAdapter.genviwe>()
{
    private val genList: List<String>

    init
    {
        val categoriasTip =context.resources.getStringArray(R.array.categorias).toList()
        genList = categoriasTip
    }
    class genviwe(val view: View) : RecyclerView.ViewHolder(view) {
        val button = view.findViewById<Button>(R.id.button_item)
    }
    override fun getItemCount(): Int
    {
        return genList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): genviwe {
        val layout = LayoutInflater
                .from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        // Setup custom accessibility delegate to set the text read
        layout.accessibilityDelegate = Accessibility
        return genviwe(layout)
    }

    override fun onBindViewHolder(holder: genviwe, position: Int) {
        val item = genList.get(position)
        holder.button.text = item
        holder.button.setOnClickListener{val context = holder.view.context
            //Crea un Intent y pasa el contexto, así como el nombre de clase de la actividad de destino.
            val intent = Intent(context, DetailActivity::class.java)
            // Llama al método putExtra. Pasa "letter" como primer argumento y el texto del botón como el segundo
            intent.putExtra(DetailActivity.GENERO,holder.button.text.toString())
            context.startActivity(intent)
        }
    }
    companion object Accessibility : View.AccessibilityDelegate() {
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun onInitializeAccessibilityNodeInfo(
            host: View?,
            info: AccessibilityNodeInfo?
        ) {
            super.onInitializeAccessibilityNodeInfo(host, info)
            // With `null` as the second argument to [AccessibilityAction], the
            // accessibility service announces "double tap to activate".
            // If a custom string is provided,
            // it announces "double tap to <custom string>".
            val customString = host?.context?.getString(R.string.app_name)
            val customClick =
                AccessibilityNodeInfo.AccessibilityAction(
                    AccessibilityNodeInfo.ACTION_CLICK,
                    customString
                )
            info?.addAction(customClick)
        }
    }// fin del metodo accesibilidad
}