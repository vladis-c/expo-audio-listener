package expo.modules.audiolistener

import android.content.*
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition

import android.media.AudioManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import java.util.concurrent.Executors

const val AUDIO_MODE_CHANGED = "onAudioModeChanged"

class ExpoAudioListenerModule : Module() {
  @RequiresApi(Build.VERSION_CODES.S)
  override fun definition() = ModuleDefinition {
    Name("AudioListener")
    Events(AUDIO_MODE_CHANGED)

    OnStartObserving {
      audioManager?.addOnModeChangedListener(Executors.newSingleThreadExecutor(), listener)
    }

    OnStopObserving {
      audioManager?.removeOnModeChangedListener(listener)
    }
  }

  private val audioManager: AudioManager?
    get() = appContext.reactContext?.getSystemService(Context.AUDIO_SERVICE) as? AudioManager

  private val listener = AudioManager.OnModeChangedListener {
    audioManager?.mode?.let { mode ->
      this@ExpoAudioListenerModule.sendEvent(
        AUDIO_MODE_CHANGED,
        bundleOf("mode" to mode)
      )
    }
  }
}
