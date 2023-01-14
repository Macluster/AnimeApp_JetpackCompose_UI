package com.example.mangareader

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun AnimeDetailsPage(itemId:String,viewModel: Lazy<ItemViewModel>)
{
    Box(modifier = Modifier
        .fillMaxSize()
        .background(brush = Brush.linearGradient(listOf(Color(80, 80, 100), Color.Black))))
    {
        
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = viewModel.value.list[itemId.toInt()].AnimeName, fontSize = 30.sp, color = Color.White ,fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(20.dp))
            Card(modifier = Modifier
                .height(300.dp)
                .width(250.dp), shape = RoundedCornerShape(10)) {
                Image(painter = rememberAsyncImagePainter(model =viewModel.value.list[itemId.toInt()].AnimeImage
                ), contentDescription ="", contentScale = ContentScale.FillBounds )
                

            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)) {
                Text(text = "Description", fontSize = 21.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(5.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp, 20.dp, 0.dp), color = Color.White,
                text = "Lorem ipsum is a dummy text without any sense. It is a sequence of Latin words that, as they are positioned, do not form sentences with a complete sense, but give life to a test text useful to fill spaces that will subsequently be occupied from ad hoc texts composed by communication professionals.")

            Spacer(modifier = Modifier.height(30.dp))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)) {
                Text(text = "Episodes", fontSize = 21.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(5.dp))
            EpisodeFrame()


        }

    }
    
    
}

@Composable
fun EpisodeFrame()
{
    var list= listOf<Int>(1,2,3,4,5,6,7)

    LazyColumn(modifier = Modifier.height(200.dp)){
        items(list.size){
            index->
            Card(
                backgroundColor = Color.White.copy(alpha = 0.5f)
                ,modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(20.dp, 0.dp, 20.dp, 5.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Episode $index", color = Color.White, fontSize = 19.sp)

                }


            }
        }
    }

}