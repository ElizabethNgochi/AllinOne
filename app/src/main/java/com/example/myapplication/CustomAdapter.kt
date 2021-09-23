package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(var context: Context, var data:ArrayList<User>):BaseAdapter() {
    private class ViewHolder(row:View?){
        var mTxtFName:TextView
        var mTxtSName:TextView
        var mTxtEmail:TextView
        var mTxtPassword:TextView



        init {
            this.mTxtFName = row?.findViewById(R.id.mFirstName) as TextView
            this.mTxtSName = row?.findViewById(R.id.mSecondName) as TextView
            this.mTxtEmail = row?.findViewById(R.id.mEmail) as TextView
            this.mTxtPassword = row?.findViewById(R.id.mPassword) as TextView

        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder:ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.activity_tabbed ,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item:User = getItem(position) as User
        viewHolder.mTxtFName.text = item.first_name
        viewHolder.mTxtSName.text = item.second_name
        viewHolder.mTxtEmail.text = item.user_email
        viewHolder.mTxtPassword.text = item.user_password
        return view as View
    }


    override fun getItem(position: Int): Any {
        return  data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }
}