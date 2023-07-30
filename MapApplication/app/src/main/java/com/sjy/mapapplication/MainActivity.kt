package com.sjy.mapapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //위치 제공자 요청
        apiClient.connect()
    }


    //google api 클라이언트 초기화
    val connectionCallback = object : GoogleApiClient.ConnectionCallbacks{
        override fun onConnected(p0: Bundle?) {
            TODO("Not yet implemented")
        }

        override fun onConnectionSuspended(p0: Int) {
            TODO("Not yet implemented")
        }
    }

    val onConnectionFailedCallback = object : GoogleApiClient.OnConnectionFailedListener{
        override fun onConnectionFailed(p0: ConnectionResult) {
            TODO("Not yet implemented")
        }

    }

    val apiClient: GoogleApiClient = GoogleApiClient.Builder(this)
        .addApi(LocationServices.API)
        .addConnectionCallbacks(connectionCallback)
        .addOnConnectionFailedListener(onConnectionFailedCallback)
        .build()

    //FusedLocationProviderClient 초기화
    val providerClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(this)

}