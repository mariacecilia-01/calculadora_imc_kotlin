package com.aulasandroid.calculadora_imc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.calculadora_imc.ui.theme.Calculadora_IMCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Calculadora_IMCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    IMCScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun IMCScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {

        Column(modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .background(color = colorResource(R.color.primary_color)),
        horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painter = painterResource(R.drawable.bmi),
                contentDescription = "IMC icon",
                modifier = Modifier
                    .size(80.dp)
                    .padding(16.dp)
            )
            Text(text = "Calculadora de IMC",
                fontSize = 24.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold)


        }

        //            card formulário
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)){
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(250.dp)
                    .offset(y = (-50).dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(234, 233, 233, 255)
                ),
                elevation = CardDefaults.cardElevation(8.dp),
                shape = RoundedCornerShape(12.dp),
            ) { }
        }

//            card resultado
        Row() { }
    }
}