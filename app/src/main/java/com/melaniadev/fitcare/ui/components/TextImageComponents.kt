package com.melaniadev.fitcare.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.melaniadev.fitcare.ui.theme.iconComponentBackground
import com.melaniadev.fitcare.ui.theme.localCustomColorsPalette

@Composable
fun IconComponent(iconDrawable: Int, contentDescription: String) {
    Box(
        modifier = Modifier
            .background(
                color = iconComponentBackground, shape = RoundedCornerShape(10.dp)
            )
            .size(48.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.Center),
            painter = painterResource(iconDrawable),
            contentDescription = contentDescription,
            tint = Color.Black
        )
    }
}

@Composable
fun PersonalInfoComponent(header: String, bodyFirstLine: String, bodySecondLine: String? = null, bodyThirstLine: String? = null) {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(
            text = header,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = bodyFirstLine,
            style = MaterialTheme.typography.bodySmall,
            color = localCustomColorsPalette.current.customTextColor
        )
        Spacer(modifier = Modifier.size(4.dp))
        bodySecondLine?.let {
            Text(
                text = bodySecondLine, style = MaterialTheme.typography.bodySmall, color = localCustomColorsPalette.current.customTextColor
            )
        }
        Spacer(modifier = Modifier.size(4.dp))
        bodyThirstLine?.let {
            Text(
                text = it, style = MaterialTheme.typography.bodySmall, color = localCustomColorsPalette.current.customTextColor
            )
        }
    }
}

@Composable
fun LeftIconInfoComponent(iconDrawable: Int, contentDescription: String, header: String, body: String ) {
    Row(modifier = Modifier.padding(vertical = 5.dp), verticalAlignment = Alignment.CenterVertically) {
        IconComponent(iconDrawable = iconDrawable, contentDescription = contentDescription)
        PersonalInfoComponent(header = header, bodyFirstLine = body)
    }
}

@Composable
fun LeftImageInfoComponent(imageUrl: String, header: String, body: String) {
    Row( verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier.background(color = Color.Transparent)
        ) {
            AsyncImage(
                contentScale = ContentScale.Crop,
                model = imageUrl,
                contentDescription = "Professional image",
                modifier = Modifier
                    .clip(CircleShape)
                    .height(60.dp)
                    .width(60.dp)
            )
        }
        PersonalInfoComponent(header = header, bodyFirstLine = body)
    }
}
