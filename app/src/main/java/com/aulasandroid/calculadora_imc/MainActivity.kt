package com.aulasandroid.calculadora_imc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
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

    var alturaUsuario by remember {
        mutableStateOf("")
    }

    var pesoUsuario by remember {
        mutableStateOf("")
    }

    var resultadoImc by remember {
        mutableStateOf(0.0f)
    }

    var classificacaoImc by remember {
        mutableStateOf("")
    }


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
            .padding(24.dp),

        ){
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(300.dp)
                    .offset(y = (-50).dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(234, 233, 233, 255)
                ),
                elevation = CardDefaults.cardElevation(8.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Seus dados",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W600
                    )

                    OutlinedTextField(
                        value = alturaUsuario,
                        onValueChange = { novoValor ->
                            alturaUsuario = novoValor
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = colorResource(R.color.primary_color)
                        ),
                        shape = RoundedCornerShape(12.dp),
                        label = { Text(text = "Altura",
                                        fontSize = 15.sp,
                                        fontStyle = FontStyle.Italic)
                        }
                    )

                    OutlinedTextField(
                        value = pesoUsuario,
                        onValueChange = {novoValor ->
                            pesoUsuario = novoValor
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = colorResource(R.color.primary_color)
                        ),
                        shape = RoundedCornerShape(12.dp),
                        label = { Text(text = "Peso",
                                        fontSize = 15.sp,
                                        fontStyle = FontStyle.Italic)
                        }
                    )

                    Button(onClick = {
                        resultadoImc = pesoUsuario.toFloat() / (alturaUsuario.toFloat() * alturaUsuario.toFloat())

                        if (resultadoImc < 18.5){
                            classificacaoImc = "Abaixo do peso"
                        } else if (resultadoImc > 18.5 && resultadoImc < 25){
                            classificacaoImc = "Peso ideal"
                        } else if (resultadoImc >= 25 && resultadoImc < 30){
                            classificacaoImc = "Levemente acima do peso"
                        } else if (resultadoImc >= 30 && resultadoImc < 35){
                            classificacaoImc = "Obesidade grau I"
                        } else if (resultadoImc >= 35 && resultadoImc < 40){
                            classificacaoImc = "Obesidade grau II"
                        } else if (resultadoImc > 40){
                            classificacaoImc = "Obesidade grau III"
                        } else {
                            classificacaoImc = "Insira um valor válido!"
                        }

                    },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(25.dp)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.primary_color),
                            contentColor = Color.Black)
                    ) {
                        Text(text ="CALCULAR",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.W700
                        )
                    }
                }
            }

            //            card resultado

            Card(modifier = Modifier
                .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(63, 180, 50, 255),
                    contentColor = Color.White
                )

            ) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .height(42.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically) {

                    Text(text = "%.2f".format(resultadoImc),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp)

                    Text(text = classificacaoImc,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp)
                }
            }
            }
        }


    }
