package com.yangdai.tetris

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yangdai.tetris.logic.*
import com.yangdai.tetris.ui.GameBody
import com.yangdai.tetris.ui.GameScreen
import com.yangdai.tetris.ui.PreviewGameScreen
import com.yangdai.tetris.ui.combinedClickable
import com.yangdai.tetris.ui.theme.TetrisTheme
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

class MainActivity : ComponentActivity() {
    @OptIn(ObsoleteCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.transparentStatusBar(this)
        SoundUtil.init(this)

        setContent {
            TetrisTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    val viewModel = viewModel<GameViewModel>()
                    val viewState = viewModel.viewState.value

                    LaunchedEffect(key1 = Unit) {
                        while (isActive) {
                            delay(650L - 55 * (viewState.level - 1))
                            viewModel.dispatch(Action.GameTick)
                        }
                    }

                    val lifecycleOwner = LocalLifecycleOwner.current
                    DisposableEffect(key1 = Unit) {
                        val observer = object : DefaultLifecycleObserver {
                            override fun onResume(owner: LifecycleOwner) {
                                viewModel.dispatch(Action.Resume)
                            }

                            override fun onPause(owner: LifecycleOwner) {
                                viewModel.dispatch(Action.Pause)
                            }
                        }
                        lifecycleOwner.lifecycle.addObserver(observer)
                        onDispose {
                            lifecycleOwner.lifecycle.removeObserver(observer)
                        }
                    }


                    GameBody(combinedClickable(
                        onMove = { direction: Direction ->
                            if (direction == Direction.Up) viewModel.dispatch(Action.Drop)
                            else viewModel.dispatch(Action.Move(direction))
                        },
                        onRotate = {
                            viewModel.dispatch(Action.Rotate)
                        },
                        onRestart = {
                            viewModel.dispatch(Action.Reset)
                        },
                        onPause = {
                            if (viewModel.viewState.value.isRunning) {
                                viewModel.dispatch(Action.Pause)
                            } else {
                                viewModel.dispatch(Action.Resume)
                            }
                        },
                        onMute = {
                            viewModel.dispatch(Action.Mute)
                        }
                    )) {
                        GameScreen(
                            Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        SoundUtil.release()
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TetrisTheme {
        GameBody {
            PreviewGameScreen(Modifier.fillMaxSize())
        }
    }
}