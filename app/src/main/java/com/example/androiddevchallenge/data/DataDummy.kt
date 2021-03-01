package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.Categories
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Animal
import com.example.androiddevchallenge.model.Category
import com.example.androiddevchallenge.model.Gender
import com.example.androiddevchallenge.model.Type

class DataDummy{
    companion object{
        fun getPuppies():List<Animal>{
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

        fun getCategories():List<Category>{
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
    }
}