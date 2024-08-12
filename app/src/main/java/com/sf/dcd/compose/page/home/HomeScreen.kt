package com.sf.dcd.compose.page.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sf.dcd.compose.component.MovieItem
import com.sf.dcd.compose.core.domain.model.MovieDomain
import com.sf.dcd.compose.core.util.defaultZero
import com.sf.dcd.compose.core.util.defaultZeroDouble
import com.sf.dcd.compose.ui.theme.DicodingComposeSubmissionTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier, data: MovieDomain.Result, navigateToDetail: (Int) -> Unit) {
    Column(modifier = modifier) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(data.results, key = { it.id.defaultZero() }) { item ->
                MovieItem(
                    modifier = Modifier.clickable {
                        navigateToDetail(item.id.defaultZero())
                    },
                    title = item.title.orEmpty(),
                    overview = item.overview.orEmpty(),
                    vote = item.voteAverage.defaultZeroDouble(),
                    posterPath = item.posterPath.orEmpty()
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    DicodingComposeSubmissionTheme {
        HomeScreen(
            data = MovieDomain.Result(
                results = listOf(
                    MovieDomain.Data(
                        id = 1,
                        title = "lorem ipsum",
                        overview = "A listless Wade Wilson toils away in civilian life with his days as the morally flexible mercenary, Deadpool, behind him. But when his homeworld faces an existential threat, Wade must reluctantly suit-up again with an even more reluctant Wolverine."
                    ),
                    MovieDomain.Data(
                        id = 2,
                        title = "lorem ipsum",
                        overview = "A listless Wade Wilson toils away in civilian life with his days as the morally flexible mercenary, Deadpool, behind him. But when his homeworld faces an existential threat, Wade must reluctantly suit-up again with an even more reluctant Wolverine."
                    )
                )
            )
        )
    }
}