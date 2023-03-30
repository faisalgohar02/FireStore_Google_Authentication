package com.faisalgohar.firestore.googlemail.gauthentication.models

data class DashBoardListModel(var id:String,
                              var path :String,
                              var name:String,
                              var mainlist:MutableMap<String,MainListModel> = mutableMapOf()
)
