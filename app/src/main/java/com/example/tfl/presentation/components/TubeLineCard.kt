package com.example.tfl.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.tfl.data.remote.TubeLineResponsesItem


@Composable
fun TubeLineCard(
    tubeLineResponses: TubeLineResponsesItem
) {
    val title = tubeLineResponses.name
    val id = tubeLineResponses.id

    val hashMap = hashMapOf<String, String>()
    hashMap.put("bakerloo", "#894E24")
    hashMap.put("central", "#DC241F")
    hashMap.put("circle", "#FFCE00")
    hashMap.put("district", "#007229")
    hashMap.put("hammersmith-city", "#D799AF")
    hashMap.put("jubilee", "#697278")
    hashMap.put("metropolitan", "#751056")
    hashMap.put("northern", "#000000")
    hashMap.put("piccadilly", "#001AA8")
    hashMap.put("victoria", "#01A0E2")
    hashMap.put("waterloo-city", "#76D0BD")


    Column(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            shape = RectangleShape,
            elevation = 1.dp,
            border = BorderStroke(0.5.dp, Color.LightGray)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "..", color = Color(
                        android.graphics.Color.parseColor
                            (hashMap[tubeLineResponses.id] ?: "#000000")
                    ),
                    modifier = Modifier
                        .fillMaxHeight()
                        .focusable(true)
                        .background(
                            Color(
                                android.graphics.Color.parseColor
                                    (hashMap[tubeLineResponses.id] ?: "#000000")
                            ),
                        )
                )
                Text(text = title,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .focusable(true)
                        .semantics { contentDescription = title }

                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = tubeLineResponses.lineStatuses[0].statusSeverityDescription,
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .focusable(true)
                        .semantics {
                            contentDescription =
                                tubeLineResponses.lineStatuses[0].statusSeverityDescription
                        },
                    textAlign = TextAlign.End
                )
            }
        }
    }

}