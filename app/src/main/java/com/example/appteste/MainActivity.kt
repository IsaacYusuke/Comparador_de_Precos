package com.example.appteste

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.material.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    // A variable that holds the state of the counter
    var quantidade1 by remember { mutableStateOf("") }
    var quantidade2 by remember { mutableStateOf("") }
    var preço1 by remember { mutableStateOf("") }
    var preço2 by remember { mutableStateOf("") }

    var quantidade1num by remember { mutableStateOf(0) }
    var quantidade2num by remember { mutableStateOf(0) }
    var preço1num by remember { mutableStateOf(0.0) }
    var preço2num by remember { mutableStateOf(0.0) }

    var valor1 by remember { mutableStateOf(0.0) }
    var valor2 by remember { mutableStateOf(0.0) }


    var vantagem by remember { mutableStateOf(0.0)}
    var resultado by remember { mutableStateOf("")}

    // Material Design surface container
    Surface(modifier = Modifier.fillMaxSize() , color = MaterialTheme.colorScheme.inverseSurface) {

        Column(verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
                                    .weight(2f)
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 10.dp)
                )
                {
                    CenteredText("Produto 1")
                    //Text(text = "$counter", style = MaterialTheme.typography.titleLarge)

                    TextField(
                        quantidade1,
                        { newValue ->
                            // Aqui você pode incluir uma lógica para validar a entrada como numérica
                            quantidade1 = newValue.filter { it.isDigit() }
                            quantidade1num = quantidade1.toIntOrNull() ?: 0 // Se a conversão falhar, use 0
                        },
                        label = { Text("Quantidade do 1º produto (unidades, gramas, litros, etc...)") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    TextField(
                        value = preço1,
                        onValueChange = { newValue ->
                            preço1 = newValue
                            try {
                                preço1num = newValue.toDouble() // Tenta converter para Double
                            } catch (e: NumberFormatException) {
                                // Se a conversão falhar, lide com a exceção (p.ex. não faça nada ou defina preço2num como 0.0)
                                preço1num = 0.0
                                //preço1 = preço1
                            }
                        },
                        label = { Text("Preço do 1º produto (exemplo: 25.50)") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 10.dp)
                )

                {
                    CenteredText("Produto 2")
                    //Text(text = "$counter", style = MaterialTheme.typography.titleLarge)

                    TextField(
                        quantidade2,
                        { newValue ->
                            // Aqui você pode incluir uma lógica para validar a entrada como numérica
                            quantidade2 = newValue.filter { it.isDigit() }
                            quantidade2num = quantidade2.toIntOrNull() ?: 0 // Se a conversão falhar, use 0
                        },
                        label = { Text("Quantidade do 2º produto (unidades, gramas, litros, etc...)") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    TextField(
                        value = preço2,
                        onValueChange = { newValue ->
                            preço2 = newValue
                            try {
                                preço2num = newValue.toDouble() // Tenta converter para Double
                            } catch (e: NumberFormatException) {
                                // Se a conversão falhar, lide com a exceção (p.ex. não faça nada ou defina preço2num como 0.0)
                                preço2num = 0.0
                            }
                        },
                        label = { Text("Preço do 2º produto (exemplo: 25.50)") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                } // Final da 2ª Column interna
            } // Final da 1ª Row

            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)){

                Text(text = resultado,
                    style = TextStyle(fontSize = 24.sp),
                    textAlign = TextAlign.Center)

                Button(onClick = {
                    // Coloque aqui a lógica que será executada quando o botão for pressionado
                    if (preço2num != 0.0 && preço1num != 0.0) {
                        valor1 = quantidade1num/preço1num
                        valor2 = quantidade2num/preço2num

                        if(valor1 > valor2){
                            vantagem = (100 * (valor1/valor2 - 1) )
                            resultado = "A opção 1 é $vantagem% melhor"
                        } else if(valor2 > valor1) {
                            vantagem = (100 * (valor2/valor1 - 1) )
                            resultado = "A opção 2 é $vantagem% melhor"
                        } else {
                            resultado = "Os dois são equivalentes"
                        }
                    } else{
                        resultado = "Digite os preços dos produtos"
                    }
                    //resultado = valor2.toString()
                }) {
                    Text(text = "Calcular",
                        style = TextStyle(fontSize = 24.sp))
                }

            }




        } // Final da Column externa
    } // Final da Surface
} // Final da função MyApp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumberInputField() {
    var number by remember { mutableStateOf("") }

    TextField(number,
        { newValue ->
            // Aqui você pode incluir uma lógica para validar a entrada como numérica
            number = newValue.filter { it.isDigit() }
        },
        label = { Text("Digite um número pfvr") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
}

@Composable
fun CenteredText(txt: String) {
    Text(
        text = txt,
        modifier = Modifier.fillMaxWidth(), // Ocupa toda a largura do contêiner pai
        textAlign = TextAlign.Center // Centraliza o texto horizontalmente
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}
