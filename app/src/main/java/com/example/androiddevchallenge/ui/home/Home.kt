/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.home

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.HomeViewModel
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.util.ImageUtils
import com.example.androiddevchallenge.util.Pager
import com.example.androiddevchallenge.util.PagerState

@Composable
fun Home(context: Context) {
    val homeModel = viewModel(HomeViewModel::class.java)
    Surface(Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            HomeAppBar(context)
            Spacer(Modifier.height(16.dp))
            PuppyListPage(context, homeModel.getPuppys(context))
        }
    }
}

@Composable
fun HomeAppBar(context: Context) {
    val appBarColor = MaterialTheme.colors.primary.copy(alpha = 0.87f)
    TopAppBar(
        title = {},
        backgroundColor = appBarColor,
        contentColor = contentColorFor(backgroundColor),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun PuppyListPage(context: Context, puppys: List<Puppy>) {
    val pagerState: PagerState = remember { PagerState() }
    pagerState.maxPage = (puppys.size - 1).coerceAtLeast(0)
    Pager(
        state = pagerState,
        modifier = Modifier
            .padding(start = 24.dp, top = 16.dp, end = 24.dp)
            .fillMaxSize()
    ) {
        PuppyItemCard(context, puppys[page], page == 0, page == puppys.size - 1)
    }
}

@Composable
private fun PuppyItemCard(context: Context, puppy: Puppy, first: Boolean, end: Boolean) {
    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .fillMaxWidth(.8f)
            .fillMaxHeight(.8f)
            .padding(
                start = if (first) 7.dp else 5.dp,
                top = 15.dp,
                end = if (end) 10.dp else 5.dp,
                bottom = 15.dp
            )
            .clickable {
                Intent("com.wavever.puppygohome.DetailActivity").apply {
                    putExtra("puppy", puppy)
                    context.startActivity(this)
                }
            }
    ) {
        Column {
            Image(
                painter = painterResource(id = ImageUtils.getResId(puppy.name)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
            )
            Text(
                text = puppy.name,
                color = MaterialTheme.colors.primary,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center, fontFamily = FontFamily.SansSerif
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(7.dp)
            )
            Row {
                Text(
                    text = "${puppy.age} · ",
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "${puppy.weight} · ",
                    textAlign = TextAlign.Center
                )
                Text(
                    text = puppy.gender,
                    color = if (puppy.isMale()) Color.Blue else Color.Red,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
