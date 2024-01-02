package com.muliamaulana.mytemperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.muliamaulana.mytemperatureconverter.ui.theme.MyTemperatureConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTemperatureConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        StatefullTemperatureInput()
                        ConverterApp()
                        TwoWayConverterApp()
                    }
                }
            }
        }
    }
}


@Composable
fun StatefullTemperatureInput(modifier: Modifier = Modifier) {
    var input by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }
    Column(modifier.padding(16.dp)) {
        Text(
            text = stringResource(id = R.string.stateful_converter),
            style = MaterialTheme.typography.headlineSmall
        )

        OutlinedTextField(
            value = input,
            label = { Text(text = stringResource(id = R.string.enter_celsius)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { newInput ->
                input = newInput
                output = convertToFahrenheit(newInput)
            }
        )
        Text(text = stringResource(id = R.string.temperature_fahrenheit, output))
    }
}

@Composable
fun StatelessTemperatueInput(
    input: String,
    output: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier.padding(16.dp)) {
        Text(
            text = stringResource(id = R.string.stateless_converter),
            style = MaterialTheme.typography.headlineSmall
        )

        OutlinedTextField(
            value = input,
            label = { Text(text = stringResource(id = R.string.enter_celsius)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = onValueChange
        )

        Text(text = stringResource(id = R.string.temperature_fahrenheit, output))
    }
}

@Composable
fun GeneralTemperatureInput(
    scale: Scale,
    input: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        OutlinedTextField(
            value = input,
            label = {
                Text(
                    text = stringResource(
                        id = R.string.enter_temperature,
                        scale.scaleName
                    )
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = onValueChange
        )
    }
}

@Composable
private fun TwoWayConverterApp(modifier: Modifier = Modifier) {
    var celcius by remember { mutableStateOf("") }
    var fahrenheit by remember { mutableStateOf("") }

    Column(modifier.padding(16.dp)) {
        Text(
            text = stringResource(id = R.string.two_way_converter),
            style = MaterialTheme.typography.headlineSmall
        )
        GeneralTemperatureInput(
            scale = Scale.CELSIUS,
            input = celcius,
            onValueChange = { newInput ->
                celcius = newInput
                fahrenheit = convertToFahrenheit(newInput)
            }
        )

        GeneralTemperatureInput(
            scale = Scale.FAHRENHEIT,
            input = fahrenheit,
            onValueChange = { newInput ->
                fahrenheit = newInput
                celcius = convertToCelsius(newInput)
            }
        )
    }
}

@Composable
private fun ConverterApp(modifier: Modifier = Modifier) {
    var input by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }
    Column(modifier) {
        StatelessTemperatueInput(
            input = input,
            output = output,
            onValueChange = { newInput ->
                input = newInput
                output = convertToFahrenheit(newInput)
            }
        )
    }
}

fun convertToFahrenheit(celcius: String): String {
    if (celcius.isEmpty()) return ""
    return celcius.toDoubleOrNull()?.let {
        (it * 9 / 5) + 32
    }.toString()
}

private fun convertToCelsius(fahrenheit: String): String {
    if (fahrenheit.isEmpty()) return ""
    return fahrenheit.toDoubleOrNull()?.let {
        (it - 32) * 5 / 9
    }.toString()
}

enum class Scale(val scaleName: String) {
    CELSIUS("Celsius"),
    FAHRENHEIT("Fahrenheit")
}
