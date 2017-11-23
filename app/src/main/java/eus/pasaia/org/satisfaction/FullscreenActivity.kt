package eus.pasaia.org.satisfaction

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import eus.pasaia.org.satisfaction.data.model.Satisfaction
import eus.pasaia.org.satisfaction.data.model.remote.APIService
import eus.pasaia.org.satisfaction.data.model.remote.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.support.v4.content.ContextCompat.startActivity




class FullscreenActivity : AppCompatActivity() {
  private val mHideHandler = Handler()
  private val mHidePart2Runnable = Runnable {

  }
  private val mShowPart2Runnable = Runnable {
    // Delayed display of UI elements
    supportActionBar?.show()
  }
  private var mVisible: Boolean = false
  private val mHideRunnable = Runnable { hide() }
  private val mAPIService: APIService? = null
  /**
   * Touch listener to use for in-layout UI controls to delay hiding the
   * system UI. This is to prevent the jarring behavior of controls going away
   * while interacting with activity UI.
   */
  private val mDelayHideTouchListener = View.OnTouchListener { _, _ ->
    if (AUTO_HIDE) {
      delayedHide(AUTO_HIDE_DELAY_MILLIS)
    }
    false
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_fullscreen)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)

    PreferenceManager.setDefaultValues(this, R.xml.pref_general, false);

    val SP = PreferenceManager.getDefaultSharedPreferences(baseContext)
    val strKokalekua = SP.getString("kokalekua", "NA")
    val strServer_url = SP.getString("server_url", "NA")
    val strGalderaeus = SP.getString("galdera_eus", "NA")
    val strGalderaes = SP.getString("galdera_es", "NA")
    val strSaila = SP.getString("saila", "NA")

    var txtEus = findViewById<TextView>(R.id.txtGalderaeus) as TextView
    var txtEs = findViewById<TextView>(R.id.txtGalderaes) as TextView
    txtEus.text = strGalderaeus
    txtEs.text = strGalderaes

    var mAPIService = ApiUtils.getAPIService()



    fun sendSatisfaction(galderaeus: String, galderaes: String, emaitza: Int, saila: String, kokalekua: String) {
      if (mAPIService != null) {
        mAPIService.saveSatisfaction(galderaeus, galderaes, emaitza, saila, kokalekua).enqueue(object : Callback<Satisfaction> {
          override fun onResponse(call: Call<Satisfaction>, response: Response<Satisfaction>) {

            if (response.isSuccessful()) {
              Log.i("IKER", "post submitted to API." + response.body().toString())
              val mainIntent = Intent(this@FullscreenActivity, SuccessActivity::class.java)
              startActivity(mainIntent)
            }

          }

          override fun onFailure(call: Call<Satisfaction>, t: Throwable) {
            Log.e("IKER", "Unable to submit post to API.")
          }
        })
      }
    }

    var btnOk = findViewById<ImageButton>(R.id.imgOk) as ImageButton
    btnOk.setOnClickListener {
      sendSatisfaction(strGalderaeus, strGalderaes, 1, strSaila, strKokalekua)
      Log.d("IKER", "Xieeee")
    }

    var btnNeutral = findViewById<ImageButton>(R.id.imgNeutral) as ImageButton
    btnNeutral.setOnClickListener {
      sendSatisfaction(strGalderaeus, strGalderaes, 0, strSaila, strKokalekua)
      Log.d("IKER", "Xieeee")
    }

    var btnBad = findViewById<ImageButton>(R.id.imgBad) as ImageButton
    btnBad.setOnClickListener {
      sendSatisfaction(strGalderaeus, strGalderaes, -1, strSaila, strKokalekua)
      Log.d("IKER", "Xieeee")
    }

    var btnSettings = findViewById<Button>(R.id.cmdSettings) as Button
    btnSettings.setOnClickListener {
      startActivity(Intent(this@FullscreenActivity, SettingsActivity::class.java))
    }

  }

  override fun onPostCreate(savedInstanceState: Bundle?) {
    super.onPostCreate(savedInstanceState)

    // Trigger the initial hide() shortly after the activity has been
    // created, to briefly hint to the user that UI controls
    // are available.
    delayedHide(100)
  }

  private fun toggle() {
    if (mVisible) {
      hide()
    } else {
      show()
    }
  }

  private fun hide() {
    // Hide UI first
    supportActionBar?.hide()
//        fullscreen_content_controls.visibility = View.GONE
    mVisible = false

    // Schedule a runnable to remove the status and navigation bar after a delay
    mHideHandler.removeCallbacks(mShowPart2Runnable)
    mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY.toLong())
  }

  private fun show() {
    // Show the system bar
//        fullscreen_content.systemUiVisibility =
//                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
//                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    mVisible = true

    // Schedule a runnable to display UI elements after a delay
    mHideHandler.removeCallbacks(mHidePart2Runnable)
    mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY.toLong())
  }

  /**
   * Schedules a call to hide() in [delayMillis], canceling any
   * previously scheduled calls.
   */
  private fun delayedHide(delayMillis: Int) {
    mHideHandler.removeCallbacks(mHideRunnable)
    mHideHandler.postDelayed(mHideRunnable, delayMillis.toLong())
  }

  companion object {
    /**
     * Whether or not the system UI should be auto-hidden after
     * [AUTO_HIDE_DELAY_MILLIS] milliseconds.
     */
    private val AUTO_HIDE = true

    /**
     * If [AUTO_HIDE] is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private val AUTO_HIDE_DELAY_MILLIS = 3000

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private val UI_ANIMATION_DELAY = 300
  }
}
