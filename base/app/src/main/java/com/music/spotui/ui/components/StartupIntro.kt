package com.music.spotui.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.myspoti.engine.R
import kotlinx.coroutines.delay

private var introShown = false

/** The first moment after the app opens: the SpotiX picture and who made it, a moment, then it fades away. */
@Composable
fun StartupIntro() {
    var visible by remember { mutableStateOf(!introShown) }
    LaunchedEffect(Unit) {
        if (!introShown) { introShown = true; delay(1800); visible = false }
    }
    AnimatedVisibility(visible, exit = fadeOut()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().background(Color.Black)
                .clickable(interactionSource = remember { MutableInteractionSource() }, indication = null) { visible = false },
        ) {
            Image(
                painterResource(R.drawable.startup_cartoon), contentDescription = null,
                modifier = Modifier.size(190.dp).clip(CircleShape),
            )
            Text("DEVELOPED WITH PASSION", color = Color.White.copy(alpha = 0.5f), fontSize = 12.sp,
                fontWeight = FontWeight.Bold, letterSpacing = 2.sp, modifier = Modifier.padding(top = 40.dp))
            Text("Created by \uD800\uDC82Rathijitk~", color = Color.White, fontSize = 20.sp,
                fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 8.dp))
        }
    }
}
