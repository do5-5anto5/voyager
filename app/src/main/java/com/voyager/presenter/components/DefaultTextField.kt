package com.voyager.presenter.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DefaultTextView(
    modifier: Modifier = Modifier,
    value: String = "",
    label: String = "",
    placeholder: String = "",
    enabled: Boolean = true,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.Companion.None,
    singleLine: Boolean = true,
    mLeadingIcon: @Composable (() -> Unit)? = null,
    mTrailingIcon: @Composable (() -> Unit)? = null,
    requireKeyboardFocus: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    onValueChange: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {

        val focusRequester = remember { FocusRequester() }

        TextField(
            value = value,
            onValueChange = {
                onValueChange(it)
            },
            modifier = modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
                .padding(30.dp),
            enabled = enabled,
            label = {
                Text(
                    text = label,
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 19.6.sp,
                        letterSpacing = 0.2.sp
                    )
                )
            },
            placeholder = {
                Text(
                    text = placeholder,
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 19.6.sp,
                        letterSpacing = 0.2.sp
                    )
                )
            },
            leadingIcon = mLeadingIcon,
            trailingIcon = mTrailingIcon,
            isError = isError,
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            singleLine = singleLine,
            shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )

        if (requireKeyboardFocus) {
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun DefaultTextViewPreview() {

    var textValue by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Companion.CenterHorizontally
    ) {
        DefaultTextView(
            modifier = Modifier
                .padding(16.dp),
            value = textValue,
            label = "Nome",
            placeholder = "Insira seu Nome",
            mLeadingIcon = {
                IconButton(
                    onClick = { },
                    content = {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = null
                        )
                    }
                )
            },
            mTrailingIcon = {
                IconButton(
                    onClick = { },
                    content = {
                    }
                )
            },
            enabled = true,
            onValueChange = {
                textValue = it
            }
        )
    }
}
