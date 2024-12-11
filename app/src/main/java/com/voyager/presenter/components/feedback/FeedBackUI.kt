package com.voyager.presenter.components.feedback

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.voyager.R
import com.voyager.core.enums.FeedBackType
import com.voyager.core.enums.FeedBackType.*
import com.voyager.ui.theme.VoyagerTheme

@Composable
fun FeedbackUI(
    modifier: Modifier = Modifier,
    message: String,
    type: FeedBackType
) {

    val defaultColor = when (type) {
        SUCCESS -> Color.Green
        WARNING -> Color.Yellow
        ERROR -> Color.Red
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = defaultColor.copy(alpha = 0.2f)
        ),
        content = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                content = {

                    Icon(
                        painter = painterResource(id = R.drawable.ic_info),
                        contentDescription = null,
                        tint = defaultColor
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Text(text = message,
                        style = TextStyle(
                            color = defaultColor,
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp,
                            lineHeight = 19.6.sp,
                            letterSpacing = 0.2.sp
                        ))
                }
            )
        }
    )
}

@PreviewLightDark
@Composable
private fun FeedbackUIPreview() {
    VoyagerTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            content = {

                FeedbackUI(
                    message = "Info",
                    type = SUCCESS
                )

                FeedbackUI(
                    message = "Info",
                    type = ERROR
                )
            }
        )
    }
}