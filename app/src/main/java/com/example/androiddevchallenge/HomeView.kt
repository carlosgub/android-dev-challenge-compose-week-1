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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.DataDummy
import com.example.androiddevchallenge.model.Animal
import com.example.androiddevchallenge.model.Category
import com.example.androiddevchallenge.model.Type
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.gray
import com.example.androiddevchallenge.ui.theme.grayLight
import com.example.androiddevchallenge.ui.theme.orange
import com.example.androiddevchallenge.ui.theme.orangeLight
import com.example.androiddevchallenge.ui.theme.purple
import com.example.androiddevchallenge.ui.theme.purpleLight

@ExperimentalComposeUiApi
@Composable
fun MyApp(navController: NavController) {
    Surface(color = MaterialTheme.colors.background) {
        Column {
            Toolbar()
            Search()
            Body(navController)
        }
    }
}

@Composable
fun Toolbar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
    ) {
        Card(
            shape = RoundedCornerShape(20.dp),
            backgroundColor = purpleLight,
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp)
                .weight(1f)
        ) {
            Row {
                Icon(
                    Icons.Rounded.LocationOn,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp),
                    tint = purple
                )
                Text(
                    text = "Lima, Peru",
                    style = MaterialTheme.typography.subtitle1.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.Light,
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                )
                Icon(
                    Icons.Outlined.Clear,
                    contentDescription = "Close",
                    modifier = Modifier
                        .padding(8.dp),
                    tint = gray
                )
            }
        }
        Image(
            painter = painterResource(R.drawable.profile),
            contentDescription = "profile",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(36.dp)
                .clip(CircleShape)
        )
    }
}

@ExperimentalComposeUiApi
@Composable
fun Search() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, grayLight),
            backgroundColor = Color.White
        ) {
            Row {
                val (query, setQuery) = remember { mutableStateOf("") }
                val keyboardController = LocalSoftwareKeyboardController.current
                val focusManager = LocalFocusManager.current
                TextField(
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.search_hint),
                            style = TextStyle(color = Color.Black)
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
                    value = query,
                    onValueChange = {
                        setQuery(it)
                    },
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = androidx.compose.ui.text.input.ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hideSoftwareKeyboard()
                            focusManager.clearFocus()
                        },
                    ),
                    modifier = Modifier
                        .background(Color.Transparent)
                        .size(52.dp)
                        .fillMaxWidth()
                        .weight(1f)
                )
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(purple)
                        .size(52.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "Search Button",
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(12.dp),
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun Body(navController: NavController) {
    val lazyListState = rememberLazyListState()
    LazyColumn(
        state = lazyListState
    ) {
        item { Categories() }

        val animals: List<Animal> = DataDummy.getPuppies().toList()
        val rows = animals.size / 2
        for (i in 0 until rows) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    PuppyItem(animals[i * 2], navController)
                    PuppyItem(animals[i * 2 + 1], navController)
                }
            }
        }
    }
}

@Composable
fun Categories() {
    LazyRow(
        modifier = Modifier
            .padding(start = 6.dp)
            .clickable { }
    ) {
        items(DataDummy.getCategories().toList()) {
            CategoriesItem(
                category = it
            )
        }
    }
}

@Composable
fun CategoriesItem(category: Category) {
    Column(
        modifier = Modifier
            .padding(6.dp)
    ) {
        Card(
            border = BorderStroke(1.dp, grayLight),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .size(72.dp)
        ) {
            Icon(
                painter = painterResource(category.image),
                contentDescription = "Image",
                tint = gray,
                modifier = Modifier
                    .padding(14.dp)
            )
        }

        Text(
            text = category.name,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(top = 4.dp),
            style = MaterialTheme.typography.subtitle1.copy(
                fontWeight = FontWeight.Normal
            )
        )
    }
}

@Composable
fun PuppyItem(animal: Animal, navController: NavController) {
    Card(
        modifier = Modifier
            .size(height = 270.dp, width = 200.dp)
            .fillMaxWidth()
            .padding(start = 12.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
            .clickable {
                navController.currentBackStackEntry
                    ?.arguments?.putParcelable("animal", animal)
                navController.navigate("detail")
            },
        shape = RoundedCornerShape(20.dp)
    ) {
        Column {
            Image(
                painter = painterResource(animal.image),
                contentDescription = "profile",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(width = 200.dp, height = 140.dp)
                    .fillMaxWidth()
            )
            val color = if (animal.type == Type.PUPPY) purpleLight else orangeLight
            val colorText = if (animal.type == Type.PUPPY) purple else orange
            Card(
                modifier = Modifier
                    .padding(start = 12.dp, top = 8.dp, end = 8.dp)
                    .size(width = 80.dp, height = 20.dp)
                    .wrapContentSize(Alignment.Center),
                backgroundColor = color,
                shape = RoundedCornerShape(10.dp),
            ) {
                Text(
                    text = animal.type.text,
                    color = colorText,
                    modifier = Modifier
                        .padding(top = 2.dp)
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    style = MaterialTheme.typography.overline.copy(
                        fontWeight = FontWeight.Normal
                    ),
                    textAlign = TextAlign.Center
                )
            }

            Text(
                text = animal.name,
                modifier = Modifier
                    .padding(top = 12.dp, start = 12.dp)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.subtitle1.copy(
                    fontWeight = FontWeight.Medium
                )
            )

            Text(
                text = animal.race,
                modifier = Modifier
                    .padding(top = 12.dp, start = 12.dp)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.subtitle2.copy(
                    fontWeight = FontWeight.Normal
                )
            )
        }
    }
}

@Preview
@Composable
fun CategoriesItemPreview() {
    MyTheme {
        CategoriesItem(Category(R.drawable.dog, "Dogs"))
    }
}

@ExperimentalComposeUiApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp(rememberNavController())
    }
}

@ExperimentalComposeUiApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp(rememberNavController())
    }
}
