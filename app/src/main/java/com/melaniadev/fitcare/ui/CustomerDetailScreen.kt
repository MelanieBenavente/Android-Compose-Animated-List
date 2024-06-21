package com.melaniadev.fitcare.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.melaniadev.fitcare.R
import com.melaniadev.fitcare.ui.components.ActionButtonsComponent
import com.melaniadev.fitcare.ui.components.LeftIconInfoComponent
import com.melaniadev.fitcare.ui.components.LeftImageInfoComponent
import com.melaniadev.fitcare.ui.components.TopBarBackButton
import com.melaniadev.fitcare.ui.theme.localCustomColorsPalette

val visitHistoryMocked = listOf(
    Visit(
        typeOfVisit = "Massage Therapy", date = "12/2/22"
    ), Visit(
        typeOfVisit = "Acupunture", date = "25/03/25"
    )
)

val mockedCustomer = Customer(
    customerName = "Ava Smith",
    lastVisit = null,
    nextVisit = null,
    professional = Professional("Dr. Mathews", Therapy.PHYSICAL, null),
    gender = Gender.FEMALE,
    age = "32",
    weight = "42",
    height = "1.50",
    email = "lavienvert@gmail.com",
    phone = "635 23 96 35",
    imageUrl = "https://picsum.photos/200/300",
    visitHistory = visitHistoryMocked
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailPreview() {
    val navigationController = rememberNavController()
    DetailCustomerScreen(navigationController = navigationController, "")
}

@Composable
fun DetailCustomerScreen(navigationController: NavHostController, name: String) {
    Scaffold(topBar = {
        TopBarBackButton(
            navigationController, title = stringResource(R.string.user_profile_top_bar_title)
        )
    }, content = { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 20.dp, vertical = 15.dp)
        ) {
            DetailScreenUserImage(customer = mockedCustomer)
            InfoBioComponent(customer = mockedCustomer)
            ActionButtonsComponent(navigationController = navigationController)
            mockedCustomer.email?.let { LeftIconInfoComponent(iconDrawable = R.drawable.email_vector, contentDescription = "Email", header = "Email", body = it) }
            mockedCustomer.phone?.let { LeftIconInfoComponent(iconDrawable = R.drawable.phone_vector, contentDescription = "Phone number", header = "Phone", body = it) }
            Text(text = "Assigned Professional", style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(vertical = 10.dp))
            mockedCustomer.professional.therapyType?.let {
                LeftImageInfoComponent(imageUrl = "https://picsum.photos/200/300", header = mockedCustomer.professional.name,
                                       body = it.therapyType)
            }
        }

    })
}

@Composable
fun DetailScreenUserImage(customer: Customer) {
    Box(
        modifier = Modifier.background(color = Color.Transparent)
    ) {
        AsyncImage(
            contentScale = ContentScale.Crop,
            model = customer.imageUrl,
            contentDescription = "Image profile",
            modifier = Modifier
                .clip(CircleShape)
                .height(115.dp)
                .width(115.dp)
        )
    }
}

@Composable
fun InfoBioComponent(customer: Customer) {
    Column(modifier = Modifier.padding(vertical = 10.dp)) {
        Text(
            text = customer.name, style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = customer.gender.genderType + ", " + customer.age + " years old",
            style = MaterialTheme.typography.bodyMedium,
            color = localCustomColorsPalette.current.customTextColor

        )
        Text(
            text = customer.height + " cm" + " | " + customer.weight + " kg",
            style = MaterialTheme.typography.bodyMedium,
            color = localCustomColorsPalette.current.customTextColor
        )
    }
}



