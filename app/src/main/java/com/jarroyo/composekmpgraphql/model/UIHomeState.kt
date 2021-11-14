package com.jarroyo.composekmpgraphql.model

import java.lang.Exception
import com.jarroyo.sharedcodeclient.domain.model.CharacterUIModel


sealed class UIHomeState {
    data class ShowData(val homeData: List<CharacterUIModel>) : UIHomeState()
    object NoContents : UIHomeState()
    data class  Error(val exception: Exception) : UIHomeState()
    object ShowLoading : UIHomeState()
    object HideLoading : UIHomeState()
}