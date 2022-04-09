package com.example.appmovile

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

class peliculasAdapter (private  val genero: String, context: Context):
    RecyclerView.Adapter<peliculasAdapter.peliculaViewHolder>()
{

   private var listP = peliculaOrganizadaz().obtenerPeliculasPorGenero(genero)

    class peliculaViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val button = view.findViewById<Button>(R.id.button_item)
    }

    override fun getItemCount(): Int
    {
        return listP.size
    }

    override fun onBindViewHolder(holder: peliculaViewHolder, position: Int) {
        val item= listP[position]
        val context = holder.view.context
        holder.button.text = item.titulo
        // implementamos el metodo cuando el usuatio da clik en el boton
        holder.button.setOnClickListener{
            val queryUrl: Uri = Uri.parse("${DetailActivity.SEARCH_PREFIX}${item.titulo}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): peliculaViewHolder
    {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        layout.accessibilityDelegate = Accessibility
        return peliculaViewHolder(layout)
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