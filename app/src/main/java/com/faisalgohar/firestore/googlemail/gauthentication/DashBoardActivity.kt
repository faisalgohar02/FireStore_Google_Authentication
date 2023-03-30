package com.faisalgohar.firestore.googlemail.gauthentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.faisalgohar.firestore.googlemail.gauthentication.adapter.DashBoardListAdapter
import com.faisalgohar.firestore.googlemail.gauthentication.databinding.ActivityDashBoardBinding
import com.faisalgohar.firestore.googlemail.gauthentication.models.MainListModel
import com.google.firebase.firestore.FirebaseFirestore

class DashBoardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashBoardBinding
    private lateinit var dashBoardListAdapter: DashBoardListAdapter
    private  var mainlist = mutableListOf<MainListModel>()

    private lateinit var fireStore:FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpFireStore()
        populateData()
        dashBoardListAdapter= DashBoardListAdapter(this,mainlist)

        binding.recyclerView.run {

            hasFixedSize()
            layoutManager=GridLayoutManager(this@DashBoardActivity,2)
            adapter=dashBoardListAdapter

        }


    }

    private fun populateData()
    {
        mainlist.add(MainListModel("","","One"))
        mainlist.add(MainListModel("","","Two"))
        mainlist.add(MainListModel("","","Three"))
        mainlist.add(MainListModel("","","Four"))
        mainlist.add(MainListModel("","","Five"))
        mainlist.add(MainListModel("","","Six"))
    }

    private fun setUpFireStore()
    {
        fireStore=FirebaseFirestore.getInstance()
        val collectionReference=fireStore.collection("MainList")
        collectionReference.addSnapshotListener{value,error->


            if(value==null && error!=null)
            {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
            else{
                Log.d("TAG", "setUpFireStore: ${value?.toObjects(MainListModel::class.java)}")
            }

        }
    }
}