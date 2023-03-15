package com.example.instagram_profile_ui.ui.theme

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram_profile_ui.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun InstagramProfile () {

    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {

        TopPart(modifier = Modifier, name = "dipankar_khatiwada08")
        Spacer(modifier = Modifier.height(10.dp))
        ProfileDetail()
        Spacer(modifier = Modifier.height(10.dp))
        ProfilesButtons()
        Spacer(modifier = Modifier.height(10.dp))
        StoryHighlights(
            highlights = listOf(
                Highlights(painterResource(id = R.drawable.dp), "\uD83C\uDDF3\uD83C\uDDF5"),
                Highlights(painterResource(id = R.drawable.ic_round_add_24), "New"),
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        PostTabView(
            imageWithTexts = listOf(
                TabIcons(painterResource(id = R.drawable.ic_outline_grid_on_24), "Grid"),
                TabIcons(painterResource(id = R.drawable.ic_outline_account_box_24), "Grid"),
            ),
        ) {
            selectedTabIndex = it
        }

        when (selectedTabIndex) {
            0 -> Posts(
                    posts = listOf(
                        painterResource(id = R.drawable.spurs),
                        painterResource(id = R.drawable.son_kane),
                        painterResource(id = R.drawable.kane),
                        painterResource(id = R.drawable.coys),
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
        }
    }
}

@Composable
fun TopPart(
    modifier: Modifier,
    name: String,

) {

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_outline_lock_24),
            contentDescription = "Lock",
            modifier = modifier.size(24.dp),
            tint = Color.Black
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp

        )
        Icon(
            painter = painterResource(id = R.drawable.ic_outline_add_box_24),
            contentDescription = "Lock",
            modifier = modifier
                .size(24.dp)
                .clip(RoundedCornerShape(18.dp)),
            tint = Color.Black
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_outline_menu_24),
            contentDescription = "Lock",
            modifier = modifier.size(24.dp),
            tint = Color.Black
        )
    }
}

@Composable
fun ProfileDetail() {

    Column(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
        ) {

            ProfilePicture(
                painterResource(id = R.drawable.dp),
                modifier = Modifier.weight(3f)
            )
            Spacer(modifier = Modifier.width(10.dp))
            ProfileStats(modifier = Modifier.weight(7f))
        }
        Description(
            name = "Dipankar Upadhyaya\uD83C\uDDF3\uD83C\uDDF5",
            bio = "Just another Homo Sapiens who live on a rock floating in air"
        )
    }

}

@Composable
fun ProfilePicture(
    image: Painter,
    modifier: Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier
            .size(100.dp)
            .padding(2.dp)
            .clip(CircleShape)
            .border(
                shape = CircleShape,
                width = 1.dp,
                color = Color.Gray
            )
    )
}

@Composable
fun ProfileStats(modifier: Modifier) {

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Statistics("4", "Posts")
        Statistics("440", "Followers")
        Statistics("437", "Following")
    }
}

@Composable
fun Statistics(num: String, type: String) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
       Text(
           text = num,
           fontSize = 20.sp,
           fontWeight = FontWeight.Bold
       )
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            text = type,
            fontSize = 14.sp,
        )
    }
}

@Composable
fun Description(
    name: String,
    bio: String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 8.dp,
                top = 6.dp
            )
    ) {
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(4.dp))

        Text(text = bio)
    }
}

@Composable
fun ProfilesButtons() {

    val buttonWidth = 150
    val buttonHeight = 36
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        ButtonsCompose("Edit Profile",buttonWidth,buttonHeight)
        ButtonsCompose("Share Profile",buttonWidth,buttonHeight)

        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.LightGray
            ),
            modifier = Modifier.size(36.dp),
            onClick = { /*TODO*/ }) {

            androidx.compose.material.Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_outline_person_add_24),
                contentDescription = null,
                modifier = Modifier.scale(4f)
            )
        }
    }
}

@Composable
fun ButtonsCompose(title: String, width: Int, height: Int) {

    Button(

        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.LightGray
        ),
        modifier = Modifier
            .width(width = width.dp)
            .height(height.dp),
        onClick = { /*TODO*/ }) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(2.dp),
        ) {
            Text(
                text = title,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold
                )
        }
    }
}

@Composable
fun StoryHighlights(
    highlights: List<Highlights>
) {
    LazyRow(modifier = Modifier
        .fillMaxWidth()
        .padding(end = 20.dp)
    ) {
        items(highlights.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(horizontal = 13.dp)
            ) {
                Stories(highlights[it].image)
                Text(text = highlights[it].text)
            }
        }
    }
}

@Composable
fun Stories(painter: Painter) {
    Box(modifier = Modifier
        .size(66.dp)
        .clip(CircleShape)
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    shape = CircleShape,
                    color = Color.LightGray
                )
        )
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithTexts: List<TabIcons>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithTexts.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }
            ) {

                Icon(
                    painter = item.image,
                    contentDescription = item.content,
                    tint = if(selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun Posts(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier
            .scale(1.01f)
    ) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}