package com.powilliam.discovery.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.powilliam.discovery.domain.models.GithubUser
import com.powilliam.discovery.ui.theme.SecondaryText

@ExperimentalFoundationApi
@Composable
fun LazyDevelopersList(
    data: Map<String, Array<GithubUser>>,
    onDeleteOne: (id: String) -> Unit = {}
) {
    LazyColumn {
        data.forEach { (label, developers) ->
            if (developers.isNotEmpty()) {
                stickyHeader {
                    Column (
                        modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    ) {
                        Text(
                            text = label,
                            color = SecondaryText,
                            style = MaterialTheme.typography.caption,
                            fontWeight = FontWeight.W600
                        )
                    }
                }
            }

            items(
                items = developers,
                key = { developer -> developer.id }
            ) { developer ->
                Developer(
                    id = developer.id,
                    name = developer.name,
                    bio = developer.bio,
                    image = developer.image,
                    onDelete = { onDeleteOne(developer.id) }
                )
            }
        }
    }
}