package com.example.chessgame.presentation.constraint_layout

import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.chessgame.R


@Preview
@Composable
fun CheeseCakeTypes() {
    ConstraintLayout {

        val (bannerImage, addIcon, cheeseCakeList) = createRefs()

        val guideline = createGuidelineFromTop(fraction = 0.3f)

        Image(
          asset = imageResource(id = R.drawable.banner_cheesecake),
          contentScale = ContentScale.FillWidth,
          modifier = Modifier.constrainAs(bannerImage) {
              linkTo(top = parent.top, bottom = guideline)
          }
        )

        CheeseCakeTitleAndList(modifier = Modifier
          .constrainAs(cheeseCakeList) {
              top.linkTo(bannerImage.bottom)
          })

        Icon(
          asset = vectorResource(id = R.drawable.ic_add_white),
          tint = Color.White,
          modifier = Modifier.size(50.dp)
            .clip(CircleShape)
            .background(Color.DarkGray)
            .constrainAs(addIcon) {
                end.linkTo(bannerImage.end, margin = 16.dp)
                centerAround(bannerImage.bottom)
            }
        )
    }
}

@Composable
fun CheeseCakeTitleAndList(modifier: Modifier) {
    Column(modifier = modifier.background(Color.White)
      .fillMaxSize()
      .padding(start = 10.dp, top = 10.dp)
    ) {
        Text(text = "Cheesecakeler",
          style = MaterialTheme.typography.h4,
          fontFamily = FontFamily.Monospace
        )
        LazyColumnFor(items = cheeseCakeList, modifier = Modifier.padding(top = 10.dp)) { cheeseCake ->
            Row(modifier = Modifier.padding(10.dp)) {
                Image(imageResource(id = cheeseCake.image),
                  contentScale = ContentScale.Crop,
                  modifier = Modifier.size(40.dp).clip(RoundedCornerShape(5.dp))
                )
                Text(text = cheeseCake.name,
                  style = MaterialTheme.typography.h5,
                  fontFamily = FontFamily.Cursive,
                  modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 10.dp)
                )
            }
        }
    }
}


data class CheesecakeItem(@DrawableRes val image: Int, val name: String)

val cheeseCakeList = arrayListOf(
  CheesecakeItem(image = R.drawable.bal_kabakli_cheesecake, "Bal Kabaklı"),
  CheesecakeItem(image = R.drawable.frambuaz_cheesecake, "Frambuazlı"),
  CheesecakeItem(image = R.drawable.karamel_soslu_cheesecake, "Karamel Soslu"),
  CheesecakeItem(image = R.drawable.new_york_usulu_cheesecake, "New York Usulu"),
  CheesecakeItem(image = R.drawable.pismeyen_cheesecake, "Pismeyen Cheesecake"),
  CheesecakeItem(image = R.drawable.balli_bogurtlenli_cheesecake, "Ballı Bögürtlenli"),
  CheesecakeItem(image = R.drawable.san_sebastian_cheesecake, "San Sebastian"),
)
