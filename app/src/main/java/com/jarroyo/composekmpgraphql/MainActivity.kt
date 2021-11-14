package com.jarroyo.composekmpgraphql

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jarroyo.composekmpgraphql.composables.HomeComposable
import com.jarroyo.composekmpgraphql.ui.Screen
import com.jarroyo.composekmpgraphql.ui.theme.ComposeKMPGraphQLTheme
import com.jarroyo.composekmpgraphql.viewmodel.HomeViewModel
import com.jarroyo.sharedcodeclient.domain.model.CharacterUIModel

class MainActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeKMPGraphQLTheme {
                //val currentScreen: Screen by navigationViewModel.currentScreen.observeAsState(Screen.BreedsList)
                MyApp(currentScreen = Screen.Home,
                    homeViewModel = homeViewModel,
                    onClick = { charcter ->
                        //navigationViewModel.onBreedSelected(breed)
                    },
                    onBackPressed = {onBackPressed()})
            }
        }
        homeViewModel.getHomeData()
    }
}

// Start building your app here!
@Composable
fun MyApp(currentScreen: Screen = Screen.Home,
          homeViewModel: HomeViewModel,
          onClick: (CharacterUIModel) -> Unit = {},
          onBackPressed: () -> Unit) {

    Surface(color = MaterialTheme.colors.background) {
        when (currentScreen) {
            //is Screen.Detail -> BreedDetailsComposable((currentScreen as Screen.BreedDetails).breed) {
            //    onBackPressed.invoke()
            //}
            is Screen.Home -> HomeComposable(homeViewModel, onClick = onClick)
        }
    }
}