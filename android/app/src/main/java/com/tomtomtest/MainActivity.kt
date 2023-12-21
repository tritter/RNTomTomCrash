package com.tomtomtest

import android.os.Bundle
import com.facebook.react.ReactActivity
import com.facebook.react.ReactActivityDelegate
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.fabricEnabled
import com.facebook.react.defaults.DefaultReactActivityDelegate
import com.tomtom.sdk.map.display.MapOptions
import com.tomtom.sdk.map.display.TomTomMap
import com.tomtom.sdk.map.display.ui.MapReadyCallback
import com.tomtom.sdk.map.display.ui.MapView


class MainActivity : ReactActivity(), MapReadyCallback {

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  override fun getMainComponentName(): String = "TomTomTest"

  /**
   * Returns the instance of the [ReactActivityDelegate]. We use [DefaultReactActivityDelegate]
   * which allows you to enable New Architecture with a single boolean flags [fabricEnabled]
   */
  override fun createReactActivityDelegate(): ReactActivityDelegate =
      DefaultReactActivityDelegate(this, mainComponentName, fabricEnabled)

    // TODO Hard override skip complete bridge just demonstrate crash of TomTom!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val apiKey = ""
        val options = MapOptions(apiKey)
        val mapView = MapView(this, options)
        setContentView(mapView)
        mapView.onCreate(savedInstanceState)
        mapView.onStart()
        mapView.onResume()
        mapView.getMapAsync(this)
    }

    override fun onMapReady(map: TomTomMap) {
        print("MAP READY")
    }
}
