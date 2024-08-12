package com.sf.dcd.compose.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.sf.dcd.compose.BuildConfig
import com.sf.dcd.compose.core.domain.model.MovieDomain
import com.sf.dcd.compose.core.util.defaultZeroDouble
import com.sf.dcd.compose.ui.theme.DicodingComposeSubmissionTheme

@Composable
fun MovieItem(
    modifier: Modifier = Modifier,
    title: String,
    overview: String,
    vote: Double,
    posterPath: String
) {
    ConstraintLayout(modifier = modifier.fillMaxWidth()) {
        val (space, card, image) = createRefs()
        val cardGuideline = createGuidelineFromStart(0.2f)
        Spacer(modifier = Modifier
            .width(50.dp)
            .height(170.dp)
            .constrainAs(space) {
                start.linkTo(cardGuideline)
            })
        Spacer(modifier = Modifier.height(16.dp))
        Column(modifier = Modifier
            .constrainAs(card) {
                start.linkTo(space.start)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            }) {
            Spacer(modifier = Modifier.size(16.dp))
            MovieItemContent(
                modifier = modifier
                    .height(180.dp)
                    .clip(RoundedCornerShape(size = 5.dp))
                    .background(Color(0xFF394265))
                    .padding(top = 16.dp),
                title = title,
                overview = overview,
                vote = vote.defaultZeroDouble()
            )
        }
        AsyncImage(
            modifier = Modifier
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .clip(RoundedCornerShape(size = 5.dp))
                .height(180.dp)
                .width(120.dp),
            contentScale = ContentScale.Crop,
            placeholder = BrushPainter(
                Brush.linearGradient(
                    listOf(
                        Color(color = 0xFFFFFFFF),
                        Color(color = 0xFFDDDDDD),
                    )
                )
            ),
            model = BuildConfig.API_URL_IMAGE_W500 + posterPath, contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MovieItemPreview() {
    DicodingComposeSubmissionTheme {
        MovieItem(
            title = "lorem ipsum",
            overview = "A listless Wade Wilson toils away in civilian life with his days as the morally flexible mercenary, Deadpool, behind him. But when his homeworld faces an existential threat, Wade must reluctantly suit-up again with an even more reluctant Wolverine.",
            posterPath = "/8cdWjvZQUExUUTzyp4t6EDMubfO.jpg",
            vote = 7.98
        )
    }
}