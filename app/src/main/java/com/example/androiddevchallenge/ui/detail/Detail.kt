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
package com.example.androiddevchallenge.ui.detail

import android.text.TextUtils
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.util.ImageUtils

@Composable
fun Detail(puppy: Puppy) {
    val listState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(listState)
    ) {
        Image(
            painter = painterResource(id = ImageUtils.getResId(puppy.name)),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Text(
            text = puppy.name,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h5
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp)
        ) {
            Text(text = puppy.variety)
            Text(text = " · ${puppy.location}")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp)
        ) {
            Text(text = puppy.age)
            Text(text = " · ${puppy.gender}")
            Text(text = " · ${puppy.weight}")
        }
        if (!TextUtils.isEmpty(puppy.color)) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp),
                text = "COLOR",
                style = MaterialTheme.typography.h6
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp),
                text = puppy.color
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
        if (!TextUtils.isEmpty(puppy.health)) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp),
                text = "HEALTH",
                style = MaterialTheme.typography.h6
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp),
                text = puppy.health
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
        if (!TextUtils.isEmpty(puppy.goodIn)) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp),
                text = "GOOD IN A HOME WITH",
                style = MaterialTheme.typography.h6
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp),
                text = puppy.goodIn
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
        if (!TextUtils.isEmpty(puppy.notGoodIn)) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp),
                text = "GOOD IN A HOME WITHOUT",
                style = MaterialTheme.typography.h6
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp),
                text = puppy.notGoodIn
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
        if (!TextUtils.isEmpty(puppy.introduce)) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp),
                text = "MEET ${puppy.name}",
                style = MaterialTheme.typography.h6
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp),
                text = puppy.introduce
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
        if (!TextUtils.isEmpty(puppy.phone) or !TextUtils.isEmpty(puppy.eMail)) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp),
                text = "ADOPT ME ${puppy.name}",
                style = MaterialTheme.typography.h6
            )
            if (!TextUtils.isEmpty(puppy.phone)) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp),
                    text = puppy.phone
                )
            }
            if (!TextUtils.isEmpty(puppy.eMail)) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp),
                    text = puppy.eMail
                )
            }
        }
    }
}
