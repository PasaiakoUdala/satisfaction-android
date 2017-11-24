package eus.pasaia.org.satisfaction

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class AkatsaActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_akatsa)

    val handler = Handler()

    handler.postDelayed(Runnable { finish() }, 2000)
  }
}
