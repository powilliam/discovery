package com.powilliam.discovery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.powilliam.discovery.ui.theme.PrimaryText

@Composable
fun SearchTextField(
    value: String,
    onValueChange: (value: String) -> Unit,
    onClearValue: () -> Unit,
    onSearch: KeyboardActionScope.() -> Unit = {  },
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
) {
    Column  {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier,
            keyboardOptions = KeyboardOptions(
                autoCorrect = false,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = onSearch
            ),
            textStyle = MaterialTheme.typography.body1.copy(color = PrimaryText),
            cursorBrush = Brush.linearGradient(
                colors = mutableListOf(
                  PrimaryText,
                  PrimaryText
                 )
            )
        ) { TextField ->
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Row {
                    Icon(Icons.Outlined.Search, contentDescription = "Search")
                    Spacer(modifier = Modifier.size(16.dp))

                    Box(modifier = Modifier.width(260.dp)) {
                        TextField()
                    }
                }

                if (value.isNotEmpty()) {
                    Icon(
                        Icons.Outlined.Close,
                        contentDescription = "Clear search text",
                        modifier = Modifier
                            .clip(RoundedCornerShape(percent = 50))
                            .clickable { onClearValue() }
                    )
                }
            }
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(MaterialTheme.colors.surface))
    }
}