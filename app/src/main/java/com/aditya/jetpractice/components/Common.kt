package com.aditya.jetpractice.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicScaffold(
    title: String,
    contents: @Composable (innerPadding: PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = title) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->
        contents(innerPadding)
    }
}


@Composable
fun GarbageContent(
    modifier: Modifier
) {
    Text(
        text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        modifier = modifier,
        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
    )
}


val imageUrls = listOf(
    "https://placekitten.com/200/300",
    "https://placebear.com/250/250",
    "https://loremflickr.com/320/240",
    "https://source.unsplash.com/random/300x200",
    "https://www.picsum.photos/300/200",
    "https://picsum.photos/300/200",
    "https://loremflickr.com/300/200",
    "https://source.unsplash.com/300x200/?nature",
    "https://www.picsum.photos/300/200/?random",
    "https://placebear.com/300/200",
    "https://loremflickr.com/300/200",
    "https://source.unsplash.com/300x200/?nature",
    "https://source.unsplash.com/300x200/?city",
    "https://source.unsplash.com/300x200/?technology",
    "https://source.unsplash.com/300x200/?office",
    "https://source.unsplash.com/300x200/?travel",
    "https://source.unsplash.com/300x200/?work",

    // RESNET50_IMAGE_URLS
    "https://i.imgur.com/CzXTtJV.jpg",
    "https://i.imgur.com/OB0y6MR.jpg",
    "https://farm2.staticflickr.com/1533/26541536141_41abe98db3_z_d.jpg",
    "https://farm4.staticflickr.com/3075/3168662394_7d7103de7d_z_d.jpg",
    "https://farm9.staticflickr.com/8505/8441256181_4e98d8bff5_z_d.jpg",
    "https://i.imgur.com/OnwEDW3.jpg",
    "https://farm3.staticflickr.com/2220/1572613671_7311098b76_z_d.jpg",
    "https://farm6.staticflickr.com/5590/14821526429_5c6ea60405_z_d.jpg",
    "https://farm7.staticflickr.com/6089/6115759179_86316c08ff_z_d.jpg",
    "https://farm2.staticflickr.com/1090/4595137268_0e3f2b9aa7_z_d.jpg",
    "https://farm4.staticflickr.com/3224/3081748027_0ee3d59fea_z_d.jpg",
    "https://farm8.staticflickr.com/7377/9359257263_81b080a039_z_d.jpg",
    "https://farm9.staticflickr.com/8295/8007075227_dc958c1fe6_z_d.jpg",
    "https://farm2.staticflickr.com/1449/24800673529_64272a66ec_z_d.jpg",
    "https://farm4.staticflickr.com/3752/9684880330_9b4698f7cb_z_d.jpg",
    "https://farm4.staticflickr.com/3827/11349066413_99c32dee4a_z_d.jpg",

    // SQUEEZENET_IMAGE_URLS
    "https://i.imgur.com/CzXTtJV.jpg",
    "https://i.imgur.com/OB0y6MR.jpg",
    "https://farm4.staticflickr.com/3852/14447103450_2d0ff8802b_z_d.jpg",
    "https://farm2.staticflickr.com/1533/26541536141_41abe98db3_z_d.jpg",
    "https://farm4.staticflickr.com/3075/3168662394_7d7103de7d_z_d.jpg",
    "https://i.imgur.com/OnwEDW3.jpg",
    "https://farm3.staticflickr.com/2220/1572613671_7311098b76_z_d.jpg",
    "https://farm6.staticflickr.com/5590/14821526429_5c6ea60405_z_d.jpg",
    "https://farm7.staticflickr.com/6089/6115759179_86316c08ff_z_d.jpg",

    "https://www.kasandbox.org/programming-images/avatars/leaf-blue.png",
    "https://www.kasandbox.org/programming-images/avatars/leaf-green.png",
    "https://www.kasandbox.org/programming-images/avatars/leaf-grey.png",
    "https://www.kasandbox.org/programming-images/avatars/leaf-orange.png",
    "https://www.kasandbox.org/programming-images/avatars/leaf-red.png",
    "https://www.kasandbox.org/programming-images/avatars/leaf-yellow.png",
    "https://www.kasandbox.org/programming-images/avatars/cs-hopper-happy.png",
    "https://www.kasandbox.org/programming-images/avatars/cs-hopper-cool.png",
    "https://www.kasandbox.org/programming-images/avatars/leafers-seed.png",
    "https://www.kasandbox.org/programming-images/avatars/leafers-seedling.png",
    "https://www.kasandbox.org/programming-images/avatars/leafers-sapling.png",
    "https://www.kasandbox.org/programming-images/avatars/leafers-tree.png",
    "https://www.kasandbox.org/programming-images/avatars/leafers-ultimate.png",
    "https://www.kasandbox.org/programming-images/avatars/piceratops-seed.png",
    "https://www.kasandbox.org/programming-images/avatars/piceratops-seedling.png",
    "https://www.kasandbox.org/programming-images/avatars/piceratops-sapling.png",
    "https://www.kasandbox.org/programming-images/avatars/piceratops-tree.png",
    "https://www.kasandbox.org/programming-images/avatars/piceratops-ultimate.png",
    "https://www.kasandbox.org/programming-images/avatars/aqualine-seed.png",
    "https://www.kasandbox.org/programming-images/avatars/aqualine-seedling.png",
    "https://www.kasandbox.org/programming-images/avatars/aqualine-sapling.png",
    "https://www.kasandbox.org/programming-images/avatars/aqualine-tree.png",
    "https://www.kasandbox.org/programming-images/avatars/aqualine-ultimate.png",
    "https://www.kasandbox.org/programming-images/avatars/starky-seed.png",
    "https://www.kasandbox.org/programming-images/avatars/starky-seedling.png",
    "https://www.kasandbox.org/programming-images/avatars/starky-sapling.png",
    "https://www.kasandbox.org/programming-images/avatars/starky-tree.png",
    "https://www.kasandbox.org/programming-images/avatars/starky-ultimate.png",
    "https://www.kasandbox.org/programming-images/avatars/primosaur-seed.png",
    "https://www.kasandbox.org/programming-images/avatars/primosaur-seedling.png",
    "https://www.kasandbox.org/programming-images/avatars/primosaur-sapling.png",
    "https://www.kasandbox.org/programming-images/avatars/primosaur-tree.png",
    "https://www.kasandbox.org/programming-images/avatars/primosaur-ultimate.png",
    "https://www.kasandbox.org/programming-images/avatars/duskpin-seed.png",
    "https://www.kasandbox.org/programming-images/avatars/duskpin-seedling.png",
    "https://www.kasandbox.org/programming-images/avatars/duskpin-sapling.png",
    "https://www.kasandbox.org/programming-images/avatars/duskpin-tree.png",
)
