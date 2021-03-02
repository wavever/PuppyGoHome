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
package com.example.androiddevchallenge

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.Puppy
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import java.io.InputStreamReader

class HomeViewModel : ViewModel() {

    fun getPuppys(context: Context): List<Puppy> {
        val stream = context.assets.open("puppy_data.json")
        return Gson().fromJson(JsonReader(InputStreamReader(stream)), object : TypeToken<List<Puppy>>() {}.type)
    }
}
