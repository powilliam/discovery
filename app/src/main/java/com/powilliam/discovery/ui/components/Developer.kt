package com.powilliam.discovery.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.powilliam.discovery.ui.theme.PrimaryText
import com.powilliam.discovery.ui.theme.SecondaryText

@Composable
fun Developer(
) {
    Card (
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row (
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Outlined.Person,
                    contentDescription = "Person",
                    modifier = Modifier.size(24.dp)
                )

                Column (
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Text(
                        text = "William Porto",
                        color = PrimaryText,
                        style = MaterialTheme.typography.body2
                    )
                    Text(
                        text = "Mobile developer at @naveteam",
                        color = SecondaryText,
                        style = MaterialTheme.typography.caption
                    )
                }
            }

            Icon(Icons.Outlined.Close,
                contentDescription = "Delete",
            )
        }
    }
}