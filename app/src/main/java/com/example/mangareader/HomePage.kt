package com.example.mangareader

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter



@Composable
fun HomePage(viewModel: SnapshotStateList<AnimeModel>, navController: NavController)
{
    Box(modifier = Modifier
        .fillMaxSize()
        .background(brush = Brush.linearGradient(listOf(Color(80, 80, 100), Color.Black)))
        .padding(10.dp)){
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Text("AnimeReader", fontSize = 28.sp, fontWeight = FontWeight(900), color = Color.White)
            Spacer(modifier = Modifier.height(10.dp))
            SearchBar()

            Spacer(modifier = Modifier.height(40.dp))
            TopMenu()
            Spacer(modifier = Modifier.height(40.dp))
            Text(text = "New Releases", fontWeight = FontWeight(900), fontSize = 20.sp, color = Color.White)
            LazyRow{
                items(viewModel.size){index->
                    AnimeCard(navController,index,viewModel[index])
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Top Rated", fontWeight = FontWeight(900), fontSize = 20.sp, color = Color.White)
            LazyRow{
                items(viewModel.size){index->
                    AnimeCard(navController,index,viewModel[index])
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AnimeCard(navController: NavController,index:Int,model:AnimeModel)
{
    Card(shape = RoundedCornerShape(10),backgroundColor = Color.Blue,modifier = Modifier
        .padding(10.dp)
        .height(200.dp)
        .width(150.dp), onClick = {
            navController.navigate("detail/$index")
    }) {

        Image(painter = rememberAsyncImagePainter(model =model.AnimeImage ), contentDescription ="", contentScale = ContentScale.FillBounds )

    }
}

@Composable
fun SearchBar()
{

    var text by remember {
        mutableStateOf("")
    }
    

        Card(
            shape = RoundedCornerShape(20),
            backgroundColor = Color.Gray.copy(alpha = 1f),modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .padding(0.dp).shadow(0.dp).border(width = 0.dp, brush = SolidColor(Color.Transparent), shape = RoundedCornerShape(20))) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.width(5.dp))
                Icon(
                    tint = Color.White,
                    imageVector = Icons.Default.Search, contentDescription ="", modifier = Modifier.size(40.dp)

                    )
                TextField(value = text, onValueChange ={text=it}, colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent, focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent ) )
            }


        }  

    
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TopMenu()
{

    var list = listOf<String>("Series","Movies","Manga")

    var curIndex by remember {
        mutableStateOf(0)
    }

    LazyRow()
    {
        items(list.size)
        {index->

            var colo=Color.Transparent
            if(curIndex==index)
            {
                colo=Color.Magenta
            }
            Row() {
                Card(shape = RoundedCornerShape(30), backgroundColor =colo ,modifier = Modifier
                    .height(50.dp)
                    .width(100.dp)
                    , onClick = {curIndex=index}
                ) {
                    Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.background(Color.Transparent)) {
                        Text(text = list[index], fontWeight = FontWeight(700), modifier = Modifier.background(Color.Transparent))
                    }


                }
                Spacer(modifier = Modifier.width(10.dp))
            }
         
        }
    }

}