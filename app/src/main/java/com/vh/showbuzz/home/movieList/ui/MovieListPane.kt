package com.vh.showbuzz.home.movieList.ui;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import com.vh.showbuzz.home.movieList.domain.Movie
import com.vh.showbuzz.home.movieList.ui.components.Movie

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListPane(categoryName:String,movieList: LazyPagingItems<Movie>) {
  //  val isRefreshing = remember { mutableStateOf(false) }
Column (modifier  =
    Modifier
        .fillMaxWidth()
        .wrapContentHeight().padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp), horizontalAlignment = Alignment.Start){
    Text(text = categoryName)

    LazyRow(
        modifier =
        Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(movieList.itemCount, key = movieList.itemKey { it.id }) { INDEX ->
            Movie(movie = movieList[INDEX]!!, onMovieClick = {})
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                if (movieList.loadState.refresh is LoadState.Loading || movieList.loadState.append is LoadState.Loading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(30.dp)
                    )
                }

            }
        }

    }



}


}



