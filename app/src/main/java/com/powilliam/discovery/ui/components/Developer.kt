package com.powilliam.discovery.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.CoilImage
import com.google.accompanist.imageloading.ImageLoadState
import com.google.accompanist.imageloading.MaterialLoadingImage
import com.powilliam.discovery.ui.theme.PrimaryText
import com.powilliam.discovery.ui.theme.SecondaryText

@Composable
fun Developer(
    id: String,
    name: String,
    bio: String,
    image: String,
    onDelete: (id: String) -> Unit = {  }
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
                CoilImage(data = image) { imageState ->
                   Box(
                       modifier = Modifier
                           .size(36.dp)
                           .clip(RoundedCornerShape(percent = 50)),
                   ) {
                       when (imageState) {
                           is ImageLoadState.Loading -> {
                               CircularProgressIndicator(
                                   color = MaterialTheme.colors.primary,
                                   strokeWidth = 1.dp
                               )
                           }
                           is ImageLoadState.Success -> {
                               MaterialLoadingImage(
                                   result = imageState,
                                   contentDescription = "$name profile image",
                                   modifier = Modifier
                                       .fillMaxSize()
                               )
                           }
                           else -> {
                               Icon(Icons.Outlined.Person,
                                   contentDescription = "Person",
                                   modifier = Modifier
                                       .fillMaxSize()
                               )
                           }
                       }
                   }
                }

                Column (
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Text(
                        text = name,
                        color = PrimaryText,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.width(260.dp)
                    )
                    Text(
                        text = bio,
                        color = SecondaryText,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .padding(top = 2.dp)
                            .width(260.dp)
                    )
                }
            }

            Icon(
                Icons.Outlined.Close,
                contentDescription = "Delete",
                modifier = Modifier.clickable {
                    onDelete(id)
                }
            )
        }
    }
}