package com.example.torneosrobotica.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Spacer
import com.example.torneosrobotica.ui.theme.BackgroundButton
import com.example.torneosrobotica.ui.theme.Black
import com.example.torneosrobotica.ui.theme.Gray
import com.example.torneosrobotica.ui.theme.Green
import com.example.torneosrobotica.ui.theme.ShapeButton
import com.example.torneosrobotica.R
import androidx.compose.foundation.Image
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.border

@Composable
fun HomeView(navigateToLogin:()-> Unit ={} ,navigateToSignUP: () -> Unit = {}, navigateToMap: () -> Unit = { }) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Gray, Black), startY = 0f, endY = 600f)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.robotica),
            contentDescription = "",
            modifier = Modifier.clip(CircleShape)
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            "PEQUEÑOS CIENTIFICOS",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            "Torneos de Robotica",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { navigateToSignUP()},
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 32.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Green)
        ) {
            Text(text = "Registrarse", color = Black, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(8.dp))
        CustomButton(
            Modifier.clickable { navigateToMap()},
            painterResource(id = R.drawable.googlelog),
            "Continuar con Google"
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomButton(
            Modifier.clickable { },
            painterResource(id = R.drawable.ups),
            "Continuar como estudiante"
        )
        Text(
            text = "Iniciar Sesion",
            color = Color.White,
            modifier = Modifier
                .padding(24.dp)
                .clickable {navigateToLogin() },
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}
    @Composable
    fun CustomButton(modifier: Modifier, painter: Painter, title: String) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 32.dp)
                .background(BackgroundButton)
                .border(2.dp, ShapeButton, CircleShape),
            contentAlignment = Alignment.CenterStart
        ) {
            Image(
                painter = painter,
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(16.dp)
            )
            Text(
                text = title,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
    }
