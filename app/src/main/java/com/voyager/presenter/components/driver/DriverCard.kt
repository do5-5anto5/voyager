package com.voyager.presenter.components.driver

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.voyager.R
import com.voyager.domain.model.ride.estimate.Option
import com.voyager.domain.model.ride.estimate.Review

@Composable
fun DriverCard(
    modifier: Modifier = Modifier,
    driver: Option
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(2.dp, Color.Gray, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Green.copy(alpha = 0.5f)
        ),
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp, horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    content = {
                        Icon(
                            modifier = Modifier.size(30.dp),
                            painter = painterResource(id = R.drawable.ic_car),
                            contentDescription = null,
                            tint = Color.Blue
                        )

                        Spacer(modifier = Modifier.width(6.dp))

                        Text(
                            text = driver.name ?: "",
                            style = TextStyle(
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                fontSize = 22.sp,
                                lineHeight = 19.6.sp,
                                letterSpacing = 0.2.sp
                            )
                        )
                    }
                )

                Spacer(modifier = Modifier.width(6.dp))

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp, horizontal = 16.dp),
                    content = {

                        Text(
                            text = driver.description ?: "",
                            style = TextStyle(
                                color = Color.LightGray,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 18.sp,
                                lineHeight = 19.6.sp,
                                letterSpacing = 0.2.sp
                            )
                        )
                    }
                )

                Spacer(modifier = Modifier.width(6.dp))

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp, horizontal = 16.dp),
                    content = {

                        Text(
                            text = "Veículo: ${driver.vehicle ?: ""}",
                            style = TextStyle(
                                color = Color.LightGray,
                                fontSize = 18.sp,
                                lineHeight = 19.6.sp,
                                letterSpacing = 0.2.sp
                            )
                        )
                    }
                )

                Spacer(modifier = Modifier.width(6.dp))

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp, horizontal = 16.dp),
                    content = {
                        Text(
                            text = "Rate: ${driver.review?.rating ?: 0.0} \n" +
                                    "Comentário: ${driver.review?.comment ?: ""}",
                            style = TextStyle(
                                color = Color.LightGray,
                                fontSize = 18.sp,
                                lineHeight = 19.6.sp,
                                letterSpacing = 0.2.sp
                            )
                        )
                    }
                )

                Spacer(modifier = Modifier.width(6.dp))

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp, horizontal = 16.dp),
                    content = {
                        Text(
                            text = "Valor: R$ ${driver.value.toString()}",
                            style = TextStyle(
                                color = Color.LightGray,
                                textAlign = TextAlign.Center,
                                fontSize = 18.sp,
                                lineHeight = 19.6.sp,
                                letterSpacing = 0.2.sp
                            )
                        )
                    }
                )
            }
        }
    )
}

@PreviewLightDark
@Composable
fun DriverPreview(modifier: Modifier = Modifier) {
    DriverCard(
        driver = Option(
            name = "Driver",
            description = "description",
            vehicle = "Vehicle",
            review = Review(
                rating = 5.0,
                comment = "comment"
            ),
            value = 0.00
        )
    )
}