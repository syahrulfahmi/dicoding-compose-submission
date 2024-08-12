package com.sf.dcd.compose.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sf.dcd.compose.core.domain.model.MovieDomain
import com.sf.dcd.compose.core.util.component.StarRatingBar
import com.sf.dcd.compose.core.util.defaultZeroDouble
import com.sf.dcd.compose.ui.theme.DicodingComposeSubmissionTheme
import kotlin.math.ceil

@Composable
fun MovieItemContent(modifier: Modifier = Modifier, title: String, overview: String, vote: Double) {
    var rating by remember { mutableFloatStateOf(ceil(((vote.defaultZeroDouble() * 10) / 20).toFloat())) }
    Row(
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.width(58.dp))
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                modifier = Modifier.padding(top = 4.dp, end = 8.dp),
                text = overview,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            StarRatingBar(
                modifier = Modifier.padding(top = 8.dp, end = 8.dp),
                isEnableClick = false,
                rating = rating
            ) {
                rating = it
            }
        }
    }
}

@Preview
@Composable
private fun MovieItemContentPrev() {
    DicodingComposeSubmissionTheme {
        MovieItemContent(title = "asdadqwre", overview = "asdqwekkandsknaksd", vote = 7.96)
    }
}