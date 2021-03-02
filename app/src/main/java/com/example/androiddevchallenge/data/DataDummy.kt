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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Animal
import com.example.androiddevchallenge.model.Category
import com.example.androiddevchallenge.model.Gender
import com.example.androiddevchallenge.model.Type

class DataDummy {
    companion object {
        fun getPuppies(): List<Animal> {
            return listOf(
                Animal(
                    image = R.drawable.corgi,
                    name = "Nora",
                    gender = Gender.F,
                    race = "Corgi",
                    type = Type.PUPPY
                ),
                Animal(
                    image = R.drawable.jack,
                    name = "Noble",
                    gender = Gender.M,
                    race = "Jack Russell terrier",
                    type = Type.ADULT
                ),
                Animal(
                    image = R.drawable.beagle,
                    name = "George",
                    gender = Gender.F,
                    race = "Beagle",
                    type = Type.ADULT
                ),
                Animal(
                    image = R.drawable.french,
                    name = "Matty",
                    gender = Gender.M,
                    race = "French bulldog",
                    type = Type.PUPPY
                )
            )
        }

        fun getCategories(): List<Category> {
            return listOf(
                Category(
                    image = R.drawable.dog,
                    name = "Dogs",
                ),
                Category(
                    image = R.drawable.cat,
                    name = "Cats",
                ),
                Category(
                    image = R.drawable.bird,
                    name = "Birds",
                ),
                Category(
                    image = R.drawable.rabbit,
                    name = "Rabbits",
                )
            )
        }

        fun getAnimalDummy() =
            Animal(
                image = R.drawable.french,
                name = "Matty",
                gender = Gender.M,
                race = "French bulldog",
                type = Type.PUPPY
            )
    }
}
