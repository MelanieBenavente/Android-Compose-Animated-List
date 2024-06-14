package com.melaniadev.fitcare.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.melaniadev.fitcare.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarBackButton(navController: NavController, title: String) {
    CenterAlignedTopAppBar(title = { Text(text = title, style = MaterialTheme.typography.titleLarge) }, navigationIcon = {
        IconButton(onClick = { navController.navigateUp() }) {
            Icon(modifier = Modifier.size(AssistChipDefaults.IconSize),
                painter = painterResource(id = R.drawable.left_btn) ,
                contentDescription = stringResource(
                    R.string.back_content_description
                )
            )
        }
    })
}