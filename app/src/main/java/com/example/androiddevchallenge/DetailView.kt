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

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.gray
import com.example.androiddevchallenge.ui.theme.grayLight
import com.example.androiddevchallenge.ui.theme.purple
import com.example.androiddevchallenge.ui.theme.purpleLight

@ExperimentalComposeUiApi
@Composable
fun DetailApp() {
    Surface(color = MaterialTheme.colors.background) {
        LazyColumn {
            item {
                Image(
                    painter = painterResource(R.drawable.corgi_large),
                    contentDescription = "profile",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(300.dp)
                        .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
                )
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    InfoCard(
                        title = "Age",
                        description = "3 months"
                    )
                    InfoCard(
                        title = "Weight",
                        description = "2 kg"
                    )
                    InfoCard(
                        title = "Sex",
                        description = "Female"
                    )
                }
            }

            item { Description() }

            item { ButtonBottom() }
        }
    }
}

@Composable
fun InfoCard(title: String, description: String) {
    Card(
        border = BorderStroke(1.dp, grayLight),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .padding(4.dp)
            .defaultMinSize(minWidth = 120.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                modifier = Modifier
                    .padding(top = 8.dp),
                style = MaterialTheme.typography.subtitle1.copy(
                    fontWeight = FontWeight.Light
                )
            )
            Text(
                text = description,
                modifier = Modifier
                    .padding(bottom = 8.dp, top = 8.dp, start = 8.dp, end = 8.dp),
                style = MaterialTheme.typography.subtitle1.copy(
                    fontWeight = FontWeight.Medium,
                )
            )
        }
    }
}

@Composable
fun Description() {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Row {
            Text(
                text = "Nora",
                style = MaterialTheme.typography.subtitle1.copy(
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(
                modifier = Modifier
                    .weight(1f)
            )
            Text(
                text = "Corgi",
                style = MaterialTheme.typography.subtitle1
            )
        }
        Row(
            modifier = Modifier
                .padding(top = 8.dp)
        ) {
            Icon(
                Icons.Outlined.LocationOn,
                contentDescription = null,
                tint = gray
            )
            Text(
                text = "Lima, Peru",
                color = gray
            )
        }

        Text(
            text = "About",
            modifier = Modifier
                .padding(top = 8.dp),
            style = MaterialTheme.typography.subtitle1.copy(
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = stringResource(id = R.string.pet_description),
            modifier = Modifier
                .padding(top = 8.dp),
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Composable
fun ButtonBottom() {
    Row(
        modifier = Modifier
            .padding(start = 12.dp, end = 12.dp,bottom =12.dp)
    ) {
        Button(
            onClick = {},
            modifier = Modifier
                .padding(end = 8.dp)
                .weight(1f)
                .clip(RoundedCornerShape(20.dp))
                .background(purple)
        ) {
            Text(
                text = "Adopt",
                modifier = Modifier.padding(8.dp)
            )
        }
        Button(
            onClick = {},
            modifier = Modifier
                .padding(end = 8.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(purpleLight)
        ) {
            Icon(
                Icons.Filled.Phone,
                contentDescription = null,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}


@ExperimentalComposeUiApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightDetailPreview() {
    MyTheme {
        DetailApp()
    }
}

@ExperimentalComposeUiApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkDetailPreview() {
    MyTheme(darkTheme = true) {
        DetailApp()
    }
}

