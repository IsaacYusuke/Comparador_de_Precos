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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
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
import kotlin.math.round
import androidx.compose.material3.TextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

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
    var quantidade1 by rememberSaveable { mutableStateOf("") }
    var quantidade2 by rememberSaveable { mutableStateOf("") }
    var preco1 by rememberSaveable { mutableStateOf("") }
    var preco2 by rememberSaveable { mutableStateOf("") }

    var quantidade1num by rememberSaveable { mutableStateOf(0.0) }
    var quantidade2num by rememberSaveable { mutableStateOf(0.0) }
    var preco1num by rememberSaveable { mutableStateOf(0.0) }
    var preco2num by rememberSaveable { mutableStateOf(0.0) }

    var valor1 by rememberSaveable { mutableStateOf(0.0) }
    var valor2 by rememberSaveable { mutableStateOf(0.0) }
    var precoporqtd1 by rememberSaveable { mutableStateOf("") }
    var precoporqtd2 by rememberSaveable { mutableStateOf("") }
    var precoporqtd1num by rememberSaveable { mutableStateOf(0.0) }
    var precoporqtd2num by rememberSaveable { mutableStateOf(0.0) }

    var vantagem by rememberSaveable { mutableStateOf(0.0)}
    var resultado by rememberSaveable { mutableStateOf("")}

    // Material Design surface container
    Surface(modifier = Modifier.fillMaxSize() , color = MaterialTheme.colorScheme.inverseSurface) {

        Column(verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
                                    .weight(1f)
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
                        value = quantidade1,
                        onValueChange = { newValue ->
                            quantidade1 = newValue
                            try {
                                quantidade1num = newValue.toDouble() // Tenta converter para Double
                            } catch (e: NumberFormatException) {
                                // Se a conversão falhar, lide com a excecão (p.ex. não faca nada ou defina preco2num como 0.0)
                                quantidade1num = 0.0
                            }
                        },
                        label = { Text("Quantidade do 1º produto (unidades, gramas, litros, etc...)") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    TextField(
                        value = preco1,
                        onValueChange = { newValue ->
                            preco1 = newValue
                            try {
                                preco1num = newValue.toDouble() // Tenta converter para Double
                            } catch (e: NumberFormatException) {
                                // Se a conversão falhar, lide com a excecão (p.ex. não faca nada ou defina preco2num como 0.0)
                                preco1num = 0.0
                                //preco1 = preco1
                            }
                        },
                        label = { Text("Preco do 1º produto (exemplo: 25.50)") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Preco/Quantidade: $precoporqtd1",
                        modifier = Modifier.fillMaxWidth(), // Ocupa toda a largura do contêiner pai
                        textAlign = TextAlign.Center, // Centraliza o texto horizontalmente
                        fontSize =20.sp // Define o tamanho da fonte para 100sp
                    )

                } // Final da Column da esquerda

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
                        value = quantidade2,
                        onValueChange = { newValue ->
                            // Aqui você pode incluir uma lógica para validar a entrada como numérica
                            quantidade2 = newValue
                            try {
                                quantidade2num = newValue.toDouble() // Tenta converter para Double
                            } catch (e: NumberFormatException) {
                                // Se a conversão falhar, lide com a excecão (p.ex. não faca nada ou defina preco2num como 0.0)
                                quantidade2num = 0.0
                            }
                        },
                        label = { Text("Quantidade do 2º produto (unidades, gramas, litros, etc...)") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    TextField(
                        value = preco2,
                        onValueChange = { newValue ->
                            preco2 = newValue
                            try {
                                preco2num = newValue.toDouble() // Tenta converter para Double
                            } catch (e: NumberFormatException) {
                                // Se a conversão falhar, lide com a excecão (p.ex. não faca nada ou defina preco2num como 0.0)
                                preco2num = 0.0
                            }
                        },
                        label = { Text(text = "Preco do 2º produto (exemplo: 25.50)") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)/*,
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color.Red, // Cor do texto
                            containerColor= Color.Blue, // Cor do rótulo quando não está em foco
                            focusedLabelColor = Color.Magenta // Cor do rótulo quando em foco
                            // Você pode adicionar mais parâmetros para personalizar outras cores, como a linha de base
                        )*/
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Preco/Quantidade: $precoporqtd2",
                        modifier = Modifier.fillMaxWidth(), // Ocupa toda a largura do contêiner pai
                        textAlign = TextAlign.Center, // Centraliza o texto horizontalmente
                        fontSize =20.sp // Define o tamanho da fonte para 100sp
                    )

                } // Final da 2ª Column interna
            } // Final da 1ª Row

            Spacer(modifier = Modifier.height(16.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)){

                Text(text = resultado,
                    style = TextStyle(fontSize = 24.sp),
                    textAlign = TextAlign.Center)

                Button(onClick = {
                    // Coloque aqui a lógica que será executada quando o botão for pressionado
                    if (preco2num != 0.0 && preco1num != 0.0 && quantidade1num != 0.0 && quantidade2num != 0.0) {
                        valor1 = quantidade1num/preco1num
                        valor2 = quantidade2num/preco2num

                        precoporqtd1num = preco1num / quantidade1num
                        precoporqtd1num = round(precoporqtd1num*100)/100

                        precoporqtd2num = preco2num / quantidade2num
                        precoporqtd2num = round(precoporqtd2num*100)/100

                        precoporqtd1 = "R$ " + precoporqtd1num.toString()
                        precoporqtd2 = "R$ " + precoporqtd2num.toString()



                        if(valor1 > valor2){
                            vantagem = round(100*(100 * (valor1/valor2 - 1) ))/100
                            resultado = "A opcão 1 é $vantagem% melhor"
                        } else if(valor2 > valor1) {
                            vantagem = round(100*(100 * (valor2/valor1 - 1) ))/100
                            resultado = "A opcão 2 é $vantagem% melhor"
                        } else {
                            resultado = "Os dois são equivalentes"
                        }
                    } else{
                        resultado = "Digite os precos dos produtos"
                    }
                    //resultado = valor2.toString()
                }) {
                    Text(text = "Calcular",
                        style = TextStyle(fontSize = 24.sp))
                }

                Spacer(modifier = Modifier.height(16.dp)) // Adiciona espaco entre os botões

                Button(onClick = {
                    preco1 = ""
                    preco2 = ""
                    preco1num = 0.0
                    preco2num = 0.0
                    quantidade1 = ""
                    quantidade2 = ""
                    resultado = ""
                    precoporqtd1 = ""
                    precoporqtd2 = ""

                },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red) // Define a cor do botão para vermelho
                ) {
                    Text(text = "Reset",
                        style = TextStyle(fontSize = 24.sp))
                }

            }




        } // Final da Column externa
    } // Final da Surface
} // Final da funcão MyApp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumberInputField() {
    var number by rememberSaveable { mutableStateOf("") }

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
        textAlign = TextAlign.Center, // Centraliza o texto horizontalmente
        fontSize =30.sp // Define o tamanho da fonte para 100sp
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}
